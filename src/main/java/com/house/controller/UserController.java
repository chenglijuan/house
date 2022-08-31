package com.house.controller;

import com.house.entity.User;
import com.mysql.cj.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Objects;

/**
 * @Data: 2022/8/31  10:47
 * @Decription:
 * @Modified:
 */
//swagger 配置
//@EnableSwagger2
@RestController
@Api(value = "/user",hidden = true,description = "用户控制器")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "/getUserCount",httpMethod = "GET")
    public int getUserCount(){
        int count  = template.selectOne("getUserCount");
        return count;
    }


    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "/addUser",httpMethod = "POST")
    public String addUser(@RequestBody User user){

        if(Objects.isNull(user)){
            return "参数不能为空";
        }
        if(StringUtils.isNullOrEmpty(user.getUserName())){
            return "用户名不能为空";
        }

        int count  = template.insert("addUser",user);
        return count+"";
    }

    /**
     * 删除用户
     * @return
     */

    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    @ApiOperation(value = "/deleteUser",httpMethod = "POST")
    public String deleteUser(@PathParam("userId") Integer userId){

        if(Objects.isNull(userId)){
            return "参数不能为空";
        }
        int count  = template.delete("deleteUser",userId);
        return count+"";
    }



}
