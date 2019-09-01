package com.lgfei.betterme.admin.common.entity;

import com.lgfei.betterme.framework.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author lgfei
 * @since 2019-09-01
 */
@ApiModel(value="LogOperate对象", description="操作日志表")
public class LogOperate extends BaseEntity<Long>
{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "操作编码")
    private String operateNo;

    @ApiModelProperty(value = "操作类型，1-新增，2-修改，3-删除", example = "1")
    private Integer operateType;

    @ApiModelProperty(value = "操作的数据的id或者编码")
    private String operateContent;

    @ApiModelProperty(value = "模块编码")
    private String moduleNo;

    public String getOperateNo() {
        return operateNo;
    }

    public void setOperateNo(String operateNo) {
        this.operateNo = operateNo;
    }
    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }
    public String getOperateContent() {
        return operateContent;
    }

    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent;
    }
    public String getModuleNo() {
        return moduleNo;
    }

    public void setModuleNo(String moduleNo) {
        this.moduleNo = moduleNo;
    }

    @Override
    public String toString() {
        return "LogOperate{" +
        "operateNo=" + operateNo +
        ", operateType=" + operateType +
        ", operateContent=" + operateContent +
        ", moduleNo=" + moduleNo +
        "}";
    }
}
