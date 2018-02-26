package com.weibar.service.function;

import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.weibar.pojo.db.MerchantsUserBaseInfo;
import com.weibar.pojo.db.MerchantsUserBaseInfoCriteria;
import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.db.UserBaseInfoCriteria;
import com.weibar.pojo.enu.AppEnum;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.enu.UserInfoStatusEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.service.mapper.MerchantsUserBaseInfoMapper;
import com.weibar.service.mapper.UserBaseInfoMapper;
import com.weibar.utils.IdGenerator;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
@Service
public class UserService {


    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;

    @Autowired
    private MerchantsUserBaseInfoMapper merchantsUserBaseInfoMapper;





    /**
     *
     * 根据openId 查询 userId
     * @param openId
     * @return
     * @throws BaseException
     */
    public Long getUserIdByOpenId(String openId)throws BaseException{
        MerchantsUserBaseInfoCriteria merchantsUserBaseInfoCriteria = new MerchantsUserBaseInfoCriteria();
        MerchantsUserBaseInfoCriteria.Criteria criteria = merchantsUserBaseInfoCriteria.createCriteria();
        criteria.andOpenidEqualTo(openId);
        List<MerchantsUserBaseInfo> merchantsUserBaseInfoList =  merchantsUserBaseInfoMapper.selectByExample(merchantsUserBaseInfoCriteria);
        if(merchantsUserBaseInfoList == null || merchantsUserBaseInfoList.size() == 0){
            LOG.error("can not find openId " + openId);
            throw BaseException.getException(ErrorCodeEnum.USER_OPEN_ID_NOT_EXIST.getCode());
        }
        return merchantsUserBaseInfoList.get(0).getUserId();
    }

    /**
     * 根据userId获取用户信息
     * @param userId
     * @return
     * @throws BaseException
     */
    public UserBaseInfo getUserById(Long userId)throws BaseException{

        UserBaseInfoCriteria userBaseInfoCriteria = new UserBaseInfoCriteria();
        UserBaseInfoCriteria.Criteria criteria = userBaseInfoCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserBaseInfo> userBaseInfoList = userBaseInfoMapper.selectByExample(userBaseInfoCriteria);
        if(userBaseInfoList == null || userBaseInfoList.size() == 0){
            throw BaseException.getException(ErrorCodeEnum.USER_USER_ID_NOT_EXIST.getCode());
        }
        return userBaseInfoList.get(0);
    }


    public String getOpenIdByUserid(Long userId)throws BaseException{

        UserBaseInfoCriteria userBaseInfoCriteria = new UserBaseInfoCriteria();
        UserBaseInfoCriteria.Criteria criteria = userBaseInfoCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserBaseInfo> userBaseInfoList = userBaseInfoMapper.selectByExample(userBaseInfoCriteria);
        if(userBaseInfoList == null || userBaseInfoList.size() == 0){
            throw BaseException.getException(ErrorCodeEnum.USER_USER_ID_NOT_EXIST.getCode());
        }
        return userBaseInfoList.get(0).getOpenid();
    }

    public List<UserBaseInfo> getUserBaseInfoList(List<Long> userIds){

        if(userIds == null || userIds.size() == 0){
            return new ArrayList<>();
        }
        UserBaseInfoCriteria userBaseInfoCriteria = new UserBaseInfoCriteria();
        UserBaseInfoCriteria.Criteria criteria = userBaseInfoCriteria.createCriteria();
        criteria.andUserIdIn(userIds);
        List<UserBaseInfo> userBaseInfoList = userBaseInfoMapper.selectByExample(userBaseInfoCriteria);
        return userBaseInfoList;
    }

    /**
     * 根据openId获取用户信息
     * @param openId
     * @return
     * @throws BaseException
     */
    public UserBaseInfo getUserByOpenId(String openId)throws BaseException{
        UserBaseInfoCriteria userBaseInfoCriteria = new UserBaseInfoCriteria();
        UserBaseInfoCriteria.Criteria criteria = userBaseInfoCriteria.createCriteria();
        criteria.andOpenidEqualTo(openId);
        List<UserBaseInfo> userBaseInfoList = userBaseInfoMapper.selectByExample(userBaseInfoCriteria);
        if(userBaseInfoList == null || userBaseInfoList.size() == 0){
            throw BaseException.getException(ErrorCodeEnum.USER_USER_ID_NOT_EXIST.getCode());
        }
        return userBaseInfoList.get(0);
    };


