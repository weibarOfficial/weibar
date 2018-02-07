package com.weibar.service.function;

import com.google.common.collect.Lists;
import com.weibar.pojo.consts.WebSocketConsts;
import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.db.WeibarMerchantsBarrageInfo;
import com.weibar.pojo.db.WeibarMerchantsBarrageInfoCriteria;
import com.weibar.pojo.db.WeibarRedpackageDepositDetail;
import com.weibar.pojo.enu.BarrageStatusEnum;
import com.weibar.pojo.enu.MessageTypeEnum;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BarrageInfo;
import com.weibar.pojo.result.UserRedPackage;
import com.weibar.service.mapper.WeibarMerchantsBarrageInfoMapper;
import com.weibar.utils.JsonConverter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Administrator on 2017/10/30.
 */
@Service
public class BarrageService {

    @Autowired
    private WeibarMerchantsBarrageInfoMapper weibarMerchantsBarrageInfoMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private WsCacheService wsCacheService;

    @Autowired
    private RedPackageService redPackageService;





    public WeibarMerchantsBarrageInfo getBarrageById(Long messageId) throws BaseException {
        WeibarMerchantsBarrageInfoCriteria weibarMerchantsBarrageInfoCriteria = new WeibarMerchantsBarrageInfoCriteria();
        WeibarMerchantsBarrageInfoCriteria.Criteria criteria = weibarMerchantsBarrageInfoCriteria.createCriteria();
        criteria.andIdEqualTo(messageId);
        List<WeibarMerchantsBarrageInfo> list = weibarMerchantsBarrageInfoMapper.selectByExample(weibarMerchantsBarrageInfoCriteria);
        if(list == null || list.size() == 0){
            throw BaseException.getException(ErrorCodeEnum.BARRAGE_BARRAGE_NOT_EXIST.getCode());
        }
        return list.get(0);
    }

    public void updateBarrage(WeibarMerchantsBarrageInfo barrageInfo) throws BaseException {
        weibarMerchantsBarrageInfoMapper.updateByPrimaryKey(barrageInfo);
        doSendWs(barrageInfo);
    }

    public void deleteBarrage(Long messageId,String openId,Long merchantId) throws BaseException {
        WeibarMerchantsBarrageInfoCriteria weibarMerchantsBarrageInfoCriteria = new WeibarMerchantsBarrageInfoCriteria();
        WeibarMerchantsBarrageInfoCriteria.Criteria criteria = weibarMerchantsBarrageInfoCriteria.createCriteria();
        criteria.andIdEqualTo(messageId);
        criteria.andOpenidEqualTo(openId);
        criteria.andMerchantidEqualTo(merchantId);
        List<WeibarMerchantsBarrageInfo> list = weibarMerchantsBarrageInfoMapper.selectByExample(weibarMerchantsBarrageInfoCriteria);
        if(list == null || list.size() == 0){
            throw BaseException.getException(ErrorCodeEnum.BARRAGE_BARRAGE_NOT_EXIST.getCode());
        }
        WeibarMerchantsBarrageInfo info = list.get(0);
        info.setStatus(BarrageStatusEnum.DELETED.getState());
        weibarMerchantsBarrageInfoMapper.updateByPrimaryKey(info);
        doSendWs(info);
    }


