package com.digiwin.demo.assess.dto;

import lombok.Data;

import java.util.Date;

/**
 * 计划描述实体
 * @author sheen.dong
 * @since 2022/5/31 16:09
 */
@Data
public class PlanTableDescriptionDto {

    private String no;

    private String step;

    private String handler;

    private Date estimatedFinishTime;

    private String needAttachment;

    private String attachmentList;

    private String place;
}