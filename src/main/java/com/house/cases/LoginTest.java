package com.house.cases;

import com.house.config.ConfigFile;
import com.house.config.TestConfig;
import com.house.entity.LoginCases;
import com.house.util.DatabaseUtil;
import com.house.util.HttpClientUtils;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenglijuan
 * @Data: 2022/9/1  15:27
 * @Decription:
 * @Modified:
 */
public class LoginTest {

    //测试前赋值工作
    @BeforeTest(groups = "loginsuccess",description = "测试准备工作")
    public void beforeTest(){
        //首页登录
        TestConfig.loginUrl = ConfigFile.getUrl("loginUrl");
        //
        TestConfig.getEscrowAgreementListUrl = ConfigFile.getUrl("EscrowAgreementList");

        TestConfig.interfaceVersion = ConfigFile.getValue("interfaceVersion");

        TestConfig.requestTime = ConfigFile.getValue("requestTime");
    }

    @Test(groups = "loginsuccess",description = "用户登录成功接口测试")
    public void loginsuccess() throws Exception {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        //查询测试用例
        LoginCases cases = sqlSession.selectOne("loginCase",2);

        List nvps = new ArrayList();
        nvps.add(new BasicNameValuePair("interfaceVersion", cases.getInterfaceVersion()));
        nvps.add(new BasicNameValuePair("requestTime", cases.getRequestTime()));
        nvps.add(new BasicNameValuePair("loginPassword", cases.getPassword()));
        nvps.add(new BasicNameValuePair("theName", cases.getUsername()));

        //根据测试用例中配置的参数发起一个请求
        String result = HttpClientUtils.postWithParam(TestConfig.loginUrl,nvps);
        Assert.assertEquals(cases.getExpected(),result);
        System.out.println(cases);

    }

    @Test(groups = "loginFalse",description = "用户登录失败接口测试")
    public void loginFalse() throws Exception {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        LoginCases cases = sqlSession.selectOne("loginCase",2);
        System.out.println(cases.toString());
        System.out.println(TestConfig.loginUrl);
    }


}