    /**
     * 获取消息列表
     * @param endTime
     * @param merchantId
     * @param userId (可以传null，表示这是pc端接口，没有登录态）
     * @return
     * @throws BaseException
     */
    public List<BarrageInfo> getBarrageList(Long endTime, Long beginTime ,Integer count, Long merchantId,Long userId) throws BaseException {


        if((endTime == null && beginTime == null) || (beginTime != null && endTime != null)){
            throw BaseException.getException(ErrorCodeEnum.BARRAGE_PARAM_ERROR.getCode());
        }

        List<WeibarMerchantsBarrageInfo> merchantsBarrageInfoList = getBarrageListFromDb(endTime,beginTime,count,merchantId);


        List<BarrageInfo> barrageInfoList = new ArrayList<>();
        for(WeibarMerchantsBarrageInfo info : merchantsBarrageInfoList){

            //领取红包消息特殊判断
            if( info.getType().equals(MessageTypeEnum.RED_BAG_GET.getType())){
                //没有传参数的情况 pc端情况
                if(userId == null){
                    continue;
                }
                //不是他发的红包略过
                if(info.getRedpackageGiveUserId() == null || !info.getRedpackageGiveUserId().equals(userId)){
                    continue;
                }
                //是他自己领取自己的红包略过
                if(info.getUserId().equals(userId)){
                    continue;
                }
            }
            BarrageInfo barrageInfo = BarrageInfo.formBarrageInfo(info);

            //如果是红包消息，需要补充红包相关信息
            if(info.getType().equals(MessageTypeEnum.RED_BAG.getType())){
                WeibarRedpackageDepositDetail depositDetail =  redPackageService.getUserRedPackageDetail(barrageInfo.getRedPackageId(),userId);
                if(depositDetail != null){
                    barrageInfo.setUserRedPackage(UserRedPackage.getUserRedPackage(depositDetail));
                }
            }
            barrageInfoList.add(barrageInfo);
        }
        return barrageInfoList;

    }



    /**
     *
     *@param beginTime 开始时间
     * @param endTime 最后时间
     * @param count 条数
     * @param merchantId 商户ID
     *
     * @return
     */
    public List<WeibarMerchantsBarrageInfo> getBarrageListFromDb(Long endTime,Long beginTime ,Integer count, Long merchantId){

        WeibarMerchantsBarrageInfoCriteria weibarMerchantsBarrageInfoCriteria = new WeibarMerchantsBarrageInfoCriteria();
        WeibarMerchantsBarrageInfoCriteria.Criteria criteria = weibarMerchantsBarrageInfoCriteria.createCriteria();

        if(endTime != null){
            criteria.andCreateTimeLessThan(new Date(endTime));
        }else{
            criteria.andCreateTimeGreaterThan(new Date(beginTime));
        }

        criteria.andStatusNotEqualTo(BarrageStatusEnum.NOT_SHOW.getState());
        criteria.andStatusNotEqualTo(BarrageStatusEnum.DELETED.getState());
        criteria.andMerchantidEqualTo(merchantId);
        weibarMerchantsBarrageInfoCriteria.setLimit(count);

        if(endTime != null) {
            weibarMerchantsBarrageInfoCriteria.setOrderByClause(" create_time desc ");
        }else{
            weibarMerchantsBarrageInfoCriteria.setOrderByClause(" create_time asc ");
        }

        List<WeibarMerchantsBarrageInfo> merchantsBarrageInfoList = weibarMerchantsBarrageInfoMapper.selectByExample(weibarMerchantsBarrageInfoCriteria);

        if(endTime != null){
            return Lists.reverse(merchantsBarrageInfoList);
        }else {
            return merchantsBarrageInfoList;
        }

    }

    /**
     * 用户删除自己的消息
     * @param id
     * @param merchantId
     * @param userId
     */
    public void deleteBarrageInfo(Long id,Long merchantId,Long userId){

        WeibarMerchantsBarrageInfoCriteria weibarMerchantsBarrageInfoCriteria = new WeibarMerchantsBarrageInfoCriteria();
        WeibarMerchantsBarrageInfoCriteria.Criteria criteria = weibarMerchantsBarrageInfoCriteria.createCriteria();

        criteria.andIdEqualTo(id);
        criteria.andMerchantidEqualTo(merchantId);
        criteria.andUserIdEqualTo(userId);

        weibarMerchantsBarrageInfoMapper.deleteByExample(weibarMerchantsBarrageInfoCriteria);
    }


    /**
     * 为尾灯信息填充用户相关信息
     * @param openId
     * @param info
     * @throws BaseException
     */
    private void addUserInfoForBarrageInfo(String openId,WeibarMerchantsBarrageInfo info) throws BaseException {
        UserBaseInfo userBaseInfo = userService.getUserByOpenId(openId);
        info.setUserId(userBaseInfo.getUserId());
        info.setSex(userBaseInfo.getSex());
        info.setUserPicture(userBaseInfo.getUserPicture());
        info.setNickname(userBaseInfo.getNickname());
        info.setUserLevel(userBaseInfo.getUserLevel());
        info.setOpenid(openId);
    }


