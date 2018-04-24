package com.weibar.service.function;

import com.weibar.pojo.db.WeibarGoodsSettingInfo;
import com.weibar.pojo.db.WeibarGoodsSettingInfoCriteria;
import com.weibar.pojo.db.WeibarMerchantsGoodsSettingInfo;
import com.weibar.pojo.db.WeibarMerchantsGoodsSettingInfoCriteria;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.GoodsSettingInfo;
import com.weibar.service.mapper.WeibarGoodsSettingInfoMapper;
import com.weibar.service.mapper.WeibarMerchantsGoodsSettingInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/5.
 */
@Service
public class GoodsService {

    @Autowired
    private WeibarMerchantsGoodsSettingInfoMapper weibarMerchantsGoodsSettingInfoMapper;
    @Autowired
    private WeibarGoodsSettingInfoMapper weibarGoodsSettingInfoMapper;



    public void updateMerchantGoods(Long merchantId, Map<Long,BigDecimal> goodsPrices){
        if(goodsPrices == null){
            return;
        }
        for(Long goodsId : goodsPrices.keySet()){
            updateMerchantSingleGoods(merchantId,goodsId,goodsPrices.get(goodsId));
        }
    }


    public void updateMerchantSingleGoods(Long merchantId,Long goodsId,BigDecimal price){
        WeibarMerchantsGoodsSettingInfoCriteria merchantsGoodsSettingInfoCriteria = new WeibarMerchantsGoodsSettingInfoCriteria();
        WeibarMerchantsGoodsSettingInfoCriteria.Criteria criteria = merchantsGoodsSettingInfoCriteria.createCriteria();
        criteria.andMerchantidEqualTo(merchantId);
        criteria.andGoodsidEqualTo(goodsId);
        List<WeibarMerchantsGoodsSettingInfo> merchantsGoodsSettingInfos = weibarMerchantsGoodsSettingInfoMapper.selectByExample(merchantsGoodsSettingInfoCriteria);
        if(merchantsGoodsSettingInfos != null && merchantsGoodsSettingInfos.size() != 0){
            WeibarMerchantsGoodsSettingInfo merchantsGoodsSettingInfo = merchantsGoodsSettingInfos.get(0);
            merchantsGoodsSettingInfo.setAmount(price);
            weibarMerchantsGoodsSettingInfoMapper.updateByPrimaryKey(merchantsGoodsSettingInfo);
        }
    }



    public void generateMerchantDefaultGoods(Long merchantId){
        WeibarGoodsSettingInfoCriteria weibarGoodsSettingInfoCriteria = new WeibarGoodsSettingInfoCriteria();
        List<WeibarGoodsSettingInfo> goodsSettingInfoList = weibarGoodsSettingInfoMapper.selectByExample(weibarGoodsSettingInfoCriteria);
        for(WeibarGoodsSettingInfo weibarGoodsSettingInfo : goodsSettingInfoList){
            WeibarMerchantsGoodsSettingInfo weibarMerchantsGoodsSettingInfo = new WeibarMerchantsGoodsSettingInfo();
            weibarMerchantsGoodsSettingInfo.setGoodsname(weibarGoodsSettingInfo.getGoodsname());
            weibarMerchantsGoodsSettingInfo.setGoodsid(weibarGoodsSettingInfo.getGoodsid());
            weibarMerchantsGoodsSettingInfo.setGoodsurl(weibarGoodsSettingInfo.getGoodsurl());
            weibarMerchantsGoodsSettingInfo.setGoodsBigUrl(weibarGoodsSettingInfo.getGoodsBigUrl());
            weibarMerchantsGoodsSettingInfo.setWidth(weibarGoodsSettingInfo.getWidth());
            weibarMerchantsGoodsSettingInfo.setHeight(weibarGoodsSettingInfo.getHeight());
            weibarMerchantsGoodsSettingInfo.setGoodsMsg(weibarGoodsSettingInfo.getGoodsMsg());
            weibarMerchantsGoodsSettingInfo.setTime(weibarGoodsSettingInfo.getTime());
            weibarMerchantsGoodsSettingInfo.setAmount(weibarGoodsSettingInfo.getAmount());
            weibarMerchantsGoodsSettingInfo.setCreateTime(new Date());
            weibarMerchantsGoodsSettingInfo.setUpdateTime(new Date());
            weibarMerchantsGoodsSettingInfo.setMerchantid(merchantId);
            weibarMerchantsGoodsSettingInfoMapper.insert(weibarMerchantsGoodsSettingInfo);
        }

    }



