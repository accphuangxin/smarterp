package org.ffm.saas.smarterp.system.persistence.model;

import java.util.Date;
import lombok.Data;

@Data
public class SysUserPo {
    private Integer id;

    private String loginId;

    private String name;

    private String password;

    private String aliveFlag;

    private String mobilePhone;

    private String orgCode;

    private String inJoinTime;

    private Integer loginCount;

    private String eMail;

    private String saasCode;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}