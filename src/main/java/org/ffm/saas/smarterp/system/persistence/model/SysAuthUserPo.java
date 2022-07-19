package org.ffm.saas.smarterp.system.persistence.model;

import java.util.Date;
import lombok.Data;

@Data
public class SysAuthUserPo {
    private Integer id;

    private String userId;

    private String roleId;

    private String userCode;

    private String roleCode;

    private String saasCode;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}