package com.house.util;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @Author: clj
 * @Data: 2022/9/13  15:39
 * @Decription:
 * @Modified:
 */
public class GroupDemo {


    @Test(groups = "server")
    public void test1(){
        System.out.println("test1=============>");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("test2=============>");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("test3=============>");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("test4=============>");
    }


    @BeforeGroups("client")
    public void beforeGroup(){
        System.out.println("beforeGroup=============>");
    }

    @AfterGroups("client")
    public void afterGroup(){
        System.out.println("afterGroup=============>");
    }





}
