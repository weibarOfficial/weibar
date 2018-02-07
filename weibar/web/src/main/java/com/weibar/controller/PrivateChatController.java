package com.weibar.controller;

import com.weibar.pojo.db.UserBaseInfo;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.pojo.result.UserInfo;
import com.weibar.service.function.PrivateChatService;
import com.weibar.service.function.UserService;
import com.weibar.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/30.
 */
@RestController
public class PrivateChatController {

    @Autowired
    private PrivateChatService privateChatService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/h5/addChat" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object addChat(
                          @RequestParam Long toUserId,
                          @RequestParam Long chatId,
                          @RequestParam(required = false) String content,
                          @RequestParam(required = false) String picUrl) throws BaseException {

        UserBaseInfo fromUser = userService.getUserById(LoginUserUtil.getLoginUserInfo().getUserId());
        UserBaseInfo toUser = userService.getUserById(toUserId);
        return BaseResult.getSuccessfulResult(privateChatService.addPrivateChatMessage(
                fromUser,toUser,content,picUrl,chatId
        ));
    }

    @RequestMapping(value = "/h5/getChatId" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object getChatId(@RequestParam Long toUserId) throws BaseException {
        return BaseResult.getSuccessfulResult(privateChatService.getChatId(LoginUserUtil.getLoginUserInfo().getUserId(),toUserId));
    }


    @RequestMapping(value = "/h5/chatList" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object chatList(
            @RequestParam Long chatId,
            @RequestParam Integer count,
            @RequestParam(required = false) Long endTime) throws BaseException {
        return BaseResult.getSuccessfulResult(
                privateChatService.getPrivateChatListByChatId(chatId,endTime,count));
    }

}
