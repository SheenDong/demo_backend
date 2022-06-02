package com.digiwin.demo.assess.enums;

import com.digiwin.app.container.exceptions.DWRuntimeException;
import org.apache.commons.lang3.StringUtils;

public enum StepEstimatedTimeEnum {

    D3("D3-围堵措施", 5),
    D4("D4-根本原因分析", 5),
    D5("D5-纠正措施", 5),
    D6("D6-纠正措施验证", 5),
    D7("D7-预防措施", 5),
    D8("D8-处理确认", 5);

    private String stepName;
    private Integer hours;

    StepEstimatedTimeEnum(String stepName, Integer hours) {
        this.stepName = stepName;
        this.hours = hours;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public static StepEstimatedTimeEnum getEnumByStepName(String name) {
        for (StepEstimatedTimeEnum enumValue : StepEstimatedTimeEnum.values()) {
            if (StringUtils.equalsAnyIgnoreCase(enumValue.stepName, name)) {
                return enumValue;
            }
        }
        throw new DWRuntimeException("错误的步骤");
    }
}
