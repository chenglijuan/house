package com.house.entity;

import lombok.Data;

/**
 * @Author: chenglijuan
 * @Data: 2022/9/1  16:22
 * @Decription:
 * @Modified:
 */
@Data
public class EscrowAgreementListCases {

    private Integer pageNumber;

    private Integer countPerPage;

    private String keyword;

    private String startDate;

    private String endDate;

    private String approvalState;

    private Integer cityRegionId;



}
