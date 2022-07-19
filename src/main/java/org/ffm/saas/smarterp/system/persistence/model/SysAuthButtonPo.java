package org.ffm.saas.smarterp.system.persistence.model;

import java.util.Date;
import lombok.Data;

@Data
public class SysAuthButtonPo {
    private Integer id;

    private String buttonId;

    private String buttonCode;

    private String roleId;

    private String roleCode;

    private String remark;

    private String buttonName;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}