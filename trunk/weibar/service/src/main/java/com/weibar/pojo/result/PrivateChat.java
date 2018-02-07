package com.weibar.pojo.result;

import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.db.WeibarPrivateChat;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
public class PrivateChat {


    public static PrivateChat getPrivateChat(WeibarPrivateChat weibarPrivateChat){
        PrivateChat privateChat = new PrivateChat();
        privateChat.setType(weibarPrivateChat.getType());
        privateChat.setMessage(weibarPrivateChat.getMessage());
        privateChat.setImgUrl(weibarPrivateChat.getImgUrl());
        privateChat.setFromUserId(weibarPrivateChat.getFromUserId());
        privateChat.setCreateTime(weibarPrivateChat.getCreateTime());
        privateChat.setToUserId(weibarPrivateChat.getToUserId());
        privateChat.setFromOpenId(weibarPrivateChat.getFromUserOpenid());
        privateChat.setToOpenId(weibarPrivateChat.getToUserOpenid());
        privateChat.setFromUserNickName(weibarPrivateChat.getFromNickname());
        privateChat.setFromUserPic(weibarPrivateChat.getFromUserPicture());
        privateChat.setToUserNickName(weibarPrivateChat.getToNickname());
        privateChat.setToUserPic(weibarPrivateChat.getToUserPicture());
        privateChat.setToSex(weibarPrivateChat.getToSex());
        privateChat.setFromSex(weibarPrivateChat.getFromSex());
        privateChat.setChatId(weibarPrivateChat.getChatId());
        privateChat.setId(weibarPrivateChat.getId());

        if(StringUtils.isNotBlank(weibarPrivateChat.getGiveGoodsname())){
            GiveInfo giveInfo = new GiveInfo();
            giveInfo.setContent(weibarPrivateChat.getGiveContent());
            giveInfo.setGiftImgUrl(weibarPrivateChat.getGiveGoodsurl());
            giveInfo.setGiftName(weibarPrivateChat.getGiveGoodsname());
            giveInfo.setGivenUserImgUrl(weibarPrivateChat.getGiveUserImgUrl());
            giveInfo.setGivenUserName(weibarPrivateChat.getGiveUserName());
            privateChat.setGiveInfo(giveInfo);
        }

        return privateChat;
    }

    public static List<PrivateChat> getPrivateChats(List<WeibarPrivateChat> weibarPrivateChats){
        List<PrivateChat> privateChatList = new ArrayList<>();
        for(WeibarPrivateChat weibarPrivateChat : weibarPrivateChats){
            privateChatList.add(getPrivateChat(weibarPrivateChat));
        }
        return privateChatList;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getFromOpenId() {
        return fromOpenId;
    }

    public void setFromOpenId(String fromOpenId) {
        this.fromOpenId = fromOpenId;
    }

    public String getToOpenId() {
        return toOpenId;
    }

    public void setToOpenId(String toOpenId) {
        this.toOpenId = toOpenId;
    }

    public GiveInfo getGiveInfo() {
        return giveInfo;
    }

    public void setGiveInfo(GiveInfo giveInfo) {
        this.giveInfo = giveInfo;
    }


    public String getFromUserNickName() {
        return fromUserNickName;
    }

    public void setFromUserNickName(String fromUserNickName) {
        this.fromUserNickName = fromUserNickName;
    }

    public String getFromUserPic() {
        return fromUserPic;
    }

    public void setFromUserPic(String fromUserPic) {
        this.fromUserPic = fromUserPic;
    }

    public String getToUserNickName() {
        return toUserNickName;
    }

    public void setToUserNickName(String toUserNickName) {
        this.toUserNickName = toUserNickName;
    }

    public String getToUserPic() {
        return toUserPic;
    }

    public void setToUserPic(String toUserPic) {
        this.toUserPic = toUserPic;
    }

    public String getFromSex() {
        return fromSex;
    }

    public void setFromSex(String fromSex) {
        this.fromSex = fromSex;
    }

    public String getToSex() {
        return toSex;
    }

    public void setToSex(String toSex) {
        this.toSex = toSex;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    private Long fromUserId;
    private String fromOpenId;
    private String fromUserNickName;
    private String fromUserPic;
    private Long toUserId;
    private String toOpenId;
    private String toUserNickName;
    private String toUserPic;
    private Date createTime;
    private Integer type;
    private String message;
    private String imgUrl;
    private GiveInfo giveInfo;
    private String fromSex;
    private String toSex;
    private Long chatId;
}
