package com.weibar.service.function;


import com.weibar.pojo.db.MerchantIncome;
import com.weibar.pojo.db.MerchantIncomeCriteria;
import com.weibar.pojo.result.MerchantIncomeResult;
import com.weibar.service.mapper.MerchantIncomeMapper;
import com.weibar.utils.DatesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class MerchantIncomeService {


    @Autowired
    private MerchantIncomeMapper merchantIncomeMapper;


    public MerchantIncome getMerchantIncomeByDate(Date date,Long merchantId){
        MerchantIncomeCriteria merchantIncomeCriteria = new MerchantIncomeCriteria();
        MerchantIncomeCriteria.Criteria criteria = merchantIncomeCriteria.createCriteria();
        criteria.andAuditDateEqualTo(DatesUtils.removeTime(date));
        criteria.andMerchantidEqualTo(merchantId);
        List<MerchantIncome> merchantIncomes =  merchantIncomeMapper.selectByExample(merchantIncomeCriteria);
        if(merchantIncomes == null || merchantIncomes.size() == 0){
            /**
             * 根据昨天的数据生成今天的记录
             */
            MerchantIncomeCriteria merchantIncomeCriteria1 = new MerchantIncomeCriteria();
            MerchantIncomeCriteria.Criteria criteria1 = merchantIncomeCriteria1.createCriteria();
            merchantIncomeCriteria1.setOrderByClause(" audit_date desc ");
            //criteria1.andAuditDateEqualTo(DatesUtils.getRemovedTimeYesterday(date));
            criteria1.andMerchantidEqualTo(merchantId);
            List<MerchantIncome> merchantIncomes1 =  merchantIncomeMapper.selectByExample(merchantIncomeCriteria1);

            MerchantIncome merchantIncome = new MerchantIncome();
            Date now = new Date();
            merchantIncome.setCreateTime(now);
            merchantIncome.setUpdateTime(now);
            merchantIncome.setIncome(new BigDecimal(0));
            merchantIncome.setPeople(0);
            merchantIncome.setMerchantid(merchantId);
            merchantIncome.setAuditDate(DatesUtils.removeTime(date));

            if(merchantIncomes1 == null || merchantIncomes1.size() == 0){
                merchantIncome.setTotalIncome(new BigDecimal(0));
                merchantIncome.setTotalPeople(0);
            }else{
                merchantIncome.setTotalIncome(merchantIncomes1.get(0).getTotalIncome());
                merchantIncome.setTotalPeople(merchantIncomes1.get(0).getTotalPeople());
            }
            merchantIncomeMapper.insert(merchantIncome);
            return getMerchantIncomeByDate(date,merchantId);

        }else{
            return merchantIncomes.get(0);
        }
    }


    public int getMerchantIncomeCount(Long merchantId){
        MerchantIncomeCriteria merchantIncomeCriteria = new MerchantIncomeCriteria();
        MerchantIncomeCriteria.Criteria criteria = merchantIncomeCriteria.createCriteria();
        criteria.andMerchantidEqualTo(merchantId);
        return merchantIncomeMapper.countByExample(merchantIncomeCriteria);
    }


    public List<MerchantIncomeResult> getMerchantIncomes(Long merchantId,int begin,int count){
        MerchantIncomeCriteria merchantIncomeCriteria = new MerchantIncomeCriteria();
        MerchantIncomeCriteria.Criteria criteria = merchantIncomeCriteria.createCriteria();
        criteria.andMerchantidEqualTo(merchantId);
        merchantIncomeCriteria.setLimit(count);
        merchantIncomeCriteria.setOffset(begin);
        merchantIncomeCriteria.setOrderByClause(" audit_date desc ");
        List<MerchantIncome> merchantIncomes =  merchantIncomeMapper.selectByExample(merchantIncomeCriteria);
        return MerchantIncomeResult.getMerchantIncomes(merchantIncomes);
    }






    public void addMerchantIncome(Date date,Long merchantId,BigDecimal amount){
        MerchantIncome merchantIncome = getMerchantIncomeByDate(date,merchantId);
        //人次
        merchantIncome.setTotalPeople(merchantIncome.getTotalPeople() + 1);
        merchantIncome.setTotalIncome(merchantIncome.getTotalIncome().add(amount));
        merchantIncome.setPeople(merchantIncome.getPeople() + 1);
        merchantIncome.setIncome(merchantIncome.getIncome().add(amount));
        merchantIncome.setUpdateTime(new Date());
        merchantIncomeMapper.updateByPrimaryKey(merchantIncome);
    }
}
