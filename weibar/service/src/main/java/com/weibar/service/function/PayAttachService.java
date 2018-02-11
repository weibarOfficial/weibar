package com.weibar.service.function;


import com.weibar.pojo.db.WeibarPayAttach;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.enu.RechargeSceneTypeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.PayAttach;
import com.weibar.service.mapper.WeibarPayAttachMapper;
import com.weibar.utils.JsonConverter;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 配置调用支付方透传参数，在支付成功的时候回传可以作为后续操作的依据
 */
@Service
public class PayAttachService {

    private static final Logger LOG = LoggerFactory.getLogger(PayAttachService.class);

    @Autowired
    private BarpinService barpinService;
    @Autowired
    private GiveService giveService;
    @Autowired
    private UserService userService;
    @Autowired
    private RedPackageService redPackageService;
    @Autowired
    private WeibarPayAttachMapper weibarPayAttachMapper;
    @Autowired
    private DakaService dakaService;

    public String generatePurePayAttach() throws BaseException {
        PayAttach payAttach = new PayAttach();
        payAttach.setRechargeScene(RechargeSceneTypeEnum.PURE_RECHARGE.getType());
        return insertPayAttach(JsonConverter.toJson(payAttach));
    }

    public String generateBapinPayAttach(Long merchantId, Long messageId, Integer second, Long userId, Integer times,String userIp,Integer barpinTitle,String content)throws BaseException {
        PayAttach payAttach = new PayAttach();
        payAttach.setRechargeScene(RechargeSceneTypeEnum.BARPING.getType());
        payAttach.setMerchantId(merchantId);
        payAttach.setMessageId(messageId);
        payAttach.setSecond(second);
        payAttach.setUserId(userId);
        payAttach.setTimes(times);
        payAttach.setUserIp(userIp);
        payAttach.setBarpinTheme(barpinTitle);
        payAttach.setContent(content);
        return insertPayAttach(JsonConverter.toJson(payAttach));
    }



    public String generateRedPackagePayAttach(Long redPackageId)throws BaseException{
        PayAttach payAttach = new PayAttach();
        payAttach.setRechargeScene(RechargeSceneTypeEnum.RED_PACKAGE.getType());
        payAttach.setRedPackageId(redPackageId);
        return insertPayAttach(JsonConverter.toJson(payAttach));
    }

    public String generateGivePayAttach(Long merchantId, Long userGive, Long userGiven,
                                        String userIp, Long goodsId, String content, Integer giveType)throws BaseException{
        PayAttach payAttach = new PayAttach();
        payAttach.setRechargeScene(RechargeSceneTypeEnum.GIVE.getType());
        payAttach.setMerchantId(merchantId);
        payAttach.setUserId(userGive);
        payAttach.setUserIdGiven(userGiven);
        payAttach.setUserIp(userIp);
        payAttach.setGoodsId(goodsId);
        payAttach.setContent(content);
        payAttach.setGiveType(giveType);
        return insertPayAttach(JsonConverter.toJson(payAttach));
    }


    public String generateDakaOrderAttach(Long dakaOrderId) throws BaseException {
        PayAttach payAttach = new PayAttach();
        payAttach.setDakaOrderId(dakaOrderId);
        payAttach.setRechargeScene(RechargeSceneTypeEnum.DAKA_ORDER.getType());
        return insertPayAttach(JsonConverter.toJson(payAttach));
    }





    public void handlePayAttach(String payAttachId)throws BaseException{

        if(StringUtils.isBlank(payAttachId)){
            return;
        }

        WeibarPayAttach weibarPayAttach = weibarPayAttachMapper.selectByPrimaryKey(Long.parseLong(payAttachId));
        if(weibarPayAttach == null){
            throw BaseException.getException(ErrorCodeEnum.RECHARGE_ERROR_PAY_ATTACH_ERROR.getCode());
        }

        PayAttach payAttach = JsonConverter.fromJson(PayAttach.class,weibarPayAttach.getAttach());
        RechargeSceneTypeEnum rechargeSceneType = RechargeSceneTypeEnum.getByType(payAttach.getRechargeScene());
        switch (rechargeSceneType){
            case BARPING:
                barpinService.barpin(payAttach.getMerchantId(),
                        payAttach.getMessageId(),
                        payAttach.getSecond(),
                        payAttach.getUserId(),
                        payAttach.getTimes(),
                        payAttach.getUserIp(),payAttach.getBarpinTheme(),payAttach.getContent());
                break;
            case GIVE:
                giveService.give(payAttach.getMerchantId(),
                        userService.getUserById(payAttach.getUserId()),
                        userService.getUserById(payAttach.getUserIdGiven()),
                        payAttach.getUserIp(),
                        payAttach.getGoodsId(),
                        payAttach.getContent(),
                        payAttach.getGiveType());
                break;
            case PURE_RECHARGE:
                break;

            case RED_PACKAGE:
                redPackageService.createRedPackage(payAttach.getRedPackageId());
                break;
            case DAKA_ORDER:
                dakaService.payForDaka(payAttach.getDakaOrderId());
                break;
            default:

        }

    }




    private String insertPayAttach(String payAttachStr){
        Date now = new Date();
        WeibarPayAttach weibarPayAttach = new WeibarPayAttach();
        weibarPayAttach.setCreateTime(now);
        weibarPayAttach.setUpdateTime(now);
        weibarPayAttach.setAttach(payAttachStr);
        weibarPayAttachMapper.insert(weibarPayAttach);
        return weibarPayAttach.getId().toString();
    }
//    public static void main(String[] args) throws BaseException {
//        String res = new PayAttachService().generatePurePayAttach();
//        System.out.println(res);
//        PayAttach payAttach = JsonConverter.fromJson(PayAttach.class,res);
//        System.out.println(payAttach);
//
//    }

}
