package com.digiwin.demo.assess.handle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.digiwin.app.container.exceptions.DWRuntimeException;
import com.digiwin.demo.assess.dto.AttachmentDto;
import com.digiwin.demo.assess.dto.PlanTableDescriptionDto;
import com.digiwin.demo.assess.enums.NodeFlowStepEnum;
import com.digiwin.demo.assess.enums.StepEstimatedTimeEnum;
import com.digiwin.demo.assess.mapper.QuestionMapper;
import com.digiwin.demo.assess.pojo.Question;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sheen.dong
 * @since 2022/5/31 12:42
 */
@Component
public class HandleD3Handle implements INodeFlowStepHandle{

    private final QuestionMapper questionMapper;

    public HandleD3Handle(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public boolean isRun(NodeFlowStepEnum currentStep) {
        return currentStep == NodeFlowStepEnum.HANDLE_D3;
    }

    @Override
    public boolean confirm(Question question) {
        validateData(question);
        Question updateQuestion = new Question();
        updateQuestion.setPlanTable(JSON.toJSONString(question.getPlanTableDescriptionDtoList()));
        updateQuestion.setNode(NodeFlowStepEnum.getNextNode(question.getNode()));

        UpdateWrapper<Question> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", question.getId());

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
        long count = question.getPlanTableDescriptionDtoList().stream().filter(data -> StringUtils.isBlank(data.getPlace())).count();
        if (count > 0) {
            throw new DWRuntimeException("围堵场所不能位空");
        }

        Map<String, PlanTableDescriptionDto> collect = question.getPlanTableDescriptionDtoList().stream().collect(Collectors.toMap(PlanTableDescriptionDto::getStep, o -> o));
        PlanTableDescriptionDto dto = collect.get(StepEstimatedTimeEnum.D3.getStepName());
        if (StringUtils.equalsIgnoreCase(dto.getNeedAttachment(), "Y")) {
            if (StringUtils.isBlank(dto.getAttachmentList())) {
                throw new DWRuntimeException("附件必传");
            }
            List<AttachmentDto> attachmentDtoList = JSONArray.parseArray(dto.getAttachmentList(), AttachmentDto.class);
            if (CollectionUtils.isEmpty(attachmentDtoList)) {
                throw new DWRuntimeException("附件必传");
            }
        }
    }
}