package com.house.cases;

import com.house.config.TestConfig;
import com.house.entity.EscrowAgreementListCases;
import com.house.util.DatabaseUtil;
import com.house.util.HttpClientUtils;
import org.apache.http.message.BasicNameValuePair;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenglijuan
 * @Data: 2022/9/1  16:22
 * @Decription:
 * @Modified:
 */
public class EscrowAgreementListTest {

    @Test(dependsOnGroups = "loginsuccess",description = "获取合作协议列表" ,enabled = false)
    public void getListInfo() throws Exception {

        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        EscrowAgreementListCases cases = sqlSession.selectOne("escrowAgreementList",1);
        List nvps = new ArrayList();
        nvps.add(new BasicNameValuePair("interfaceVersion", TestConfig.interfaceVersion));
        nvps.add(new BasicNameValuePair("requestTime", TestConfig.requestTime));
        nvps.add(new BasicNameValuePair("countPerPage", "1"));
        nvps.add(new BasicNameValuePair("keyword", ""));
        nvps.add(new BasicNameValuePair("startDate",""));

        //根据测试用例中配置的参数发起一个请求
        String result = HttpClientUtils.postWithParam(TestConfig.getEscrowAgreementListUrl,nvps);


    }



}
