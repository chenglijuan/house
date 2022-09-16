package com.house.util;

import com.house.entity.LoginCases;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: clj
 * @Data: 2022/9/14  17:20
 * @Decription:
 * @Modified:
 */
public class DataUtil {

    @DataProvider(name = "loginParam")
    public static Object[] getLoginParam() throws Exception{

        Object[] result = null;

        File file = new File("E:\\testing\\data\\login.xlsx");

        InputStream in = new FileInputStream(file);
        //读取excel
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
        //获取第一个sheet
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        //默认第一行为标题
//        XSSFRow title  = sheet.getRow(0);

        //获取总共多少行
        int count = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < count; i++) {
            result = new Object[count];
            XSSFRow row = sheet.getRow(i);
            StringBuffer sb = new StringBuffer();
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
                result[i]= cases;
            }
            System.out.println(sb);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {




    }


}
