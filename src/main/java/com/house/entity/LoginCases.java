package com.house.entity;

import lombok.Data;

/**
 * @Data: 2022/8/31  15:42
 * @Decription:
 * @Modified:
 */
@Data
public class LoginCases {

    private int id;

    private String username;

    private String password;

    private String expected;

    private String interfaceVersion;

    private String requestTime;

}
