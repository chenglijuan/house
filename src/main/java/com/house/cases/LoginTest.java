package com.house.cases;

import com.alibaba.fastjson.JSONObject;
import com.house.config.ConfigFile;
import com.house.config.TestConfig;
import com.house.entity.LoginCases;
import com.house.util.DatabaseUtil;
import com.house.util.HttpClientUtils;

import org.apache.http.message.BasicNameValuePair;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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

        TestConfig.tgxyBankAccountEscrowedAdd =ConfigFile.getValue("tgxyBankAccountEscrowedAdd");
    }

    @Test(groups = "loginsuccess",description = "用户登录成功接口测试",enabled = false)
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
        //是否包含字符串
        org.testng.Assert.assertEquals(result,cases.getExpected());
        System.out.println(cases);

    }

    @Test(groups = "loginFalse",description = "用户登录失败接口测试",dataProvider = "loginCaseList",enabled = false)
    public void loginFalse(LoginCases cases) throws Exception {
        //查询测试用例
        List nvps = new ArrayList();
        nvps.add(new BasicNameValuePair("interfaceVersion", cases.getInterfaceVersion()));
        nvps.add(new BasicNameValuePair("requestTime", cases.getRequestTime()));
        nvps.add(new BasicNameValuePair("loginPassword", cases.getPassword()));
        nvps.add(new BasicNameValuePair("theName", cases.getUsername()));

        //根据测试用例中配置的参数发起一个请求
        String result = HttpClientUtils.postWithParam(TestConfig.loginUrl,nvps);

        JSONObject resultObj = JSONObject.parseObject(result);

        boolean flag = resultObj.getString("info").contains(cases.getExpected());
        //添加断言
        Assert.assertTrue(flag,cases.getExpected());
    }


    @DataProvider(name = "loginCaseList")
    public Object[] loginCaseList() throws Exception{
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        //从数据库中读取所有的测试用例对接口进行测试
        List<LoginCases> cases = sqlSession.selectList("loginCaseList");
        return cases.toArray();
    }



    @DataProvider(name = "loginParam")
    public Object[] getLoginParam() throws Exception{

        LoginCases[] result = null;

        File file = new File("E:\\testing\\data\\loginFalse.xlsx");

        InputStream in = new FileInputStream(file);
        //读取excel
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
        //获取第一个sheet
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        //默认第一行为标题
        //获取总共多少行
        int count = sheet.getPhysicalNumberOfRows();
        result = new LoginCases[count-1];
        for (int i = 1; i < count; i++) {
            XSSFRow row = sheet.getRow(i);
            LoginCases cases = new LoginCases();
            for (int j = 0; j < row.getPhysicalNumberOfCells() ; j++) {
                XSSFCell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                //设置单元格类型
                cell.setCellType(CellType.STRING);
                //获取单元格数据
                String cellValue = cell.getStringCellValue();
                if(j == 0){
                    cases.setUsername(cellValue);
                }
                if(j == 1){
                    cases.setPassword(cellValue);
                }
                if(j == 2){
                    cases.setExpected(cellValue);
                }
            }
            cases.setInterfaceVersion("19000101");
            cases.setRequestTime("1");
            result[i-1]= cases;
        }
        return result;
    }

}
