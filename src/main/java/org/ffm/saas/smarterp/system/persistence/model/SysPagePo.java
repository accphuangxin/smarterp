package org.ffm.saas.smarterp.system.persistence.model;

import java.util.Date;
import lombok.Data;

@Data
public class SysPagePo {
    private Integer id;

    private String code;

    private String url;

    private String name;

    private String saasCode;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String isCache;
}