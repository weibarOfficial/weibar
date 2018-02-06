package com.weibar.controller;

import com.google.common.collect.Lists;
import com.weibar.pojo.consts.WechatConsts;
import com.weibar.pojo.exception.BaseException;
import com.weibar.service.function.MerchantService;
import com.weibar.utils.JsonConverter;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMenuService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.menu.WxMpGetSelfMenuInfoResult;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Administrator on 2017/11/27.
 */

@RestController
@RequestMapping("/wechat/menu")
public class WeixinMenuController {

    @Autowired
    private WxMpService wxService;
    @Autowired
    private MerchantService merchantService;

    @GetMapping("/getSelfMenuInfo")
    public WxMpGetSelfMenuInfoResult getSelfMenuInfo() throws WxErrorException {
        return this.wxService.getMenuService().getSelfMenuInfo();
    }


    @GetMapping("/create")
    public String menuCreateSample() throws WxErrorException, BaseException {
        WxMenu menu = new WxMenu();
        WxMenuButton button1 = new WxMenuButton();
        button1.setType(WxConsts.BUTTON_VIEW);
        button1.setName("上墙互动");
        String redirectUrl = "http://www.yylive.com/wechat/login";
        String url = wxService.oauth2buildAuthorizationUrl(redirectUrl,WxConsts.OAUTH2_SCOPE_USER_INFO, null);
        button1.setUrl(url);


        WxMenuButton button2 = new WxMenuButton();
        button2.setType(WxConsts.BUTTON_VIEW);
        button2.setName("红包提现");
        String redirectUrl2 = "http://www.yylive.com/static/withdraw.html";
        Map<String,String> map = new HashMap<>();
        map.put(WechatConsts.STATE_PARAM_REDI_URL,redirectUrl2);
        String state = JsonConverter.toJson(map);
        String url2 = wxService.oauth2buildAuthorizationUrl(redirectUrl2,WxConsts.OAUTH2_SCOPE_USER_INFO, state);
        button2.setUrl(url2);

        List<WxMenuButton> buttons = new ArrayList<>();
        buttons.add(button1);
        buttons.add(button2);
        menu.setButtons(buttons);

        return this.wxService.getMenuService().menuCreate(menu);
    }





}
