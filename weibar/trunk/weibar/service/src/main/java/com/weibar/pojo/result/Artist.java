package com.weibar.pojo.result;

import com.weibar.pojo.db.WeibarMerchantsArtist;

/**
 * Created by Administrator on 2017/12/5.
 */
public class Artist {


    public static Artist getArtist(WeibarMerchantsArtist artist){
        Artist a = new Artist();
        a.setName(artist.getNickname());
        a.setUserId(artist.getUserId());
        a.setImgUrl(artist.getUserPicture());
        a.setOpenId(artist.getOpenid());
        return a;
    }

    private Long userId;
    private String openId;
    private String name;
    private String imgUrl;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
