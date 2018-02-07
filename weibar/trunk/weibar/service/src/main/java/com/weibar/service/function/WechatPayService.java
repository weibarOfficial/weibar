package com.weibar.service.function;

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayOrderQueryResult;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;

import com.github.binarywang.wxpay.util.SignUtils;
import com.weibar.pojo.consts.WechatPayConsts;
import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.db.UserRechargeOrder;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.enu.PayChTypeEnum;
import com.weibar.pojo.enu.RechargeOrderStatusEnum;
import com.weibar.pojo.enu.WechatPayStatusEnum;
import com.weibar.pojo.exception.BaseException;

import com.weibar.pojo.result.WechatPrePay;
import com.weibar.pojo.result.WechatPayOrderResult;
import com.weibar.utils.IdGenerator;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Created by Administrator on 2017/12/11.
 */
@Service
public class WechatPayService {

    private static final Logger LOG = LoggerFactory.getLogger(WechatPayService.class);

    @Autowired
    private WxPayService wxPayService;
    @Autowired
    private UserRechargeOrderService userRechargeOrderService;
    @Autowired
    private UserService userService;
    @Autowired
    private PayAttachService payAttachService;


    /**
     * 微信下单
     */
    public WechatPrePay createOrder(Integer amountFen, String clientIp, String openId, String payAttach) throws BaseException {
        UserBaseInfo userBaseInfo = userService.getUserByOpenId(openId);
        String orderId = IdGenerator.generateIdByTimeStr();
        WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
        String body = WechatPayConsts.COMPANY_NAME + "-" + WechatPayConsts.PRODUCT_TYPE_NAME;
        orderRequest.setBody(body);
        orderRequest.setOutTradeNo(orderId);
        orderRequest.setFeeType(WechatPayConsts.FEE_TYPE);
        orderRequest.setTotalFee(amountFen);
        orderRequest.setSpbillCreateIp(clientIp);
        orderRequest.setNotifyURL(WechatPayConsts.NOTIFY_URL);
        orderRequest.setTradeType(WxPayConstants.TradeType.JSAPI);
        orderRequest.setOpenid(openId);
        orderRequest.setAttach(payAttach);
        try {
            WxPayMpOrderResult orderResult = wxPayService.createOrder(orderRequest);
            //更正签名 原来sdk有bug
            WechatPayOrderResult wechatPayOrderResult = WechatPayOrderResult.get(orderResult);
            wechatPayOrderResult.setPaySign(SignUtils.createSign(
                    wechatPayOrderResult,
                    "MD5",
                    wxPayService.getConfig().getMchKey(),
                    false));
            UserRechargeOrder userRechargeOrder = userRechargeOrderService.createOrder(orderId,userBaseInfo, PayChTypeEnum.WECHAT,clientIp,amountFen);
            return new WechatPrePay(wechatPayOrderResult,orderId);
        } catch (WxPayException e) {
            LOG.error("wechat pay createOrder error",e);
            throw BaseException.getException(ErrorCodeEnum.WECHAT_PAY_ERROR_CREATE_ORDER_ERROR.getCode());
        }
    }


    /**
     * 查询微信订单结果
     * @param transactionId 微信订单号
     * @param outTradeNo 内部订单号
     * @return
     * @throws BaseException
     */
    public UserRechargeOrder queryOrder(String transactionId,String outTradeNo) throws BaseException {
        try {
            WxPayOrderQueryResult wxPayOrderQueryResult =  wxPayService.queryOrder(transactionId,outTradeNo);

            //更新充值表
            RechargeOrderStatusEnum statusEnum =  WechatPayStatusEnum.getRechargeOrderStatus(WechatPayStatusEnum.getByState(wxPayOrderQueryResult.getTradeState()));
            Date payCompTime = null;
            if(StringUtils.isNotBlank(wxPayOrderQueryResult.getTimeEnd())){
                try {
                    payCompTime = new SimpleDateFormat("yyyyMMddHHmmss").parse(wxPayOrderQueryResult.getTimeEnd());
                } catch (ParseException e) {
                    LOG.error("wechat queryOrder parse date error ori str " + wxPayOrderQueryResult.getTimeEnd(),e);
                }

            }
            UserRechargeOrder userRechargeOrder = userRechargeOrderService.changeOrder(wxPayOrderQueryResult.getOutTradeNo(),
                    statusEnum,
                    wxPayOrderQueryResult.getTotalFee(),
                    wxPayOrderQueryResult.getBankType(),
                    wxPayOrderQueryResult.getTransactionId(),
                    payCompTime,
                    wxPayOrderQueryResult.getXmlString(),
                    wxPayOrderQueryResult.getTradeState(),
                    wxPayOrderQueryResult.getTradeStateDesc()
            );
            return userRechargeOrder;
        } catch (WxPayException e) {
            LOG.error("wechat pay queryOrder error",e);
            throw BaseException.getException(ErrorCodeEnum.WECHAT_PAY_ERROR_QUERY_ORDER_ERROR.getCode());
        }
    }


    /**
     * @param xmlData
     * @return
     * @throws BaseException
     */
    public String handlePayResultNotify(String xmlData) {
        try {
            WxPayOrderNotifyResult result = wxPayService.parseOrderNotifyResult(xmlData);

            RechargeOrderStatusEnum statusEnum =  WechatPayStatusEnum.getRechargeOrderStatus(WechatPayStatusEnum.getByState(result.getResultCode()));
            Date payCompTime = null;
            if(StringUtils.isNotBlank(result.getTimeEnd())){
                try {
                    payCompTime = new SimpleDateFormat("yyyyMMddHHmmss").parse(result.getTimeEnd());
                } catch (ParseException e) {
                    LOG.error("wechat queryOrder parse date error ori str " + result.getTimeEnd(),e);
                }

            }
            UserRechargeOrder userRechargeOrder = userRechargeOrderService.changeOrder(result.getOutTradeNo(),
                    statusEnum,
                    result.getTotalFee(),
                    result.getBankType(),
                    result.getTransactionId(),
                    payCompTime,
                    result.getXmlString(),
                    result.getResultCode(),
                    null
            );

            payAttachService.handlePayAttach(result.getAttach());

        } catch (WxPayException e) {
            LOG.error("wechat pay handlePayResultNotify WxPayException",e);
            return WxPayNotifyResponse.fail(e.getErrCodeDes());
        }catch (BaseException e){
            LOG.error("wechat pay handlePayResultNotify BaseException ",e);
            return WxPayNotifyResponse.fail(e.getMsg());
        }catch (Throwable e){
            LOG.error("wechat pay handlePayResultNotify Throwable ",e);
            return WxPayNotifyResponse.fail(e.getMessage());
        }
        return WxPayNotifyResponse.success("成功");
    }










    //test
//    public static final void main (String[] args){
//        WxPayMpOrderResult payResult = WxPayMpOrderResult.builder()
//                .appId("wxa105b2133d0dd8b0")
//                .timeStamp("1514020562")
//                .nonceStr("1514020562759")
//                .packageValue("prepay_id=" + "wx20171223171602f8c2904e890821975381")
//                .signType("MD5")
//                .build();
//        System.out.println(SignUtils.createSign(
//                WechatPayOrderResult.get(payResult),
//                "MD5",
//                "nxApb3xKPYrHyRxq7wai4pWUyQOQeLyU",
//                false));
//    }



}
