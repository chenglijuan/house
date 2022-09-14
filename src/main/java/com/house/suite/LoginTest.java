package com.house.suite;

import org.testng.annotations.*;

/**
 * @Author: chenglijuan
 * @Data: 2022/9/13  10:49
 * @Decription:
 * @Modified:
 */
public class LoginTest {


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod=============>");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod=============>");
    }

    @Test
    public void loginsuccess(){
        System.out.println("loginsuccess====================>");
    }


    //设置enabled = false 表示该方法不执行
    @Test(enabled = false)
    public void loginfail(){
        System.out.println("loginsuccess====================>");
    }


    @BeforeTest
    public void beforeTest(){
        System.out.println("LoginTest---beforeTest=============>");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("LoginTest---afterTest=============>");
    }

}
