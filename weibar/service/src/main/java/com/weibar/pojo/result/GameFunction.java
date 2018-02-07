package com.weibar.pojo.result;

import com.weibar.pojo.db.WeibarMerchantsGameSettingInfo;
import com.weibar.pojo.db.WeibarMerchantsGoodsSettingInfo;

import java.io.StringWriter;

/**
 * 返回游戏列表
 * Created by Administrator on 2017/11/1.
 */
public class GameFunction {

    private String gameId;
    private String gameName;
    private String gameUrl;
    private String gameImgUrl;


    public static GameFunction getGameFunction(WeibarMerchantsGameSettingInfo gameSettingInfo){
        GameFunction gameFunction = new GameFunction();
        gameFunction.setGameId(gameSettingInfo.getGameid());
        gameFunction.setGameImgUrl(gameSettingInfo.getGameImgUrl());
        gameFunction.setGameName(gameSettingInfo.getGamename());
        gameFunction.setGameUrl(gameSettingInfo.getGameUrl());
        return gameFunction;
    }

    public String getGameImgUrl() {
        return gameImgUrl;
    }

    public void setGameImgUrl(String gameImgUrl) {
        this.gameImgUrl = gameImgUrl;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }
}