    public UserBaseInfo getDakaUserByOpenId(String openId)throws BaseException{
        UserBaseInfoCriteria userBaseInfoCriteria = new UserBaseInfoCriteria();
        UserBaseInfoCriteria.Criteria criteria = userBaseInfoCriteria.createCriteria();
        criteria.andMiniDakaOpenidEqualTo(openId);
        List<UserBaseInfo> userBaseInfoList = userBaseInfoMapper.selectByExample(userBaseInfoCriteria);
        if(userBaseInfoList == null || userBaseInfoList.size() == 0){
            throw BaseException.getException(ErrorCodeEnum.USER_USER_ID_NOT_EXIST.getCode());
        }
        return userBaseInfoList.get(0);
    };


    /**
     * 微信回传的信息更新数据库
     * @param wxMaUserInfo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public UserBaseInfo updateUserInfoByWechatMiniProgram(WxMaUserInfo wxMaUserInfo,AppEnum appEnum) throws BaseException {

        MerchantsUserBaseInfoCriteria userBaseInfoCriteria = new MerchantsUserBaseInfoCriteria();
        MerchantsUserBaseInfoCriteria.Criteria criteria = userBaseInfoCriteria.createCriteria();
        //criteria.andUnionIdEqualTo(wxMaUserInfo.getUnionId());
        criteria.andOpenidEqualTo(wxMaUserInfo.getOpenId());

        List<MerchantsUserBaseInfo> list = merchantsUserBaseInfoMapper.selectByExample(userBaseInfoCriteria);
        UserBaseInfo userBaseInfo = null;
        Date now = new Date();
        if(list == null || list.size() == 0){
            LOG.info("merchantsUserBaseInfo not exit openId:" + wxMaUserInfo.getOpenId());
            /**
             * 先插入用户openId 与 userId对应关系表
             */
            Long userId = IdGenerator.generateIdByTime();
            MerchantsUserBaseInfo merchantsUserBaseInfo = new MerchantsUserBaseInfo();
            merchantsUserBaseInfo.setUpdateTime(now);
            merchantsUserBaseInfo.setBindTime(now);
            merchantsUserBaseInfo.setCreateTime(now);
            merchantsUserBaseInfo.setOpenid(wxMaUserInfo.getOpenId());
            merchantsUserBaseInfo.setUnionId(wxMaUserInfo.getUnionId());
            merchantsUserBaseInfo.setUserId(userId);
            merchantsUserBaseInfoMapper.insert(merchantsUserBaseInfo);


            /**
             * 再获取userId 插入用户表
             */


            userBaseInfo = new UserBaseInfo();
            userBaseInfo.setCity(wxMaUserInfo.getCity());
            userBaseInfo.setCountry(wxMaUserInfo.getCountry());
            userBaseInfo.setUserId(userId);

            userBaseInfo.setCreateTime(now);
            userBaseInfo.setUpdateTime(now);
            userBaseInfo.setNickname(wxMaUserInfo.getNickName());

            userBaseInfo.setPoint(new BigDecimal(0));
            userBaseInfo.setProvince(wxMaUserInfo.getProvince());
            userBaseInfo.setRemark("");
            userBaseInfo.setSex(wxMaUserInfo.getGender());
            userBaseInfo.setStatus(UserInfoStatusEnum.SUB.getState());
            userBaseInfo.setUserLevel("0");
            userBaseInfo.setUserMobile("");
            userBaseInfo.setUserPicture(wxMaUserInfo.getAvatarUrl());
            userBaseInfo.setUnionId(wxMaUserInfo.getUnionId());
            userBaseInfo.setOpenid(wxMaUserInfo.getOpenId());
            switch (appEnum){
                case WEIBA_MP:
                    break;
                case DAKA_MINI:
                    userBaseInfo.setMiniDakaOpenid(wxMaUserInfo.getOpenId());
                    break;
            }

