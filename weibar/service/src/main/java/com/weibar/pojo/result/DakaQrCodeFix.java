package com.weibar.pojo.result;

import cn.binarywang.wx.miniapp.bean.AbstractWxMaQrcodeWrapper;

import com.weibar.pojo.exception.BaseException;
import com.weibar.utils.JsonConverter;

/**
 * Created by Administrator on 2018/2/27.
 * 为了解决小程序qrcode而新增的一个类
 */

public class DakaQrCodeFix extends AbstractWxMaQrcodeWrapper {

    private static final long serialVersionUID = 4782193774524960401L;
    private String scene;
    private String page;

    private int width = 430;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isAuto_color() {
        return auto_color;
    }

    public void setAuto_color(boolean auto_color) {
        this.auto_color = auto_color;
    }

    public String getLine_color() {
        return line_color;
    }

    public void setLine_color(String line_color) {
        this.line_color = line_color;
    }

    private boolean auto_color = true;

    private String line_color ;


    @Override
    public String toString() {
        String wxMaWxcodeLimitJson = null;
        try {
            wxMaWxcodeLimitJson = JsonConverter.toJson(this);
        } catch (BaseException e) {
            return null;
        }
        return wxMaWxcodeLimitJson;
    }
}
