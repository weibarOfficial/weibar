package com.weibar.service.function;

import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.db.WeibarMerchantsArtist;
import com.weibar.pojo.db.WeibarMerchantsArtistCriteria;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.Artist;
import com.weibar.service.mapper.WeibarMerchantsArtistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/12/5.
 */
@Service
public class ArtistService {

    @Autowired
    private WeibarMerchantsArtistMapper weibarMerchantsArtistMapper;

    @Autowired
    private UserService userService;

    public List<Artist> getArtistList(Long merchantId){
        WeibarMerchantsArtistCriteria merchantsArtistCriteria = new WeibarMerchantsArtistCriteria();
        WeibarMerchantsArtistCriteria.Criteria criteria = merchantsArtistCriteria.createCriteria();
        criteria.andMerchantidEqualTo(merchantId);
        List<WeibarMerchantsArtist> artistList = weibarMerchantsArtistMapper.selectByExample(merchantsArtistCriteria);
        List<Artist> result = new ArrayList<>();
        for(WeibarMerchantsArtist weibarMerchantsArtist : artistList){
            result.add(Artist.getArtist(weibarMerchantsArtist));
        }
        return result;
    }


    public Artist getArtist(Long merchantId,Long userId){
        WeibarMerchantsArtistCriteria merchantsArtistCriteria = new WeibarMerchantsArtistCriteria();
        WeibarMerchantsArtistCriteria.Criteria criteria = merchantsArtistCriteria.createCriteria();
        criteria.andMerchantidEqualTo(merchantId);
        criteria.andUserIdEqualTo(userId);
        List<WeibarMerchantsArtist> artistList = weibarMerchantsArtistMapper.selectByExample(merchantsArtistCriteria);
        if(artistList == null || artistList.size() == 0){
            return null;
        }else{
            return Artist.getArtist(artistList.get(0));
        }
    }


    public Artist createArtist(Long merchantId,Long userId) throws BaseException {
        Artist artist = getArtist(merchantId,userId);
        if(artist != null){
            return artist;
        }else{
            UserBaseInfo userBaseInfo = userService.getUserById(userId);
            WeibarMerchantsArtist weibarMerchantsArtist = new WeibarMerchantsArtist();
            Date now = new Date();
            weibarMerchantsArtist.setCreateTime(now);
            weibarMerchantsArtist.setUpdateTime(now);
            weibarMerchantsArtist.setUserId(userId);
            weibarMerchantsArtist.setMerchantid(merchantId);
            weibarMerchantsArtist.setNickname(userBaseInfo.getNickname());
            weibarMerchantsArtist.setOpenid(userBaseInfo.getOpenid());
            weibarMerchantsArtist.setUserPicture(userBaseInfo.getUserPicture());
            weibarMerchantsArtistMapper.insert(weibarMerchantsArtist);
            return getArtist(merchantId,userId);
        }
    }




}
