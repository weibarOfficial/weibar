package com.weibar.controller;

import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.service.function.MerchantIncomeService;
import com.weibar.service.function.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MerchantIncomeController extends AbstractController{

    private static final Logger LOG = LoggerFactory.getLogger(MerchantIncomeController.class);

    @Autowired
    private MerchantService merchantService;
    @Autowired
    private MerchantIncomeService merchantIncomeService;

    @RequestMapping(value = "/admin/getMerchantIncome" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getMerchantIncome(HttpServletRequest request,
                                    @RequestParam Integer begin,
                                    @RequestParam Integer count) throws BaseException {
        return BaseResult.getSuccessfulResult(merchantIncomeService.getMerchantIncomes(getMerchantInfoFromSession(request).getMerchantId(),begin,count));
    }


    @RequestMapping(value = "/admin/getMerchantIncomeCount" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getMerchantIncomeCount( HttpServletRequest request) throws BaseException {
        return BaseResult.getSuccessfulResult(merchantIncomeService.getMerchantIncomeCount(getMerchantInfoFromSession(request).getMerchantId()));
    }
}
