package com.weibar.pojo.consts;

/**
 * Created by Administrator on 2017/11/28.
 */
public class WechatConsts {

    public static final String COOKIE_OPENID = "weibar_openId";
    public static final String COOKIE_USERID = "weibar_userId";
    public static final String COOKIE_NICKNAME = "weibar_nickName";
    public static final String COOKIE_SESSION_KEY = "weibar_session_key";


    public static final String STATE_PARAM_REDI_URL = "redirectUrl";

    public static final String LOGIN_IN_REDIRECT_URL = "http://www.yylive.com/wechat/login";


    public static final String DEFAULT_MSG_HANDLE_TEMPLATE = "您可以点击上墙互动，或者输入酒吧关键字进行搜索，比如“万达”";

    public static final String MSG_HANDLE_TEMPLATE_BAR = "为您找到如下酒吧:\r\n%s\r\n点击相应酒吧进入现场互动";

    public static final String MSG_HANDLE_TEMPLATE_BAR_SINGLE = "\r\n<a href=\"%s\">%s</a>\r\n";

}
