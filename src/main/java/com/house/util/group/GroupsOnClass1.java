package com.house.util.group;

import org.testng.annotations.Test;

/**
 * @Author: clj
 * @Data: 2022/9/13  15:51
 * @Decription:
 * @Modified:
 */
//组测试配置到类上
@Test(groups = "stu")
public class GroupsOnClass1 {


    public void test1(){
        System.out.println("GroupsOnClass1=====test1");
    }

    public void test2(){
        System.out.println("GroupsOnClass1=====test2");
    }

}
