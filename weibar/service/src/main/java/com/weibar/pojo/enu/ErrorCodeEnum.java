package com.weibar.pojo.enu;

/**
 * Created by Administrator on 2017/10/30.
 */
public enum ErrorCodeEnum {
    SUCCESS(0,"成功"),
    UNKOWN_ERROR(-1,"未知错误"),

    DB_ERROR_BEGIN(-10,"数据库错误开始段"),
    DB_DB_ERROR(-11,"系统数据库错误"),
    DB_ERROR_END(-100,"数据库错误结束段"),

    JSON_ERROR(-101,"json 转换出错"),
    URL_ENCODE_ERROR(-102,"url encode 出错"),


    USER_ERROR_BEGIN(-10000,"用户错误开始段"),
    USER_OPEN_ID_NOT_EXIST(-10001,"用户openId不存在"),
    USER_USER_ID_NOT_EXIST(-10002,"用户userId不存在"),
    USER_USER_LOG_DELETE_FAIL(-10010,"删除用户访问记录失败"),
    USER_USER_BALANCE_NOT_ENOUGH(-10011,"用户余额不足"),
    USER_USER_BALANCE_UPDATE_FAIL(-10012,"更新用户余额失败"),//可能是并发更新余额导致
    USER_ERROR_END(-20000,"用户相关错误结束段"),

    MERCHANT_ERROR_BEGIN(-20001,"商户相关错误开始段"),
    MERCHANT_MERCHANT_ID_NOT_EXIST(-20002,"商户ID不存在"),
    MERCHANT_ERROR_END(-30000,"用户相关错误结束段"),


    RED_PACKAGE_ERROR_BEGIN(-30001,"红包相关错误开始段"),
    RED_PACKAGE_PACKAGE_ID_NOT_EXIST(-30002,"红包组ID不存在"),

    RED_PACKAGE_OPEN_ID_NOT_THE_SAME(-30003,"openId不一致"),
    RED_PACKAGE_SEND_NUM_NOT_THE_SAME(-30004,"红包数量不一致"),
    RED_PACKAGE_AMOUNT_NOT_THE_SAME(-30005,"红包金额不一致"),
    RED_PACKAGE_PACKAGE_UPDATE_ERROR(-30006,"红包更新数据失败,请稍后再试"),//更新红包主表没更新成功，可能是并发的问题
    RED_PACKAGE_ALL_GET(-30007,"红包已抢光~"),
    RED_PACKAGE_SEND_NUMBER_ERROR(-30008,"红包份数范围在1-200之间"),
    RED_PACKAGE_PACKAGE_ID_EXIST(-30009,"红包组ID已经存在,不能重复调用创建接口"),
    RED_PACKAGE_TITLE_EMPTY(-30010,"红包标题不能为空~"),
    RED_PACKAGE_ERROR_END(-40000,"红包相关错误结束段"),

    BARRAGE_ERROR_BEGIN(-40001,"跑马灯相关错误开始段"),
    BARRAGE_BARRAGE_NOT_EXIST(-40002,"消息不存在"),
    BARRAGE_BARRAGE_EMPTY(-40003,"消息不能为空"),
    BARRAGE_PARAM_ERROR(-40004,"开始时间和结束时间不能同时为空，也不能同时传"),
    BARRAGE_ERROR_END(-50000,"跑马灯相关错误结束段"),




    PIC_ERROR_BEGIN(-50001,"图片上传相关错误开始段"),
    PIC_PIC_UPLOAD_EMPTY(-50002,"上传的图片为空"),
    PIC_PIC_UPLOAD_FAIL(-50003,"图片上传失败"),
    PIC_ERROR_END(-60000,"图片上传相关错误结束段"),


    BARPING_ERROR_BEGIN(-60001,"霸屏相关错误结束段"),
    BARPING_ERROR_HAS_BA(-60002,"该消息已霸屏，不能重复霸屏"),
    BARPING_ERROR_NOT_SETING(-60003,"不支持该霸屏秒数"),
    BARPING_ERROR_NOT_SUPPORT_TYPE(-60004,"只有带图片或者文字的消息才能霸屏"),
    BARPING_ERROR_END(-70000,"霸屏相关错误结束段"),



    GIVE_ERROR_BEGIN(-70001,"打赏相关错误结束段"),
    GIVE_ERROR_GOODS_NOT_EXIST(-70002,"打赏商品不存在"),
    GIVE_ERROR_GIVE_SELF(-70003,"不能打赏给自己"),
    GIVE_ERROR_END(-80000,"打赏相关错误结束段"),


