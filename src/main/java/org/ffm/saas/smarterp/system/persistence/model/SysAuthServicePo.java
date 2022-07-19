package org.ffm.saas.smarterp.system.persistence.model;

import java.util.Date;
import lombok.Data;

@Data
public class SysAuthServicePo {
    private Integer id;

    private String serviceId;

    private String methodCode;

    private String serviceCode;

    private String roleId;

    private String roleCode;

    private String saasCode;

    private String remark;

    private Date createTime;

    private String createUser;

    private Date modifyTime;

    private String modifyUser;
}