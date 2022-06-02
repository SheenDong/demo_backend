package com.digiwin.demo.assess.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.digiwin.demo.assess.dto.IdentifyInfoDto;
import com.digiwin.demo.assess.dto.PlanTableDescriptionDto;
import com.digiwin.demo.assess.dto.TeamMemberDto;
import com.digiwin.demo.assess.enums.NodeFlowStepEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author sheen.dong
 * @since 2022/5/30 17:04
 */
@Data
@TableName(value = "question")
public class Question implements Serializable {

    @TableId
    private String id;

    private String type;

    private String origin;

    @TableField(value = "occurTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date occurTime;

    @TableField(value = "expectCloseTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expectCloseTime;

    @TableField(value = "defectName")
    private String defectName;

    @TableField(value = "defectLevel")
    private String defectLevel;

    private String description;

    @TableField(value = "imgUrl")
    private String imgUrl;

    // 问题识别信息
    @TableField(value = "identifyInfo")
    private String identifyInfo;

    // 团队成员信息
    @TableField(value = "teamMember")
    private String teamMember;

    // 计划表信息
    @TableField(value = "planTable")
    private String planTable;

    // 当前问题单流转的节点
    private NodeFlowStepEnum node;

    @TableField(exist = false)
    private IdentifyInfoDto identifyInfoDto;

    @TableField(exist = false)
    private List<PlanTableDescriptionDto> planTableDescriptionDtoList;

    @TableField(exist = false)
    private List<TeamMemberDto> teamMemberDtoList;

    @TableField(exist = false)
    private String operation;
}