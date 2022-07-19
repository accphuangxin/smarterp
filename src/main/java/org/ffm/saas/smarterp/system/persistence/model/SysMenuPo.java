package org.ffm.saas.smarterp.system.persistence.model;

import java.util.Date;
import lombok.Data;

@Data
public class SysMenuPo {
    private Integer id;

    private String code;

    private String parentCode;

    private String pageCode;

    private String remark;

    private String status;

    private Integer sortIndex;

    private String name;

    private String state;

    private String saasCode;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}