    /**
     * 新增文字消息
     * @param merchantId
     * @param openId
     * @param context
     * @throws BaseException
     */
    public BarrageInfo addNewWordBarrageInfo(Long merchantId,String openId,String context) throws BaseException {

        WeibarMerchantsBarrageInfo info = new WeibarMerchantsBarrageInfo();
        addUserInfoForBarrageInfo(openId,info);
        info.setMerchantid(merchantId);
        Date now = new Date();
        info.setUpdateTime(now);
        info.setCreateTime(now);
        info.setType(MessageTypeEnum.WORDS.getType());
        info.setContext(context);
        info.setStatus(BarrageStatusEnum.NOT_BA.getState());
        return doAddNewBarrage(info);

    }


    public BarrageInfo addNewUserOpenRedpackageInfo(Long merchantId, String openId,
                                                    String giveOpenId, Long giveUserId, BigDecimal amount) throws BaseException {
        WeibarMerchantsBarrageInfo info = new WeibarMerchantsBarrageInfo();
        addUserInfoForBarrageInfo(openId,info);
        info.setMerchantid(merchantId);
        Date now = new Date();
        info.setUpdateTime(now);
        info.setCreateTime(now);
        info.setType(MessageTypeEnum.RED_BAG_GET.getType());
        info.setStatus(BarrageStatusEnum.NOT_BA.getState());
        info.setRedpackageGiveOpenid(giveOpenId);
        info.setRedpackageGiveUserId(giveUserId);
        info.setRedpackageAmount(amount);
        return doAddNewBarrage(info);
    }


    /**
     * 新增图片消息
     * @param merchantId
     * @param openId
     * @param imgUrl
     * @throws BaseException
     */
    public BarrageInfo addNewPicBarrageInfo(Long merchantId,String openId,String imgUrl) throws BaseException {
        WeibarMerchantsBarrageInfo info = new WeibarMerchantsBarrageInfo();
        addUserInfoForBarrageInfo(openId,info);
        info.setMerchantid(merchantId);
        Date now = new Date();
        info.setUpdateTime(now);
        info.setCreateTime(now);
        info.setType(MessageTypeEnum.PHOTO.getType());
        info.setImgUrl(imgUrl);
        info.setStatus(BarrageStatusEnum.NOT_BA.getState());
        return doAddNewBarrage(info);
    }



    public BarrageInfo addNotShowBarrageInfo(Long merchantId,String openId,String imgUrl,String content) throws BaseException {

        WeibarMerchantsBarrageInfo info = new WeibarMerchantsBarrageInfo();
        addUserInfoForBarrageInfo(openId,info);
        info.setMerchantid(merchantId);
        Date now = new Date();
        info.setUpdateTime(now);
        info.setCreateTime(now);


        if(content == null && imgUrl == null){
            throw BaseException.getException(ErrorCodeEnum.BARPING_ERROR_NOT_SUPPORT_TYPE.getCode());
        }

        if(content != null && imgUrl != null){
            info.setType(MessageTypeEnum.WORDS_AND_PHOTO.getType());
        }else if (content != null){
            info.setType(MessageTypeEnum.WORDS.getType());
        }else{
            info.setType(MessageTypeEnum.PHOTO.getType());
        }

        info.setContext(content);
        info.setImgUrl(imgUrl);
        info.setStatus(BarrageStatusEnum.NOT_SHOW.getState());
        return doAddNewBarrage(info);

    }


