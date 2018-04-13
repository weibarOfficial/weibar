package com.weibar.controller;

import com.weibar.consts.SessionConsts;
import com.weibar.pojo.db.MerchantIncome;
import com.weibar.pojo.enu.MerchantRoleEnum;
import com.weibar.pojo.result.MerchantIncomeResult;
import com.weibar.pojo.result.MerchantInfo;
import com.weibar.service.function.MerchantIncomeService;
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
}
