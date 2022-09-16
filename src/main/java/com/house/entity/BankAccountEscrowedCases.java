package com.house.entity;

import lombok.Data;

/**
 * @Author: clj
 * @Data: 2022/9/16  11:30
 * @Decription:
 * @Modified:
 */
@Data
public class BankAccountEscrowedCases {

    private Integer id;
    //接口默认参数
    private String interfaceVersion;
    //开户行名称
    private String shortNameOfBank;
    //开户行id
    private String bankBranchId;
    //200101 业务类型
    private String busiType;
    //托管账户名称
    private String theName;
    //托管账号
    private String theAccount;
    //备注
    private String remark;
    //是否启用
    private String isUsing;
    //期望值
    private String expected;

}
