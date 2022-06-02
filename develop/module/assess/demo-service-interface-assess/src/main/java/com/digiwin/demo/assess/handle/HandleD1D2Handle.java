package com.digiwin.demo.assess.handle;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.digiwin.app.container.exceptions.DWRuntimeException;
import com.digiwin.demo.assess.dto.PlanTableDescriptionDto;
import com.digiwin.demo.assess.dto.TeamMemberDto;
import com.digiwin.demo.assess.enums.NodeFlowStepEnum;
import com.digiwin.demo.assess.mapper.QuestionMapper;
import com.digiwin.demo.assess.pojo.Question;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * D1&D2处理器
 *
 * @author sheen.dong
 * @since 2022/5/31 11:51
 */
@Component
public class HandleD1D2Handle implements INodeFlowStepHandle {

    private final QuestionMapper questionMapper;

    public HandleD1D2Handle(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public boolean isRun(NodeFlowStepEnum currentStep) {
        return currentStep == NodeFlowStepEnum.HANDLE_D1_D2;
    }

    @Override
    public boolean confirm(Question question) {
        // 验证数据
        validateData(question);
        // 问题更新数据
        Question updateQuestion = new Question();
        updateQuestion.setPlanTable(JSON.toJSONString(question.getPlanTableDescriptionDtoList()));
        updateQuestion.setNode(NodeFlowStepEnum.getNextNode(question.getNode()));
        // 更新构造器
        UpdateWrapper<Question> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", question.getId());
        // 更新数据
        return questionMapper.update(updateQuestion, updateWrapper) == 1;
    }

    @Override
    public boolean backRoll(Question question) {
        UpdateWrapper<Question> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .set("identifyInfo", null)
                .set("node", NodeFlowStepEnum.getPredNode(question.getNode()))
                .eq("id", question.getId());
        return questionMapper.update(null, updateWrapper) == 1;
    }

    @Override
    public boolean close(Question question) {
        UpdateWrapper<Question> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", question.getId());

        Question updateQuestion = new Question();
        question.setNode(NodeFlowStepEnum.CLOSE);

        return questionMapper.update(updateQuestion, updateWrapper) == 1;
    }

    private void validateData(Question question) {
        long count = question.getPlanTableDescriptionDtoList().stream().filter(data -> StringUtils.isBlank(data.getHandler())).count();
        if (count > 0) {
            throw new DWRuntimeException("步骤的处理人不能为空");
        }

        // 处理人
        List<String> collect = question.getPlanTableDescriptionDtoList().stream().map(PlanTableDescriptionDto::getHandler).collect(Collectors.toList());
        // 团队成员
        List<String> teamList = question.getTeamMemberDtoList().stream().map(TeamMemberDto::getName).collect(Collectors.toList());

        for (String name : collect) {
            if (!teamList.contains(name)) {
                throw new DWRuntimeException("步骤的处理人在团队不存在");
            }
        }
        
        count = question.getPlanTableDescriptionDtoList().stream().filter(data -> data.getEstimatedFinishTime() == null).count();
        if (count > 0) {
            throw new DWRuntimeException("预计完成时间没传值");
        }
    }
}