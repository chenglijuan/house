package com.house.config;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Author: chenglijuan
 * @Data: 2022/8/31  16:02
 * @Decription:
 * @Modified:
 */
//拼接url的工具类
public class ConfigFile {

    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

//    public static void main(String[] args) {
//        System.out.println(bundle.getString("test.url"));
//    }

    public static String getUrl(String urlName){

        if("loginUrl".equals(urlName)){
            return bundle.getString("base.url") + bundle.getString("base.login.url");
        }
        return null;
    }


}
