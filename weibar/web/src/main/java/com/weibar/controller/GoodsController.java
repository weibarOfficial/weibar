package com.weibar.controller;

import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.service.function.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/5.
 */
@RestController
public class GoodsController {


    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/h5/goodsSettingInfo" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object goodsSettingInfo(@RequestParam Long merchantId) throws BaseException {
        return BaseResult.getSuccessfulResult(goodsService.getGoodsSettingInfo(merchantId));
    }


    @RequestMapping(value = "/pc/goodsSettingInfo" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object goodsSettingInfoPc(@RequestParam Long merchantId) throws BaseException {
        return BaseResult.getSuccessfulResult(goodsService.getGoodsSettingInfo(merchantId));
    }

    @RequestMapping(value = "/h5/generateGoods" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object generateGoods() throws BaseException {
        return BaseResult.getSuccessfulResult(goodsService.generateGoods());
    }


    @RequestMapping(value = "/h5/generateGoodsMerchant" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object generateGoodsMerchant(@RequestParam Long merchantId) throws BaseException {
        goodsService.generateMerchantDefaultGoods(merchantId);
        return BaseResult.getSuccessfulResult(null);
    }
}
