package com.weibar.service.function;

import com.github.binarywang.wxpay.bean.request.WxPaySendRedpackRequest;
import com.github.binarywang.wxpay.bean.result.WxPaySendRedpackResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.weibar.pojo.consts.WechatPayConsts;
import com.weibar.pojo.db.WeibarRedpackageOrder;
import com.weibar.pojo.db.WeibarRedpackageOrderCriteria;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.enu.RedPackageOrderStateEnum;
import com.weibar.pojo.enu.RedPackageSceneIdEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.service.mapper.WeibarRedpackageOrderMapper;
import com.weibar.utils.IdGenerator;
import com.weibar.utils.IpUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 *
 */
@Service
public class WechatRedPackageService {

    private static final Logger LOG = LoggerFactory.getLogger(WechatPayService.class);


    @Autowired
    private WxPayService wxPayService;

    @Autowired
    private WithdrawService withdrawService;

    private static final int SEND_NUM = 1;

    //    发放红包使用场景，红包金额大于200时必传
//    PRODUCT_1:商品促销
//    PRODUCT_2:抽奖
//    PRODUCT_3:虚拟物品兑奖
//    PRODUCT_4:企业内部福利
//    PRODUCT_5:渠道分润
//    PRODUCT_6:保险回馈
//    PRODUCT_7:彩票派奖
//    PRODUCT_8:税务刮奖
    private static final String DEFAULT_SCENE_ID = "PRODUCT_5";

    public static final int DEFAULT_READ_COUNT = 10;

    @Autowired
    private WeibarRedpackageOrderMapper weibarRedpackageOrderMapper;

    public void createRedPackageOrder(BigDecimal amount,
                                      String chorderid,
                                      String openId, Long userId,
                                      String clientIp, String sceneId,
                                      String redPacketTitle, String description) {

        Date now = new Date();
        WeibarRedpackageOrder weibarRedpackageOrder = new WeibarRedpackageOrder();

        weibarRedpackageOrder.setOrderid(IdGenerator.generateIdByTime());
        weibarRedpackageOrder.setStatus(RedPackageOrderStateEnum.NEW.getCode());
        weibarRedpackageOrder.setOpenid(openId);
        weibarRedpackageOrder.setAmount(amount);
        weibarRedpackageOrder.setChorderid(chorderid);
        weibarRedpackageOrder.setDescription(description);
        weibarRedpackageOrder.setRedpackettitle(redPacketTitle);
        weibarRedpackageOrder.setSceneId(sceneId);
        weibarRedpackageOrder.setUserip(clientIp);
        weibarRedpackageOrder.setUserId(userId);
        weibarRedpackageOrder.setCreateTime(now);
        weibarRedpackageOrder.setUpdateTime(now);
        weibarRedpackageOrderMapper.insert(weibarRedpackageOrder);
    }


    public void sendRedPackage(WeibarRedpackageOrder order) throws BaseException {

        WxPaySendRedpackRequest wxPaySendRedpackRequest = new WxPaySendRedpackRequest();
        wxPaySendRedpackRequest.setMchBillNo(order.getOrderid().toString());
        wxPaySendRedpackRequest.setSendName(WechatPayConsts.COMPANY_NAME);
        wxPaySendRedpackRequest.setReOpenid(order.getOpenid());
        int amountVaule = order.getAmount().multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_DOWN).intValueExact();
        wxPaySendRedpackRequest.setTotalAmount(amountVaule);
        wxPaySendRedpackRequest.setTotalNum(SEND_NUM);
        wxPaySendRedpackRequest.setWishing(order.getRedpackettitle());
        wxPaySendRedpackRequest.setClientIp(IpUtil.getLocalHostIP());
        wxPaySendRedpackRequest.setActName(order.getRedpackettitle());
        wxPaySendRedpackRequest.setRemark("userId:" + order.getUserId() + " chOrderId " + order.getChorderid());
        wxPaySendRedpackRequest.setSceneId(DEFAULT_SCENE_ID);

        //wxPaySendRedpackRequest.setAppid();

        WxPaySendRedpackResult wxPaySendRedpackResult = null;
        try {
            wxPaySendRedpackResult = wxPayService.sendRedpack(wxPaySendRedpackRequest);

            if(!StringUtils.equals(WechatPayConsts.RETURN_CODE_SUCCESS,wxPaySendRedpackResult.getResultCode())){
                order.setUpdateTime(new Date());
                order.setStatusmsg(wxPaySendRedpackResult.getXmlString());
                weibarRedpackageOrderMapper.updateByPrimaryKey(order);
                throw BaseException.getException(ErrorCodeEnum.WECHAT_PAY_ERROR_SEND_RED_PACK.getCode());
            }

        } catch (WxPayException e) {
            LOG.error("wechat sendRedpack error", e);
            throw BaseException.getException(ErrorCodeEnum.WECHAT_PAY_ERROR_SEND_RED_PACK.getCode());
        }

        order.setUpdateTime(new Date());
        order.setStatus(RedPackageOrderStateEnum.USER_HAS_GET.getCode());
        order.setStatuscode(RedPackageOrderStateEnum.USER_HAS_GET.getDesc());
        order.setStatusmsg(wxPaySendRedpackResult.getXmlString());
        weibarRedpackageOrderMapper.updateByPrimaryKey(order);
        handleForSuccess(order);
    }


    public int sendRedPackages(List<WeibarRedpackageOrder> orders) {
        int count = 0;
        try {
            for (WeibarRedpackageOrder order : orders) {
                sendRedPackage(order);
                count++;
            }
        } catch (BaseException e) {
        }
        return count;
    }


    public List<WeibarRedpackageOrder> getUnSendRedPackOrders() {
        WeibarRedpackageOrderCriteria redpackageOrderCriteria = new WeibarRedpackageOrderCriteria();
        //redpackageOrderCriteria.setLimit(DEFAULT_READ_COUNT);
        WeibarRedpackageOrderCriteria.Criteria criteria = redpackageOrderCriteria.createCriteria();
        List<Integer> codes = new ArrayList<>();
        codes.add(RedPackageOrderStateEnum.NEW.getCode());
        criteria.andStatusIn(codes);
        List<WeibarRedpackageOrder> orderList = weibarRedpackageOrderMapper.selectByExample(redpackageOrderCriteria);
        return orderList;
    }



    private void handleForSuccess(WeibarRedpackageOrder order){

        RedPackageSceneIdEnum redPackageScene = RedPackageSceneIdEnum.getRedPackageSceneIdEnum(Integer.valueOf(order.getSceneId()));

        switch (redPackageScene){
            case USER_WITHDRAW:
                withdrawService.updateWithdrawSuccess(Long.parseLong(order.getChorderid()));
                break;
            default:
                break;
        }
    }
}