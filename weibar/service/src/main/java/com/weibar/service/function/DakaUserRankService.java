package com.weibar.service.function;

import com.weibar.pojo.comparator.DakaUserComparator;
import com.weibar.pojo.db.DakaUser;
import com.weibar.pojo.db.DakaUserCriteria;
import com.weibar.pojo.db.DakaUserRank;
import com.weibar.pojo.db.DakaUserRankCriteria;
import com.weibar.pojo.result.DakaResultUserRank;
import com.weibar.service.mapper.DakaUserMapper;
import com.weibar.service.mapper.DakaUserRankMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/3/7.
 */
@Service
public class DakaUserRankService {

    @Autowired
    private DakaUserRankMapper dakaUserRankMapper;
    @Autowired
    private DakaUserMapper dakaUserMapper;

    private static final Logger LOG = LoggerFactory.getLogger(DakaService.class);

    public List<DakaResultUserRank> getUserRanks(){
        DakaUserRankCriteria dakaUserRankCriteria = new DakaUserRankCriteria();
        dakaUserRankCriteria.setOrderByClause(" rank ");
        List<DakaUserRank> dakaUserRankList = dakaUserRankMapper.selectByExample(dakaUserRankCriteria);
        return DakaResultUserRank.toDakaResultUserRanks(dakaUserRankList);
    }

    public void refreshRanks(){
        DakaUserCriteria dakaUserCriteria = new DakaUserCriteria();
        DakaUserCriteria.Criteria criteria = dakaUserCriteria.createCriteria();
        criteria.andGetSumAmountGreaterThan(new BigDecimal(0));
        List<DakaUser> userList = dakaUserMapper.selectByExample(dakaUserCriteria);
        Collections.sort(userList,new DakaUserComparator());
        for(int i = 0; i < userList.size();i++){
            DakaUser dakaUser = userList.get(i);
            LOG.info("refreshRanks dakauser " + dakaUser);
            DakaUserRank dakaUserRank = getDakaUserRankByDakaUser(dakaUser);
            dakaUserRank.setRank(i+1);
            updateOrInsertDakaUserRank(dakaUserRank);
        }
    }


    private void updateOrInsertDakaUserRank(DakaUserRank dakaUserRank){
        DakaUserRankCriteria dakaUserRankCriteria = new DakaUserRankCriteria();
        DakaUserRankCriteria.Criteria criteria = dakaUserRankCriteria.createCriteria();
        criteria.andUserIdEqualTo(dakaUserRank.getUserId());
        List<DakaUserRank> rankList = dakaUserRankMapper.selectByExample(dakaUserRankCriteria);
        if(rankList == null || rankList.size() == 0){
            dakaUserRankMapper.insert(dakaUserRank);
        }else{
            DakaUserRank rankOri = rankList.get(0);
            rankOri.setRank(dakaUserRank.getRank());
            rankOri.setNickname(dakaUserRank.getNickname());
            rankOri.setUserPicture(dakaUserRank.getUserPicture());
            rankOri.setGetSumAmount(dakaUserRank.getGetSumAmount());
            rankOri.setUpdateTime(dakaUserRank.getUpdateTime());
            dakaUserRankMapper.updateByPrimaryKey(rankOri);
        }
    }


    private DakaUserRank getDakaUserRankByDakaUser(DakaUser dakaUser){
        Date now = new Date();
        DakaUserRank dakaUserRank = new DakaUserRank();
        dakaUserRank.setUserPicture(dakaUser.getUserPicture());
        dakaUserRank.setSex(dakaUser.getSex());
        dakaUserRank.setOpenid(dakaUser.getOpenid());
        dakaUserRank.setGetSumAmount(dakaUser.getGetSumAmount());
        dakaUserRank.setNickname(dakaUser.getNickname());
        dakaUserRank.setUserId(dakaUser.getUserId());
        dakaUserRank.setCreateTime(now);
        dakaUserRank.setUpdateTime(now);
        return dakaUserRank;
    }


}
