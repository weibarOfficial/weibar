package com.weibar.service.function;

import com.weibar.pojo.db.*;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.PriceTimeSettingInfo;
import com.weibar.service.mapper.WeibarMerchantsPriceTimeSettingInfoMapper;
import com.weibar.service.mapper.WeibarPriceTimeSettingInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/23.
 */
@Service
public class PriceTimeService {


    @Autowired
    private WeibarMerchantsPriceTimeSettingInfoMapper weibarMerchantsPriceTimeSettingInfoMapper;


    @Autowired
    private WeibarPriceTimeSettingInfoMapper weibarPriceTimeSettingInfoMapper;



    public void updatePriceTimeSettingInfo(Long merchantId,Map<Integer,BigDecimal> timePrices){
        if(timePrices == null){
            return;
        }
        for(Integer timeId : timePrices.keySet()){
            WeibarMerchantsPriceTimeSettingInfoCriteria merchantsGoodsSettingInfoCriteria = new WeibarMerchantsPriceTimeSettingInfoCriteria();
            WeibarMerchantsPriceTimeSettingInfoCriteria.Criteria criteria = merchantsGoodsSettingInfoCriteria.createCriteria();
            criteria.andMerchantidEqualTo(merchantId);
            criteria.andTimesidEqualTo(timeId);
            List<WeibarMerchantsPriceTimeSettingInfo> merchantsGoodsSettingInfos = weibarMerchantsPriceTimeSettingInfoMapper.selectByExample(merchantsGoodsSettingInfoCriteria);
            if(merchantsGoodsSettingInfos != null && merchantsGoodsSettingInfos.size() != 0){
                WeibarMerchantsPriceTimeSettingInfo merchantsGoodsSettingInfo = merchantsGoodsSettingInfos.get(0);
                merchantsGoodsSettingInfo.setAmount(timePrices.get(timeId));
                weibarMerchantsPriceTimeSettingInfoMapper.updateByPrimaryKey(merchantsGoodsSettingInfo);
            }
        }
    }



    public void generatePriceTimeSettingInfo(Long merchantId){
        WeibarPriceTimeSettingInfoCriteria priceTimeSettingInfoCriteria = new WeibarPriceTimeSettingInfoCriteria();
        List<WeibarPriceTimeSettingInfo> settingInfoList = weibarPriceTimeSettingInfoMapper.selectByExample(priceTimeSettingInfoCriteria);
        Date now = new Date();
        for(WeibarPriceTimeSettingInfo weibarPriceTimeSettingInfo : settingInfoList){
            WeibarMerchantsPriceTimeSettingInfo merchantsPriceTimeSettingInfo = new  WeibarMerchantsPriceTimeSettingInfo();
            merchantsPriceTimeSettingInfo.setMerchantid(merchantId);
            merchantsPriceTimeSettingInfo.setAmount(weibarPriceTimeSettingInfo.getAmount());
            merchantsPriceTimeSettingInfo.setTimesid(weibarPriceTimeSettingInfo.getTimesid());
            merchantsPriceTimeSettingInfo.setTimesdesc(weibarPriceTimeSettingInfo.getTimesdesc());
            merchantsPriceTimeSettingInfo.setUpdateTime(now);
            merchantsPriceTimeSettingInfo.setCreateTime(now);
            weibarMerchantsPriceTimeSettingInfoMapper.insert(merchantsPriceTimeSettingInfo);
        }
    }


    public List<PriceTimeSettingInfo> getPriceTimeSettingInfo(Long merchantId){
        WeibarMerchantsPriceTimeSettingInfoCriteria priceTimeSettingInfoCriteria = new WeibarMerchantsPriceTimeSettingInfoCriteria();
        WeibarMerchantsPriceTimeSettingInfoCriteria.Criteria criteria = priceTimeSettingInfoCriteria.createCriteria();
        criteria.andMerchantidEqualTo(merchantId);
        List<WeibarMerchantsPriceTimeSettingInfo> timeSettingInfoList = weibarMerchantsPriceTimeSettingInfoMapper.selectByExample(priceTimeSettingInfoCriteria);

        List<PriceTimeSettingInfo> results = new ArrayList<>();
        for(WeibarMerchantsPriceTimeSettingInfo w : timeSettingInfoList){
            results.add(PriceTimeSettingInfo.getPriceTimeSettingInfo(w));
        }
        return results;
    }


    /**
     * 获取具体配置
     * @param merchantId
     * @param second
     * @return
     * @throws BaseException
     */
    public WeibarMerchantsPriceTimeSettingInfo getPriceTimeSettingInfoById(Long merchantId,Integer second) throws BaseException {

        WeibarMerchantsPriceTimeSettingInfoCriteria priceTimeSettingInfoCriteria = new WeibarMerchantsPriceTimeSettingInfoCriteria();
        WeibarMerchantsPriceTimeSettingInfoCriteria.Criteria criteria = priceTimeSettingInfoCriteria.createCriteria();
        criteria.andMerchantidEqualTo(merchantId);
        criteria.andTimesidEqualTo(second);
        List<WeibarMerchantsPriceTimeSettingInfo> timeSettingInfoList = weibarMerchantsPriceTimeSettingInfoMapper.selectByExample(priceTimeSettingInfoCriteria);
        if(timeSettingInfoList == null || timeSettingInfoList.size() == 0){
            throw BaseException.getException(ErrorCodeEnum.BARPING_ERROR_NOT_SETING.getCode());
        }
        return timeSettingInfoList.get(0);
    }

}
