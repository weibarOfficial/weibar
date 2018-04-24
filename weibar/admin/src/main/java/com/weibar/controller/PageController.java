package com.weibar.controller;

import com.weibar.consts.SessionConsts;
import com.weibar.pojo.db.MerchantIncome;
import com.weibar.pojo.db.WeibarMerchantsLoginLog;
import com.weibar.pojo.enu.MerchantRoleEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.MerchantIncomeResult;
import com.weibar.pojo.result.MerchantInfo;
import com.weibar.pojo.result.MerchantsLoginLog;
import com.weibar.service.function.GoodsService;
import com.weibar.service.function.MerchantIncomeService;
import com.weibar.service.function.MerchantService;
import com.weibar.service.function.PriceTimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PageController extends AbstractController{


    public static final String PAGE_NAME = "pageName";


    @Autowired
    private MerchantIncomeService merchantIncomeService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private PriceTimeService priceTimeService;

    private static final Logger LOG = LoggerFactory.getLogger(PageController.class);
    @RequestMapping(value = "/admin/page/index", method = {RequestMethod.GET,RequestMethod.POST})
    public String index(Model model, HttpServletRequest req) {
        model.addAttribute(PAGE_NAME,"首页");
        return "index/index";
    }


    @RequestMapping(value = "/admin/page/temp", method = {RequestMethod.GET,RequestMethod.POST})
    public String temp(Model model) {
        return "index/temp";
    }


    @RequestMapping(value = "/admin/page/login", method = {RequestMethod.GET,RequestMethod.POST})
    public String login(Model model) {
        model.addAttribute(PAGE_NAME,"登录&注册");
        return "index/login";
    }


    @RequestMapping(value = "/admin/page/incomeIndex", method = {RequestMethod.GET,RequestMethod.POST})
    public String incomeIndex(Model model,HttpServletRequest request) {
        model.addAttribute(PAGE_NAME,"收入总览");
        //TODO 暂时写死300条
        List<MerchantIncomeResult> merchantIncomeResults =  merchantIncomeService.getMerchantIncomes(getMerchantInfoFromSession(request).getMerchantId(),0,300);
        model.addAttribute("mIncomes",merchantIncomeResults);
        return "income/index";
    }


    @RequestMapping(value = "/admin/page/merchantIndex", method = {RequestMethod.GET,RequestMethod.POST})
    public String merchantIndex(Model model,HttpServletRequest request) throws BaseException {
        model.addAttribute(PAGE_NAME,"商户信息");
        model.addAttribute("mInfo",merchantService.getMerchantInfo(getMerchantInfoFromSession(request).getMerchantId()));
        return "merchant/index";
    }


    @RequestMapping(value = "/admin/page/getAffiliates", method = {RequestMethod.GET,RequestMethod.POST})
    public String getAffiliates(Model model,HttpServletRequest request) throws BaseException {
        model.addAttribute(PAGE_NAME,"下属商户");
        List<MerchantInfo> merchantInfoList = merchantService.getAffiliates(getMerchantInfoFromSession(request).getMerchantId());
        model.addAttribute("mAffs",merchantInfoList);
        return "merchant/affiliates";
    }


    @RequestMapping(value = "/admin/page/userIndex", method = {RequestMethod.GET,RequestMethod.POST})
    public String userIndex(Model model,HttpServletRequest request) {
        model.addAttribute(PAGE_NAME,"用户管理");
        List<MerchantsLoginLog> loginLogs = merchantService.getMerchantUsers(getMerchantInfoFromSession(request).getMerchantId());
        model.addAttribute("mUsers",loginLogs);
        return "user/index";
    }



    @RequestMapping(value = "/admin/page/barIndex", method = {RequestMethod.GET,RequestMethod.POST})
    public String barIndex(Model model,HttpServletRequest request) throws BaseException {
        model.addAttribute(PAGE_NAME,"酒吧信息");
        model.addAttribute("mInfo",merchantService.getMerchantInfo(getMerchantInfoFromSession(request).getMerchantId()));
        return "bar/index";
    }



    @RequestMapping(value = "/admin/page/goodsIndex", method = {RequestMethod.GET,RequestMethod.POST})
    public String goodsIndex(Model model,HttpServletRequest request) throws BaseException {
        model.addAttribute(PAGE_NAME,"商品信息");
        model.addAttribute("mInfo",goodsService.getGoodsSettingInfo(getMerchantInfoFromSession(request).getMerchantId()));
        return "goods/index";
    }

    @RequestMapping(value = "/admin/page/timePriceIndex", method = {RequestMethod.GET,RequestMethod.POST})
    public String timePriceIndex(Model model,HttpServletRequest request) throws BaseException {
        model.addAttribute(PAGE_NAME,"打赏时长");
        model.addAttribute("mInfo",priceTimeService.getPriceTimeSettingInfo(getMerchantInfoFromSession(request).getMerchantId()));
        return "time/index";
    }

}
