package com.weibar.service.function;

import com.weibar.pojo.db.WeibarWsCache;
import com.weibar.pojo.db.WeibarWsCacheCriteria;
import com.weibar.service.mapper.WeibarWsCacheMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/12/29.
 * 保存websocket信息（先保存在数据库，后续考虑引入消息队列）
 */
@Service
public class WsCacheService {

    @Autowired
    private WeibarWsCacheMapper weibarWsCacheMapper ;

    private static final int DEFAULT_COUNT = 30;

    public void addNewWs(String url,String content){
        WeibarWsCache weibarWsCache = new WeibarWsCache();
        weibarWsCache.setCreateTime(new Date());
        weibarWsCache.setSubUrl(url);
        weibarWsCache.setRes(content);
        weibarWsCacheMapper.insert(weibarWsCache);
    }

    public List<WeibarWsCache> getCacheWs(){
        WeibarWsCacheCriteria cacheCriteria = new WeibarWsCacheCriteria();
        cacheCriteria.setLimit(DEFAULT_COUNT);
        cacheCriteria.setOrderByClause(" id asc ");
        return weibarWsCacheMapper.selectByExample(cacheCriteria);
    }

    public void deleteWsCache(long id){
        weibarWsCacheMapper.deleteByPrimaryKey(id);
    }

    public void deleteWsCache(List<Long> ids){
        if(ids != null && ids.size() != 0) {
            WeibarWsCacheCriteria weibarWsCacheCriteria = new WeibarWsCacheCriteria();
            WeibarWsCacheCriteria.Criteria criteria = weibarWsCacheCriteria.createCriteria();
            criteria.andIdIn(ids);
            weibarWsCacheMapper.deleteByExample(weibarWsCacheCriteria);
        }
    }
}
