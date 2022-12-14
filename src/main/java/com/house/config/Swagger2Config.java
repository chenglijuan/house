package com.house.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Data: 2022/8/31  14:01
 * @Decription:
 * @Modified:
 */

//swagger 配置
@EnableSwagger2
@Configuration
public class Swagger2Config {

    @Bean
    public Docket createApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.house.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //构建api文档的详细信息函数
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //文档页面标题
                .title("托管系统接口文档")
                //文档创建人
                .contact(new Contact("张三","",""))
                //版本号
                .version("1.0")
                //描述
                .description("系统API描述")
                .build();
    }


}
