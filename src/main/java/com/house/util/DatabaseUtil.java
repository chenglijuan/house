package com.house.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @Author: clj
 * @Data: 2022/9/1  15:17
 * @Decription:
 * @Modified:
 */
public class DatabaseUtil {

    public static SqlSession getSqlSession() throws Exception {
        //获取配置的资源文件
        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");
        //使用类加载器加载配置文件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //返回sqlssion  可以执行配置文件中的语句
        SqlSession sqlSession = factory.openSession();
        return sqlSession;
    }

}

