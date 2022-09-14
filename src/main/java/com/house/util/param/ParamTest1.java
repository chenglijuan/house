package com.house.util.param;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


/**
 * @Author: clj
 * @Data: 2022/9/13  16:35
 * @Decription:
 * @Modified:
 */
public class ParamTest1 {

//    @Test
//    @Parameters({"name", "age"})
//    public void test1(String name, int age) {
//        System.out.println("name=" + name + " age=" + age);
//    }
//
//    @Test(dataProvider = "getParam")
//    public void test2(String name, int age) {
//        System.out.println("name=" + name + " age=" + age);
//    }
//
//    @DataProvider(name = "getParam")
//    public Object[][] getParam() {
//        Object[][] result = new Object[][]{
//                {"zhangsan", 10},
//                {"lisi", 20}
//        };
//        return result;
//    }


    @Test(dataProvider = "getParam")
    public void test1(String name, int age) {
        System.out.println("name=" + name + " age=" + age);
    }

    @Test(dataProvider = "getParam")
    public void test2(String name, int age) {
        System.out.println("name=" + name + " age=" + age);
    }

    @DataProvider(name = "getParam")
    public Object[][] getParam(Method method) {
        Object[][] result = null;
        if ("test1".equals(method.getName())) {
            result = new Object[][]{
                    {"zhangsan", 10},
                    {"lisi", 20}
            };
        }else if("test2".equals(method.getName())){
            result = new Object[][]{
                    {"wangwu", 21},
                    {"zhaoliu", 18}
            };
        }
        return result;
    }


}