    public String generateGoods(){
        InputStream inputStream = GoodsService.class.getResourceAsStream("/gift.txt");
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream,"utf-8"));
            String str = null;
            while ((str = reader.readLine()) != null) {
                String name = str;

                WeibarGoodsSettingInfo weibarGoodsSettingInfo = new WeibarGoodsSettingInfo();
                weibarGoodsSettingInfo.setGoodsname(name);
                weibarGoodsSettingInfo.setGoodsid(System.currentTimeMillis());
                weibarGoodsSettingInfo.setGoodsurl(reader.readLine());
                weibarGoodsSettingInfo.setGoodsBigUrl(reader.readLine());
                weibarGoodsSettingInfo.setWidth(Integer.parseInt(reader.readLine()));
                weibarGoodsSettingInfo.setHeight(Integer.parseInt(reader.readLine()));
                String goodsMsg = reader.readLine();
                weibarGoodsSettingInfo.setGoodsMsg(goodsMsg);
                weibarGoodsSettingInfo.setTime(Integer.parseInt(reader.readLine()));
                String amount = reader.readLine();
                BigDecimal bigDecimal = new BigDecimal(amount);
                weibarGoodsSettingInfo.setAmount(bigDecimal);
                weibarGoodsSettingInfo.setCreateTime(new Date());
                weibarGoodsSettingInfo.setUpdateTime(new Date());
                weibarGoodsSettingInfoMapper.insert(weibarGoodsSettingInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputStream != null ){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<GoodsSettingInfo> getGoodsSettingInfo(Long merchantId) {
        WeibarMerchantsGoodsSettingInfoCriteria settingInfoCriteria = new WeibarMerchantsGoodsSettingInfoCriteria();
        WeibarMerchantsGoodsSettingInfoCriteria.Criteria criteria = settingInfoCriteria.createCriteria();
        criteria.andMerchantidEqualTo(merchantId);
        List<WeibarMerchantsGoodsSettingInfo> settingInfos = weibarMerchantsGoodsSettingInfoMapper.selectByExample(settingInfoCriteria);
        List<GoodsSettingInfo> result = new ArrayList<>();
        for (WeibarMerchantsGoodsSettingInfo settingInfo : settingInfos) {
            result.add(GoodsSettingInfo.getGoodsSettingInfo(settingInfo));
        }
        return result;
    }

    public GoodsSettingInfo getGoodsSettingInfoById(Long goodsId, Long merchantId) throws BaseException {
        WeibarMerchantsGoodsSettingInfoCriteria settingInfoCriteria = new WeibarMerchantsGoodsSettingInfoCriteria();
        WeibarMerchantsGoodsSettingInfoCriteria.Criteria criteria = settingInfoCriteria.createCriteria();
        criteria.andMerchantidEqualTo(merchantId);
        criteria.andGoodsidEqualTo(goodsId);
        List<WeibarMerchantsGoodsSettingInfo> settingInfos = weibarMerchantsGoodsSettingInfoMapper.selectByExample(settingInfoCriteria);
        if (settingInfos == null || settingInfos.size() <= 0) {
            throw BaseException.getException(ErrorCodeEnum.GIVE_ERROR_GOODS_NOT_EXIST.getCode());
        }
        return GoodsSettingInfo.getGoodsSettingInfo(settingInfos.get(0));
    }
}
