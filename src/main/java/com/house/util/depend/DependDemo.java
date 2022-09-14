package com.house.util.depend;

import org.testng.annotations.Test;

/**
 * @Author: clj
 * @Data: 2022/9/13  16:25
 * @Decription:
 * @Modified:
 */
public class DependDemo {

    @Test
    public void test1(){
        System.out.println("test1==========>");
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2==========>");
    }

}
