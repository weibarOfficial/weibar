package com.weibar.controller;

import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.service.function.GoodsService;
import com.weibar.service.function.PriceTimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by Administrator on 2018/4/23.
 */
@RestController
public class MerchantGoodsTimePriceController extends AbstractController{

    private static final Logger LOG = LoggerFactory.getLogger(MerchantIncomeController.class);

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private PriceTimeService priceTimeService;

    @RequestMapping(value = "/admin/updateGoodsPrices" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object updateGoodsPrices(HttpServletRequest request,
                                    @RequestParam HashMap<Long,BigDecimal> goodsPrices) throws BaseException {
        goodsService.updateMerchantGoods(getMerchantInfoFromSession(request).getMerchantId(),goodsPrices);
        return BaseResult.getSuccessfulResult(null);
    }


    @RequestMapping(value = "/admin/updateGoodsPrice" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object updateGoodsPrice(HttpServletRequest request,@RequestParam Long goodsId,
                                    @RequestParam BigDecimal goodsPrice) throws BaseException {
        goodsService.updateMerchantSingleGoods(getMerchantInfoFromSession(request).getMerchantId(),goodsId,goodsPrice);
        return BaseResult.getSuccessfulResult(null);
    }




    @RequestMapping(value = "/admin/getGoodsSettingInfoById" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getGoodsSettingInfoById(HttpServletRequest request,@RequestParam Long goodsId) throws BaseException {
        return BaseResult.getSuccessfulResult(goodsService.getGoodsSettingInfoById(goodsId,getMerchantInfoFromSession(request).getMerchantId()));
    }







}
