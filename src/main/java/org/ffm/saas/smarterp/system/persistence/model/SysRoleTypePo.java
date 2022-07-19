package org.ffm.saas.smarterp.system.persistence.model;

import java.util.Date;
import lombok.Data;

@Data
public class SysRoleTypePo {
    private Integer id;

    private String roleTypeCode;

    private String roleTypeName;

    private Integer status;

    private String remark;

    private Integer sortIndex;

    private String saasCode;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String roleTypeGroup;
}