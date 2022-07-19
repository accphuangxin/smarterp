package org.ffm.saas.smarterp.system.persistence.model;

import java.util.Date;
import lombok.Data;

@Data
public class SysCodePo {
    private Integer id;

    private String value;

    private String text;

    private String code;

    private String parent;

    private String remark;

    private String saasCode;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String org;
}