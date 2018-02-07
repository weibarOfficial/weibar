package com.weibar.pojo.enu;

import com.weibar.pojo.result.BarpinTheme;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 * 霸屏主题
 * 不入库 简单处理
 */
public enum BarpinThemeEnum {

    BIRSTDAY("生日霸屏",1,"http://weibar.oss-cn-shenzhen.aliyuncs.com/2b083dd825dfd56213f38dd7e8fd0581")
    ,LOVE("示爱霸屏",2,"http://weibar.oss-cn-shenzhen.aliyuncs.com/c9d7f39995fa8e00e15c506815328fca"),
    YUE("求约霸屏",3,"http://weibar.oss-cn-shenzhen.aliyuncs.com/08cf3931655c37d197443f82c3d7e734"),
    MARRY("求婚霸屏",4,"http://weibar.oss-cn-shenzhen.aliyuncs.com/83fd5a4670e7ca4b4edeca59acd138ba"),
    GIRL("女神霸屏",5,"http://weibar.oss-cn-shenzhen.aliyuncs.com/30098a71e2f4306defd4eb8eef1a49ba");

    BarpinThemeEnum(String name, Integer id, String imgUrl) {
        this.name = name;
        this.id = id;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    private String name;
    private Integer id;
    private String imgUrl;

    public static BarpinTheme getBarpinTheme(BarpinThemeEnum barpinThemeEnum){
        BarpinTheme barpinTheme = new BarpinTheme();
        barpinTheme.setId(barpinThemeEnum.getId());
        barpinTheme.setImgUrl(barpinThemeEnum.getImgUrl());
        barpinTheme.setName(barpinThemeEnum.getName());
        return barpinTheme;
    }

    public static List<BarpinTheme> getBarpinThemes(BarpinThemeEnum[] barpinThemeEnums){
        List<BarpinTheme> barpinThemes = new ArrayList<>();

        for(BarpinThemeEnum barpinThemeEnum : barpinThemeEnums){
            barpinThemes.add(getBarpinTheme(barpinThemeEnum));
        }
        return barpinThemes;
    }

}
