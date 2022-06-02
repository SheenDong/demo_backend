package com.digiwin.demo.assess.enums;

import com.digiwin.app.container.exceptions.DWRuntimeException;
import com.digiwin.demo.assess.exception.BusinessException;

/**
 * 流程节点枚举定义
 *
 * @author sheen.dong
 * @since 2022/5/31 11:09
 */
public enum NodeFlowStepEnum {

    CREATE_STEP(1, "问题创建"),
    IDENTIFY_STEP(2, "问题识别"),
    HANDLE_D1_D2(3, "8D_D1&D2处理"),
    HANDLE_D3(4, "8D_D3"),
    CLOSE(5, "结束");

    private int no;
    private String desc;

    NodeFlowStepEnum(int no, String desc) {
        this.no = no;
        this.desc = desc;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static NodeFlowStepEnum getNodeByNo(Integer no) {
        for (NodeFlowStepEnum value : NodeFlowStepEnum.values()) {
            if (value.no == no) {
                return value;
            }
        }

        throw new DWRuntimeException("无效的节点编号");
    }

    public static NodeFlowStepEnum getPredNode(NodeFlowStepEnum currentNode) {
        int predNo = currentNode.no - 1;
        if (predNo < 1) {
            predNo = 1;
        }
        return getNodeByNo(predNo);
    }

    public static NodeFlowStepEnum getNextNode(NodeFlowStepEnum currentNode) {
        int nextNo = currentNode.no + 1;
        if (nextNo > 5) {
            throw new DWRuntimeException("流程已经结束");
        }
        return getNodeByNo(nextNo);
    }
}