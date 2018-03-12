package com.weibar.pojo.result;

/**
 * Created by Administrator on 2018/3/12.
 */
public class DakaButton {

    private String text;
    private String buttonBindtap;
    private boolean disable;



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getButtonBindtap() {
        return buttonBindtap;
    }

    public void setButtonBindtap(String buttonBindtap) {
        this.buttonBindtap = buttonBindtap;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
}
