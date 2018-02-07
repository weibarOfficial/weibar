package com.weibar.pojo.exception;

import com.weibar.pojo.enu.ErrorCodeEnum;

/**
 * Created by Administrator on 2017/10/30.
 */

public class BaseException extends Exception{


    public static BaseException getException(int code){
        return new BaseException(code, ErrorCodeEnum.getErrorCodeEnumByCode(code).getMsg());
    }

    private int code;
    private String msg;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public BaseException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
