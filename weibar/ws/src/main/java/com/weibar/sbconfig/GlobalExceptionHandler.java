package com.weibar.sbconfig;


import com.weibar.pojo.enu.ErrorCodeEnum;
import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/10/31.
 * 处理抛异常的情况
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public BaseResult jsonBaseExceptionHandler(HttpServletRequest req, BaseException e) throws Exception {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(e.getCode());
        baseResult.setMessage(e.getMsg());
        logger.error("jsonBaseExceptionHandler " + baseResult);
        return baseResult;
    }


    @ExceptionHandler(value = SQLException.class)
    @ResponseBody
    public BaseResult jsonSQLExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(ErrorCodeEnum.DB_DB_ERROR.getCode());
        baseResult.setMessage(ErrorCodeEnum.DB_DB_ERROR.getMsg());
        logger.error("jsonSQLExceptionHandler " + baseResult,e);
        return baseResult;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResult jsonExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(ErrorCodeEnum.UNKOWN_ERROR.getCode());
        baseResult.setMessage(e.getMessage());
        logger.error("jsonExceptionHandler " + baseResult,e);
        return baseResult;
    }





}
