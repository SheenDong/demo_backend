package com.digiwin.demo.assess.dto;

import lombok.Data;

/**
 * 问题识别信息实体
 * @author sheen.dong
 * @since 2022/5/31 18:08
 */
@Data
public class IdentifyInfoDto {

    private Boolean isRepeat;

    private Integer repeatNum;

    private String riskLevel;

    // 紧急度
    private String urgent;

    private String solution;

    private String principal;

    // 是否上版
    private Boolean isWhetherVersion;
}
