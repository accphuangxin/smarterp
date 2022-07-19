package org.ffm.saas.smarterp.system.persistence.model;

import java.util.Date;
import lombok.Data;

@Data
public class SysRolePo {
    private Integer id;

    private String roleCode;

    private String roleName;

    private String roleTypeCode;

    private String orgCode;

    private String saasCode;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}