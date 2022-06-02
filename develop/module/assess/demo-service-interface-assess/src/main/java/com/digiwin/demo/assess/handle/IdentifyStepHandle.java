package com.digiwin.demo.assess.handle;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.digiwin.app.container.exceptions.DWRuntimeException;
import com.digiwin.demo.assess.dto.IdentifyInfoDto;
import com.digiwin.demo.assess.enums.NodeFlowStepEnum;
import com.digiwin.demo.assess.exception.BusinessException;
import com.digiwin.demo.assess.mapper.QuestionMapper;
import com.digiwin.demo.assess.pojo.Question;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 问题识别处理步骤
 *
 * @author sheen.dong
 * @since 2022/5/31 11:49
 */
@Component
public class IdentifyStepHandle implements INodeFlowStepHandle{

    private static final Logger LOGGER = LoggerFactory.getLogger(IdentifyStepHandle.class);

    private final QuestionMapper questionMapper;

    public IdentifyStepHandle(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public boolean isRun(NodeFlowStepEnum currentStep) {
        return currentStep == NodeFlowStepEnum.IDENTIFY_STEP;
    }

    @Override
    public boolean confirm(Question question) {

        // 验证参数
        IdentifyInfoDto newIdentifyInfoDto = question.getIdentifyInfoDto();
        validateData(newIdentifyInfoDto);

        // 更新问题的识别信息
        Question updateQuestion = new Question();
        IdentifyInfoDto identifyInfoDto = new IdentifyInfoDto();
        identifyInfoDto.setIsRepeat(newIdentifyInfoDto.getIsRepeat());
        identifyInfoDto.setRepeatNum(newIdentifyInfoDto.getRepeatNum());
        identifyInfoDto.setRiskLevel(newIdentifyInfoDto.getRiskLevel());
        identifyInfoDto.setUrgent(newIdentifyInfoDto.getUrgent());
        identifyInfoDto.setPrincipal(newIdentifyInfoDto.getPrincipal());
        identifyInfoDto.setIsWhetherVersion(newIdentifyInfoDto.getIsWhetherVersion());
        updateQuestion.setIdentifyInfo(JSON.toJSONString(identifyInfoDto));
        // 流转到下个节点
        updateQuestion.setNode(NodeFlowStepEnum.getNextNode(question.getNode()));

        UpdateWrapper<Question> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", question.getId());

        // 返回更新的结果
        return questionMapper.update(updateQuestion, updateWrapper) == 1;
    }

    @Override
    public boolean backRoll(Question question) {
        throw new DWRuntimeException("这已经是第一个节点了，无需退回");
    }

    @Override
    public boolean close(Question question) {
        UpdateWrapper<Question> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", question.getId());

        Question updateQuestion = new Question();
        question.setNode(NodeFlowStepEnum.CLOSE);

        return questionMapper.update(updateQuestion, updateWrapper) == 1;
    }

    private void validateData(IdentifyInfoDto question) throws BusinessException {
        if (StringUtils.isBlank(question.getRiskLevel())) {
            throw new DWRuntimeException("风险等级必填");
        }
        if (StringUtils.isBlank(question.getUrgent())) {
            throw new DWRuntimeException("紧急度必填");
        }
        if (StringUtils.isBlank(question.getPrincipal())) {
            throw new DWRuntimeException("负责人必填");
        }
        if (question.getIsWhetherVersion() == null) {
            throw new DWRuntimeException("是否上版必填");
        }
    }
}
