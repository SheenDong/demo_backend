package com.digiwin.demo.assess.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.digiwin.app.container.exceptions.DWRuntimeException;
import com.digiwin.app.dao.DWServiceResultBuilder;
import com.digiwin.app.service.DWServiceResult;
import com.digiwin.demo.assess.dto.IdentifyInfoDto;
import com.digiwin.demo.assess.dto.PlanTableDescriptionDto;
import com.digiwin.demo.assess.dto.TeamMemberDto;
import com.digiwin.demo.assess.enums.NodeFlowStepEnum;
import com.digiwin.demo.assess.enums.StepEstimatedTimeEnum;
import com.digiwin.demo.assess.handle.INodeFlowStepHandle;
import com.digiwin.demo.assess.mapper.QuestionMapper;
import com.digiwin.demo.assess.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * @author sheen.dong
 * @since 2022/5/30 15:26
 */
@Service
public class QuestionService implements IQuestionService  {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private List<INodeFlowStepHandle> nodeFlowStepHandles;

    @Override
    public DWServiceResult get(String id) {
        Question question = questionMapper.selectById(id);
        question.setPlanTableDescriptionDtoList(JSONArray.parseArray(question.getPlanTable(), PlanTableDescriptionDto.class));
        question.setTeamMemberDtoList(JSONArray.parseArray(question.getTeamMember(), TeamMemberDto.class));
        question.setIdentifyInfoDto(JSON.parseObject(question.getIdentifyInfo(), IdentifyInfoDto.class));


        if (question.getNode() == NodeFlowStepEnum.IDENTIFY_STEP) {
            question.setTeamMemberDtoList(null);
            question.setPlanTableDescriptionDtoList(null);
        } else if (question.getNode() == NodeFlowStepEnum.HANDLE_D1_D2) {
            LocalDateTime now = LocalDateTime.now();
            List<PlanTableDescriptionDto> planTableDescriptionDtoList = question.getPlanTableDescriptionDtoList();
            for (PlanTableDescriptionDto dto : planTableDescriptionDtoList) {
                now = now.plusHours(StepEstimatedTimeEnum.getEnumByStepName(dto.getStep()).getHours());
                dto.setEstimatedFinishTime(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()));
            }
        }else if (question.getNode() == NodeFlowStepEnum.HANDLE_D3) {
            question.setTeamMemberDtoList(null);
        }


        question.setPlanTable(null);
        question.setTeamMember(null);
        question.setIdentifyInfo(null);
        return DWServiceResultBuilder.build(true, "SUCCESS", question);
    }

    @Override
    public DWServiceResult post(Question question) {
        
        // 校验问题单数据
        Question oldQuestion = questionMapper.selectById(question.getId());
        if (oldQuestion == null) {
            return DWServiceResultBuilder.build(false, "无效的问题", null);
        }else if (oldQuestion.getNode() == NodeFlowStepEnum.CLOSE) {
            return DWServiceResultBuilder.build(false, "问题已经关闭", null);
        }else if (oldQuestion.getNode() != question.getNode()) {
            question.setNode(oldQuestion.getNode());
        }

        // 根据问题操作的类型转发到不同的 处理器
        boolean result = false;
        switch (question.getOperation()) {
            case "confirm":
                result = getHandle(question).confirm(question);
                break;
            case "rollback":
                result = getHandle(question).backRoll(question);
                break;
            case "close":
                result = getHandle(question).close(question);
                break;
            default:
                throw new DWRuntimeException("无效的操作");
        }

        // 返回操作结果
        return DWServiceResultBuilder.build(result, result ? "操作成功" : "操作失败", null);
    }

    private INodeFlowStepHandle getHandle(Question question) {
        return getHandle(question.getNode());
    }

    private INodeFlowStepHandle getHandle(NodeFlowStepEnum stepEnum) {
        for (INodeFlowStepHandle iNodeFlowStepHandle : this.nodeFlowStepHandles) {
            if (iNodeFlowStepHandle.isRun(stepEnum)) {
                return iNodeFlowStepHandle;
            }
        }
        throw new DWRuntimeException("错误的流程节点");
    }
}