    WECHAT_MP_ERROR_BEGIN(-80001,"微信相关错误开始段"),
    WECHAT_MP_ERROR_LOGIN_ERROR(-80002,"微信登录失败"),
    WECHAT_MP_ERROR_SEND_TEMPLATE_MSG(-80003,"发送微信模板消息错误"),
    WECHAT_MP_ERROR_END(-90000,"微信相关错误结束段"),


    PRIVATE_WECHAT_ERROR_BEGIN(-90001,"私聊相关错误开始段"),
    PRIVATE_WECHAT_EMPTY_MSG(-90002,"私聊消息不能为空"),
    PRIVATE_WECHAT_BEGIN_TIME_END_TIME_ALL_NULL(-90003,"开始时间和结束时间不能同时为空"),
    PRIVATE_WECHAT_BEGIN_TIME_END_TIME_ALL_HAS_VALUE(-90004,"开始时间和结束时间不能同时传值"),
    PRIVATE_WECHAT_ERROR_END(-100000,"私聊相关错误结束段"),


    LOGIN_ERROR_BEGIN(-100001,"登录相关错误开始段"),
    LOGIN_ERROR_NO_LOGIN(-100002,"用户未登录"),
    LOGIN_ERROR_LOGIN_INFO_ERROR(-100003,"用户登录信息错误，请重新登录"),
    LOGIN_ERROR_END(-110000,"登录相关错误结束段"),


    WECHAT_PAY_ERROR_BEGIN(-110001,"登录相关错误开始段"),
    WECHAT_PAY_ERROR_CONFIG_ERROR(-110002,"微信配置错误"),
    WECHAT_PAY_ERROR_CREATE_ORDER_ERROR(-110003,"微信下单失败"),
    WECHAT_PAY_ERROR_QUERY_ORDER_ERROR(-110004,"微信查询订单失败"),
    WECHAT_PAY_ERROR_PARSE_NOTIFY_ERROR(-110005,"微信通知支付结果有误"),
    WECHAT_PAY_ERROR_UNKOWN_STATE(-110006,"微信支付状态未知"),
    WECHAT_PAY_ERROR_SEND_RED_PACK(-110007,"微信发送红包失败"),
    WECHAT_PAY_ERROR_END(-120000,"登录相关错误结束段"),

    RECHARGE_ERROR_BEGIN(-120001,"充值相关错误开始段"),
    RECHARGE_ERROR_ORDER_NOT_EXIST(-120002,"充值订单不存在"),
    RECHARGE_ERROR_PAY_ATTACH_ERROR(-120004,"attach 参数有误"),
    RECHARGE_ERROR_ORDER_AMOUNT_NOT_SAME(-120003,"充值订单金额不一致"),
    RECHARGE_ERROR_END(-130000,"充值相关错误结束段"),


    WITHDRAW_ERROR_BEGIN(-130001,"提现相关错误开始段"),
    WITHDRAW_ERROR_AMOUNT(-130002,"提现金额必须在1到200元之间"),
    WITHDRAW_ERROR_END(-140000,"提现相关错误结束段"),

    DAKA_ERROR_BEGIN(-140001,"打卡相关错误开始段"),
    DAKA_USER_NOT_EXIST(-140002,"打卡用户不存在"),
    DAKA_ORDER_NOT_EXIST(-140003,"打卡订单不存在"),
    DAKA_NOT_PAY_TIME(-140004,"每天23:55之后不能支付打卡"),
    DAKA_NOT_IN_TIME(-140005,"每天请在5点到8点之间进行打卡"),
    DAKA_ORDER_TABLE_SUM_TABLE_ERROR(-140006,"用户订单表和统计表数据不一致"),
    DAKA_ERROR_END(-150000,"打卡相关错误结束段"),

    MINIPRAGRAM_ERROR_BEGIN(-150001,"小程序相关错误开始段"),
    MINIPRAGRAM_CODE_FAIL(-150002,"小程序校验code失败"),
    MINIPRAGRAM_ERROR_END(-160000,"小程序相关错误结束段");

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ErrorCodeEnum getErrorCodeEnumByCode(int code){
        for(ErrorCodeEnum errorCodeEnum : ErrorCodeEnum.values()){
            if(errorCodeEnum.getCode() == code){
                return errorCodeEnum;
            }
        }
        return ErrorCodeEnum.UNKOWN_ERROR;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private int code;
    private String msg;
}
