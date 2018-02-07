package com.weibar.service.function;

import com.weibar.pojo.db.WeibarMerchantsGameSettingInfo;
import com.weibar.pojo.db.WeibarMerchantsGameSettingInfoCriteria;
import com.weibar.pojo.db.WeibarMerchantsGoodsSettingInfo;
import com.weibar.pojo.db.WeibarMerchantsGoodsSettingInfoCriteria;
import com.weibar.pojo.result.GameFunction;
import com.weibar.service.mapper.WeibarMerchantsGameSettingInfoMapper;
import com.weibar.service.mapper.WeibarMerchantsGoodsSettingInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
@Service
public class GameFunctionService {




    @Autowired
    private WeibarMerchantsGameSettingInfoMapper weibarMerchantsGameSettingInfoMapper;

    private List<WeibarMerchantsGameSettingInfo> getfunctionList(Long merchantId){
        WeibarMerchantsGameSettingInfoCriteria settingInfoCriteria = new WeibarMerchantsGameSettingInfoCriteria();
        WeibarMerchantsGameSettingInfoCriteria.Criteria criteria = settingInfoCriteria.createCriteria();
        criteria.andMerchantidEqualTo(merchantId);
        return weibarMerchantsGameSettingInfoMapper.selectByExample(settingInfoCriteria);
    }

    public List<GameFunction> getGameFunctions(Long merchantId){
        List<WeibarMerchantsGameSettingInfo> infoList = getfunctionList(merchantId);
        List<GameFunction> gameFunctionList = new ArrayList<>();
        for(WeibarMerchantsGameSettingInfo info : infoList){
            gameFunctionList.add(GameFunction.getGameFunction(info));
        }
        return gameFunctionList;
    }



}
