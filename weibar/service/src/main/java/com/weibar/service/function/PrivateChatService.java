package com.weibar.service.function;

import com.google.common.collect.Lists;
import com.weibar.pojo.consts.WebSocketConsts;
import com.weibar.pojo.db.*;
import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.enu.MessageTypeEnum;
import com.weibar.pojo.enu.PrivateChatStatusEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.PrivateChat;
import com.weibar.service.mapper.WeibarPrivateChatIdMapMapper;
import com.weibar.service.mapper.WeibarPrivateChatMapper;
import com.weibar.utils.IdGenerator;
import com.weibar.utils.JsonConverter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
@Service
public class PrivateChatService {

    @Autowired
    private WeibarPrivateChatMapper weibarPrivateChatMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private WsCacheService wsCacheService;

    public static final int DEFAULT_CHAT_COUNT = 50;


    @Autowired
    private WeibarPrivateChatIdMapMapper weibarPrivateChatIdMapMapper;


    public Long getChatId(Long fromUserId,Long toUserId) throws BaseException {

        //判断是否存在
        userService.getUserById(toUserId);
        WeibarPrivateChatIdMapCriteria weibarPrivateChatIdMapCriteria = new WeibarPrivateChatIdMapCriteria();
        WeibarPrivateChatIdMapCriteria.Criteria criteria = weibarPrivateChatIdMapCriteria.createCriteria();
        List<Long> userIds = new ArrayList<>();
        userIds.add(fromUserId);
        userIds.add(toUserId);

        criteria.andFromUserIdIn(userIds);
        criteria.andToUserIdIn(userIds);
        List<WeibarPrivateChatIdMap> list = weibarPrivateChatIdMapMapper.selectByExample(weibarPrivateChatIdMapCriteria);
        if(list == null || list.size() == 0){
            WeibarPrivateChatIdMap chatIdMap = new WeibarPrivateChatIdMap();
            Date now = new Date();
            chatIdMap.setCreateTime(now);
            chatIdMap.setUpdateTime(now);
            chatIdMap.setFromUserId(fromUserId);
            chatIdMap.setToUserId(toUserId);
            Long chatId = IdGenerator.generateIdByTime();
            chatIdMap.setChatId(chatId);
            weibarPrivateChatIdMapMapper.insert(chatIdMap);
            return chatId;
        }else{
            return list.get(0).getChatId();
        }
    }



    public List<PrivateChat> getPrivateChatListByChatId(Long chatId,Long endTime,Integer count){
        List<WeibarPrivateChat> chatList = doGetPrivateChat(chatId,endTime,count);
        List<PrivateChat> resultList = PrivateChat.getPrivateChats(chatList);
        return Lists.reverse(resultList);
    }

    /**
     * 发送私聊消息
     * @param message
     * @param imgUrl
     * @return
     * @throws BaseException
     */
    public PrivateChat addPrivateChatMessage(UserBaseInfo fromUser,UserBaseInfo toUser, String message, String imgUrl,Long chatId) throws BaseException {

        if(StringUtils.isEmpty(message) && StringUtils.isEmpty(imgUrl)){
            throw BaseException.getException(ErrorCodeEnum.PRIVATE_WECHAT_EMPTY_MSG.getCode());
        }
        WeibarPrivateChat chat = new WeibarPrivateChat();
        Date now = new Date();
        chat.setUpdateTime(now);
        chat.setCreateTime(now);

        chat.setFromUserId(fromUser.getUserId());
        chat.setFromUserOpenid(fromUser.getOpenid());
        chat.setFromNickname(fromUser.getNickname());
        chat.setFromUserPicture(fromUser.getUserPicture());
        chat.setFromSex(fromUser.getSex());
        chat.setToUserId(toUser.getUserId());
        chat.setToUserOpenid(toUser.getOpenid());
        chat.setToNickname(toUser.getNickname());
        chat.setToUserPicture(toUser.getUserPicture());
        chat.setToSex(toUser.getSex());

        chat.setChatId(chatId);

        if(StringUtils.isEmpty(message)){
            chat.setType(MessageTypeEnum.PHOTO.getType());
        }else if(StringUtils.isEmpty(imgUrl)){
            chat.setType(MessageTypeEnum.WORDS.getType());
        }else{
            chat.setType(MessageTypeEnum.WORDS_AND_PHOTO.getType());
        }

        chat.setImgUrl(imgUrl);
        chat.setMessage(message);

        chat.setStatus(PrivateChatStatusEnum.NOT_READ.getState());
        weibarPrivateChatMapper.insert(chat);

        PrivateChat privateChat = PrivateChat.getPrivateChat(chat);
        wsSend(privateChat);
        return privateChat;
    }


    public PrivateChat addPrivateChatGiveMessage(UserBaseInfo fromUser,UserBaseInfo toUser,
                                                 String giveContent,String goodsName,
                                                 String goodsImgUrl,Long chatId) throws BaseException {

        WeibarPrivateChat chat = new WeibarPrivateChat();
        Date now = new Date();
        chat.setUpdateTime(now);
        chat.setCreateTime(now);

        chat.setFromUserId(fromUser.getUserId());
        chat.setFromUserOpenid(fromUser.getOpenid());
        chat.setFromNickname(fromUser.getNickname());
        chat.setFromUserPicture(fromUser.getUserPicture());
        chat.setToUserId(toUser.getUserId());
        chat.setToUserOpenid(toUser.getOpenid());
        chat.setToNickname(toUser.getNickname());
        chat.setToUserPicture(toUser.getUserPicture());

        chat.setGiveContent(giveContent);
        chat.setGiveGoodsname(goodsName);
        chat.setGiveUserImgUrl(toUser.getUserPicture());
        chat.setGiveGoodsurl(goodsImgUrl);
        chat.setGiveUserName(toUser.getNickname());
        chat.setType(MessageTypeEnum.GIVE.getType());
        chat.setChatId(chatId);
        weibarPrivateChatMapper.insert(chat);

        PrivateChat privateChat = PrivateChat.getPrivateChat(chat);
        wsSend(privateChat);
        return privateChat;
    }






    private List<WeibarPrivateChat> doGetPrivateChat(Long chatId,Long endTime,Integer count){

        WeibarPrivateChatCriteria privateChatCriteria = new WeibarPrivateChatCriteria();
        privateChatCriteria.setLimit(count);
        WeibarPrivateChatCriteria.Criteria criteria = privateChatCriteria.createCriteria();
        criteria.andChatIdEqualTo(chatId);

        criteria.andCreateTimeLessThan(new Date(endTime));
        privateChatCriteria.setOrderByClause(" create_time desc ");

        List<WeibarPrivateChat> weibarPrivateChatList = weibarPrivateChatMapper.selectByExample(privateChatCriteria);
        return weibarPrivateChatList;
    }

    private void wsSend(PrivateChat privateChat) throws BaseException {
        List<PrivateChat> privateChatList = new ArrayList<>();
        privateChatList.add(privateChat);
        wsSend(privateChatList);
    }

    private void wsSend(List<PrivateChat> privateChat) throws BaseException {
        String chatId = privateChat.get(0).getChatId().toString();
        wsCacheService.addNewWs(WebSocketConsts.WS_PATH_SEND_PRIVATE_CHAT_PREFIX + chatId, JsonConverter.toJson(privateChat));
    }

}
