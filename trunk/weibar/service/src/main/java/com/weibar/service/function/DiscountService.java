package com.weibar.service.function;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Administrator on 2017/11/27.
 * 计算各种抽水比例
 */
@Service
public class DiscountService {

    // 红包打折比例（暂时全额反给用户）
    private static BigDecimal REDPACKAGE_DISCOUNT = new BigDecimal(1);

    private static BigDecimal GIVE_DISCOUNT = new BigDecimal(1);

    public BigDecimal getRedPackageDiscount(BigDecimal amount){
        return amount.multiply(REDPACKAGE_DISCOUNT).setScale(2, RoundingMode.DOWN);
    }

    public BigDecimal getGiveDiscount(BigDecimal amount){
        return amount.multiply(GIVE_DISCOUNT).setScale(2, RoundingMode.DOWN);
    }
}
