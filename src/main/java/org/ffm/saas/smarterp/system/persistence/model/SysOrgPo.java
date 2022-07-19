package org.ffm.saas.smarterp.system.persistence.model;

import java.util.Date;
import lombok.Data;

@Data
public class SysOrgPo {
    private Integer id;

    private String orgCode;

    private String orgName;

    private String parentCode;

    private Integer levels;

    private Integer aliveFlag;

    private String saasCode;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String state;
}