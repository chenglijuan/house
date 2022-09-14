package com.house.util.group;

import org.testng.annotations.*;

/**
 * @Author: chenglijuan
 * @Data: 2022/9/8  16:50
 * @Decription:
 * @Modified:
 */
//组测试配置到方法上
public class TestDemo {


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite===============>");
    }


    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite===============>");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass=============>");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass=============>");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest=============>");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest=============>");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod=============>");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod=============>");
    }




    @Test
    public void test1(){
        System.out.println("test1=============>");
    }

    @Test
    public void test2(){
        System.out.println("test2=============>");
    }



}