            userBaseInfoMapper.insert(userBaseInfo);

        }else if(list.size() > 1){
            throw BaseException.getException(ErrorCodeEnum.USER_OPEN_ID_EXIST_MORE.getCode());

        } else{
            LOG.info("merchantsUserBaseInfo exist openId:" + wxMaUserInfo.getOpenId());
            UserBaseInfoCriteria baseInfoCriteria = new UserBaseInfoCriteria();
            UserBaseInfoCriteria.Criteria c = baseInfoCriteria.createCriteria();
            c.andUserIdEqualTo(list.get(0).getUserId());
            userBaseInfo = userBaseInfoMapper.selectByExample(baseInfoCriteria).get(0);
            userBaseInfo.setUpdateTime(now);
            userBaseInfo.setCity(wxMaUserInfo.getCity());
            userBaseInfo.setCountry(wxMaUserInfo.getCountry());
            userBaseInfo.setNickname(wxMaUserInfo.getNickName());
            userBaseInfo.setProvince(wxMaUserInfo.getProvince());
            userBaseInfo.setSex(wxMaUserInfo.getGender());
            userBaseInfo.setUserPicture(wxMaUserInfo.getAvatarUrl());
            switch (appEnum){
                case WEIBA_MP:
                    break;
                case DAKA_MINI:
                    userBaseInfo.setMiniDakaOpenid(wxMaUserInfo.getOpenId());
                    break;
            }

            userBaseInfoMapper.updateByPrimaryKey(userBaseInfo);
        }
        return userBaseInfo;
    }

    /**
     * 微信回传的信息更新数据库
     * @param wxMpUser
     * @return
     */
    public UserBaseInfo updateUserInfoByWechat(WxMpUser wxMpUser){

        MerchantsUserBaseInfoCriteria userBaseInfoCriteria = new MerchantsUserBaseInfoCriteria();
        MerchantsUserBaseInfoCriteria.Criteria criteria = userBaseInfoCriteria.createCriteria();
        criteria.andOpenidEqualTo(wxMpUser.getOpenId());
        Date now = new Date();
        List<MerchantsUserBaseInfo> list = merchantsUserBaseInfoMapper.selectByExample(userBaseInfoCriteria);
        UserBaseInfo userBaseInfo = null;
        if(list == null || list.size() == 0){
            /**
             * 先插入用户openId 与 userId对应关系表
             */
            Long userId = IdGenerator.generateIdByTime();
            MerchantsUserBaseInfo merchantsUserBaseInfo = new MerchantsUserBaseInfo();
            merchantsUserBaseInfo.setUpdateTime(now);
            merchantsUserBaseInfo.setBindTime(now);
            merchantsUserBaseInfo.setCreateTime(now);
            merchantsUserBaseInfo.setOpenid(wxMpUser.getOpenId());
            merchantsUserBaseInfo.setUserId(userId);
            merchantsUserBaseInfoMapper.insert(merchantsUserBaseInfo);


            /**
             * 再获取userId 插入用户表
             */


            userBaseInfo = new UserBaseInfo();
            userBaseInfo.setCity(wxMpUser.getCity());
            userBaseInfo.setCountry(wxMpUser.getCountry());
            userBaseInfo.setUserId(userId);

            userBaseInfo.setCreateTime(now);
            userBaseInfo.setUpdateTime(now);
            userBaseInfo.setNickname(wxMpUser.getNickname());
            userBaseInfo.setOpenid(wxMpUser.getOpenId());
            userBaseInfo.setPoint(new BigDecimal(0));
            userBaseInfo.setProvince(wxMpUser.getProvince());
            userBaseInfo.setRemark("");
            userBaseInfo.setSex(wxMpUser.getSex());
            userBaseInfo.setStatus(UserInfoStatusEnum.SUB.getState());
            userBaseInfo.setUserLevel("0");
            userBaseInfo.setUserMobile("");
            userBaseInfo.setUserPicture(wxMpUser.getHeadImgUrl());
            userBaseInfoMapper.insert(userBaseInfo);

        }else{
            UserBaseInfoCriteria baseInfoCriteria = new UserBaseInfoCriteria();
            UserBaseInfoCriteria.Criteria c = baseInfoCriteria.createCriteria();
            c.andOpenidEqualTo(wxMpUser.getOpenId());
            userBaseInfo = userBaseInfoMapper.selectByExample(baseInfoCriteria).get(0);
            userBaseInfo.setUpdateTime(now);
            userBaseInfo.setCity(wxMpUser.getCity());
            userBaseInfo.setCountry(wxMpUser.getCountry());
            userBaseInfo.setNickname(wxMpUser.getNickname());
            userBaseInfo.setOpenid(wxMpUser.getOpenId());
            userBaseInfo.setProvince(wxMpUser.getProvince());
            userBaseInfo.setSex(wxMpUser.getSex());
            userBaseInfo.setUserPicture(wxMpUser.getHeadImgUrl());
            userBaseInfoMapper.updateByPrimaryKey(userBaseInfo);
        }
        return userBaseInfo;
    }



}