    /**
     * 新增图文消息
     * @param merchantId
     * @param openId
     * @param imgUrl
     * @throws BaseException
     */
    public BarrageInfo addNewWordsAndPicBarrageInfo(Long merchantId,String openId,String imgUrl,String content) throws BaseException {

        WeibarMerchantsBarrageInfo info = new WeibarMerchantsBarrageInfo();
        addUserInfoForBarrageInfo(openId,info);
        info.setMerchantid(merchantId);
        Date now = new Date();
        info.setUpdateTime(now);
        info.setCreateTime(now);
        info.setType(MessageTypeEnum.WORDS_AND_PHOTO.getType());
        info.setImgUrl(imgUrl);
        info.setContext(content);
        info.setStatus(BarrageStatusEnum.NOT_BA.getState());
        return doAddNewBarrage(info);

    }


    public BarrageInfo addNewGiveBarrageInfo(Long merchantId,String openId,String content,
                                             Long givenUserId,String giveUserImg,
                                             String giveContent,String goodsName,
                                             String goodsImgUrl,String userGivenName,Long giveGoodsId) throws BaseException {

        WeibarMerchantsBarrageInfo info = new WeibarMerchantsBarrageInfo();
        addUserInfoForBarrageInfo(openId,info);
        info.setMerchantid(merchantId);
        Date now = new Date();
        info.setUpdateTime(now);
        info.setCreateTime(now);
        info.setType(MessageTypeEnum.GIVE.getType());
        info.setContext(content);
        info.setStatus(BarrageStatusEnum.NOT_BA.getState());
        info.setGiveUserId(givenUserId);
        info.setGiveContent(giveContent);
        info.setGiveGoodsname(goodsName);
        info.setGiveUserImgUrl(giveUserImg);
        info.setGiveGoodsurl(goodsImgUrl);
        info.setGiveGoodsId(giveGoodsId);
        info.setGiveUserName(userGivenName);
        return doAddNewBarrage(info);

    }

    /**
     * 不能单独调用，在发红包确定成功的时候添加一条消息
     * @param merchantId
     * @param openId
     * @param redPackageId
     * @throws BaseException
     */
    public BarrageInfo addRedPackageBarrageInfo(Long merchantId,String openId,Long redPackageId,String redPackageTitle,BigDecimal amount)throws BaseException {
        WeibarMerchantsBarrageInfo info = new WeibarMerchantsBarrageInfo();
        addUserInfoForBarrageInfo(openId,info);
        info.setMerchantid(merchantId);
        Date now = new Date();
        info.setUpdateTime(now);
        info.setCreateTime(now);
        info.setType(MessageTypeEnum.RED_BAG.getType());
        info.setRedpackageid(redPackageId);
        info.setRedpackageTitle(redPackageTitle);
        info.setRedpackageAmount(amount);

        UserBaseInfo userBaseInfo = userService.getUserByOpenId(openId);
        info.setRedpackageGiveUserId(userBaseInfo.getUserId());
        info.setRedpackageGiveOpenid(userBaseInfo.getOpenid());

        info.setStatus(BarrageStatusEnum.NOT_BA.getState());
        return doAddNewBarrage(info);
    }


    private BarrageInfo doAddNewBarrage(WeibarMerchantsBarrageInfo info) throws BaseException {
        weibarMerchantsBarrageInfoMapper.insert(info);
        BarrageInfo barrageInfo =  BarrageInfo.formBarrageInfo(info);
        List<BarrageInfo> barrageInfos = new ArrayList<>();
        barrageInfos.add(barrageInfo);
        wsCacheService.addNewWs(WebSocketConsts.WS_PATH_SEND_BARRAGE_PREFIX + barrageInfo.getMerchantId().toString(),
                JsonConverter.toJson(barrageInfos));
        return barrageInfo;
    }


    private BarrageInfo doSendWs(WeibarMerchantsBarrageInfo info)throws BaseException {
        BarrageInfo barrageInfo =  BarrageInfo.formBarrageInfo(info);
        List<BarrageInfo> barrageInfos = new ArrayList<>();
        barrageInfos.add(barrageInfo);
        wsCacheService.addNewWs(WebSocketConsts.WS_PATH_SEND_BARRAGE_PREFIX + barrageInfo.getMerchantId().toString(),
                JsonConverter.toJson(barrageInfos));
        return barrageInfo;
    }

}
