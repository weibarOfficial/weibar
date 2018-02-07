package com.weibar.pojo.result;

import com.weibar.pojo.enu.ErrorCodeEnum;

/**
 * Created by Administrator on 2017/10/31.
 */
public class BaseResult {


    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static BaseResult getSuccessfulResult(Object data){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(ErrorCodeEnum.SUCCESS.getCode());
        baseResult.setMessage(ErrorCodeEnum.SUCCESS.getMsg());
        baseResult.setData(data);
        return baseResult;
    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Integer code;
    private String message;
    private Object data;


}
