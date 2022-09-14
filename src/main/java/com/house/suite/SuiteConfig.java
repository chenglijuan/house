package com.house.suite;

import org.testng.annotations.*;

/**
 * @Author: clj
 * @Data: 2022/9/13  10:49
 * @Decription:
 * @Modified:
 */

public class SuiteConfig {


    @BeforeSuite
    public void buforesuite(){
        System.out.println("buforesuite======================>");
    }

    @AfterSuite
    public void aftersuite(){
        System.out.println("aftersuite======================>");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest=============>");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest=============>");
    }



}
