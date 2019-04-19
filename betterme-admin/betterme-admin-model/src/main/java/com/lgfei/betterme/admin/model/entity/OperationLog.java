package com.lgfei.betterme.admin.model.entity;

import com.lgfei.betterme.framework.model.entity.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author lgfei
 * @since 2019-04-07
 */
@ApiModel(value = "OperationLog对象", description = "操作日志表")
public class OperationLog extends BaseEntity<Long>

{
    
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "操作编码")
    private String optNo;
    
    @ApiModelProperty(value = "操作类型，1-新增，2-修改，3-删除", example = "1")
    private Integer optType;
    
    @ApiModelProperty(value = "操作的数据的id或者编码")
    private String optContent;
    
    @ApiModelProperty(value = "模块编码")
    private String moduleNo;
    
    public String getOptNo()
    {
        return optNo;
    }
    
    public void setOptNo(String optNo)
    {
        this.optNo = optNo;
    }
    
    public Integer getOptType()
    {
        return optType;
    }
    
    public void setOptType(Integer optType)
    {
        this.optType = optType;
    }
    
    public String getOptContent()
    {
        return optContent;
    }
    
    public void setOptContent(String optContent)
    {
        this.optContent = optContent;
    }
    
    public String getModuleNo()
    {
        return moduleNo;
    }
    
    public void setModuleNo(String moduleNo)
    {
        this.moduleNo = moduleNo;
    }
    
    @Override
    public String toString()
    {
        return "OperationLog{" + "optNo=" + optNo + ", optType=" + optType + ", optContent=" + optContent
            + ", moduleNo=" + moduleNo + "}";
    }
}
