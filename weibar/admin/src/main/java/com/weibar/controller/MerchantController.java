package com.weibar.controller;


import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.service.function.GoodsService;
import com.weibar.service.function.MerchantService;
import com.weibar.service.function.PriceTimeService;
import com.weibar.service.function.SharingRatioService;
import com.weibar.utils.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MerchantController extends AbstractController {

    private static final Logger LOG = LoggerFactory.getLogger(MerchantController.class);

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private SharingRatioService sharingRatioService;

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private PriceTimeService priceTimeService;


    @RequestMapping(value = "/admin/editAffiliateShareRatio" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object editAffiliateShareRatio(HttpServletRequest request,
                                          @RequestParam Long affiliateId,
                                          @RequestParam Integer sharingRatioBarpin,
                                          @RequestParam Integer sharingRatioGive,
                                          @RequestParam Integer sharingRatioRedp) throws BaseException {




        sharingRatioService.editAffiliateShareRatio(getMerchantInfoFromSession(request).getMerchantId(),
                affiliateId,sharingRatioBarpin,sharingRatioGive,sharingRatioRedp);
        return BaseResult.getSuccessfulResult(null);
    }



    @RequestMapping(value = "/admin/getAffiliateById" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getAffiliateById( HttpServletRequest request,@RequestParam Long affiliateId) throws BaseException {
        return BaseResult.getSuccessfulResult(merchantService.getAffiliateById(getMerchantInfoFromSession(request).getMerchantId(),affiliateId));
    }




    @RequestMapping(value = "/admin/getMerchantInfo" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getMerchantInfo( HttpServletRequest request) throws BaseException {
        return BaseResult.getSuccessfulResult(merchantService.getMerchantInfo(getMerchantInfoFromSession(request).getMerchantId()));
    }



    @RequestMapping(value = "/admin/createRootMerchant" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object createRootMerchant( HttpServletRequest request) throws BaseException {
        return BaseResult.getSuccessfulResult(merchantService.createRootMerchant());
    }


    @RequestMapping(value = "/admin/createMerchant" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object createMerchant(HttpServletRequest request, @RequestParam String name, @RequestParam String loginName, @RequestParam int roleId,
                                 @RequestParam String pwd, @RequestParam Long parentMerchantId) throws BaseException {

        String md5pwd = EncryptUtil.getMD5(loginName + pwd);
        return BaseResult.getSuccessfulResult(merchantService.createMerchant(loginName,name,md5pwd,parentMerchantId,roleId));
    }


    @RequestMapping(value = "/admin/generateTimeAndGoodsInfo" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object generateTimeAndGoodsInfo( HttpServletRequest request) throws BaseException {

        Long merchantId = getMerchantInfoFromSession(request).getMerchantId();
        goodsService.generateMerchantDefaultGoods(merchantId);
        priceTimeService.generatePriceTimeSettingInfo(merchantId);
        return BaseResult.getSuccessfulResult(null);
        
    }




}
