package com.house.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Data: 2022/8/31  10:47
 * @Decription:
 * @Modified:
 */
@Log4j
@RestController
@Api(value = "/user",hidden = true,description = "这是用户控制器")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "/getUserCount",httpMethod = "GET")
    public int getUserCount(){
        int count  = template.selectOne("getUserCount");
        return count;
    }

}
