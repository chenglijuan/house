package com.house;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;

//程序入口修改
@EnableScheduling
//spring配置文件
@SpringBootApplication
public class HouseApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        HouseApplication.context =  SpringApplication.run(HouseApplication.class, args);
    }

    @PreDestroy
    public void close(){
        HouseApplication.context.close();
    }


}
