package com.digiwin.demo.assess.handle;


import com.digiwin.demo.assess.enums.NodeFlowStepEnum;
import com.digiwin.demo.assess.pojo.Question;

public interface INodeFlowStepHandle {

    boolean isRun(NodeFlowStepEnum currentStep);

    // 问题确认
    boolean confirm(Question question);

    // 问题退回
    boolean backRoll(Question question);

    // 问题关闭
    boolean close(Question question);
}