package com.digiwin.demo.assess.dto;

import lombok.Data;

/**
 * Team 成员信息
 * @author sheen.dong
 * @since 2022/5/31 16:13
 */
@Data
public class TeamMemberDto {

    private String name;

    private String department;

    private String position;

    private String teamRole;
}