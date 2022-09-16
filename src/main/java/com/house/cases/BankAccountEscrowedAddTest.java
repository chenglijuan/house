package com.house.cases;

import com.alibaba.fastjson.JSONObject;
import com.house.config.TestConfig;
import com.house.entity.BankAccountEscrowedCases;
import com.house.entity.LoginCases;
import com.house.util.DatabaseUtil;
import com.house.util.HttpClientUtils;
import org.apache.http.message.BasicNameValuePair;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: clj
 * @Data: 2022/9/16  11:28
 * @Decription:
 * @Modified:
 */
public class BankAccountEscrowedAddTest {


    @Test(groups = "loginsuccess",description = "新增托管账号",dataProvider = "BankAccountEscrowedCasesList")
    public void test1(BankAccountEscrowedCases cases) throws Exception {

        SqlSession sqlSession = DatabaseUtil.getSqlSession();

        List nvps = new ArrayList();
        nvps.add(new BasicNameValuePair("interfaceVersion", cases.getInterfaceVersion()));
        nvps.add(new BasicNameValuePair("requestTime", "1"));
        nvps.add(new BasicNameValuePair("shortNameOfBank", cases.getShortNameOfBank()));
        nvps.add(new BasicNameValuePair("bankBranchId", cases.getBankBranchId()));
        nvps.add(new BasicNameValuePair("theName", cases.getTheName()));
        nvps.add(new BasicNameValuePair("theAccount", cases.getTheAccount()));
        nvps.add(new BasicNameValuePair("remark", cases.getRemark()));
        nvps.add(new BasicNameValuePair("isUsing", cases.getIsUsing()));
        nvps.add(new BasicNameValuePair("busiType", cases.getBusiType()));

//        String result = HttpClientUtils.postWithParam(TestConfig.tgxyBankAccountEscrowedAdd,nvps);
//
//        JSONObject resultObj = JSONObject.parseObject(result);
//
//        boolean flag = resultObj.getString("info").contains(cases.getExpected());
//        //添加断言
//        Assert.assertTrue(flag,cases.getExpected());

    }


    @DataProvider(name = "BankAccountEscrowedCasesList")
    public Object[] BankAccountEscrowedCasesList() throws Exception{
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        //从数据库中读取所有的测试用例对接口进行测试
        List<BankAccountEscrowedCases> cases = sqlSession.selectList("bankAccountEscroList");
        return cases.toArray();
    }

}
