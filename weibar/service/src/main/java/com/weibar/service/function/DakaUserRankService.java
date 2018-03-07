package com.weibar.service.function;

import com.weibar.pojo.comparator.DakaUserComparator;
import com.weibar.pojo.db.DakaUser;
import com.weibar.pojo.db.DakaUserCriteria;
import com.weibar.pojo.db.DakaUserRank;
import com.weibar.pojo.db.DakaUserRankCriteria;
import com.weibar.pojo.result.DakaResultUserRank;
import com.weibar.service.mapper.DakaUserMapper;
import com.weibar.service.mapper.DakaUserRankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    public List<DakaResultUserRank> getUserRanks(){
        DakaUserRankCriteria dakaUserRankCriteria = new DakaUserRankCriteria();
        DakaUserRankCriteria.Criteria criteria = dakaUserRankCriteria.createCriteria();
        dakaUserRankCriteria.setOrderByClause(" rank ");
        List<DakaUserRank> dakaUserRankList = dakaUserRankMapper.selectByExample(dakaUserRankCriteria);
        return DakaResultUserRank.toDakaResultUserRanks(dakaUserRankList);
    }

    public void refreshRanks(){
        DakaUserCriteria dakaUserCriteria = new DakaUserCriteria();
        List<DakaUser> userList = dakaUserMapper.selectByExample(dakaUserCriteria);
        Collections.sort(userList,new DakaUserComparator());
    }


}
