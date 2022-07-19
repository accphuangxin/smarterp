package org.ffm.saas.smarterp.system.persistence.model;

import java.util.Date;
import lombok.Data;

@Data
public class SysAuthSourcePo {
    private Integer id;

    private String resourceId;

    private String resourceCode;

    private String roleId;

    private String roleCode;

    private String saasCode;

    private String remark;

    private Date modifyTime;

    private String modifyUser;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}