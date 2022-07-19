package org.ffm.saas.smarterp.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel("")
public class SysOrgDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private String orgCode;

    @ApiModelProperty("")
    private String orgName;

    @ApiModelProperty("")
    private String parentCode;

    @ApiModelProperty("")
    private Integer levels;

    @ApiModelProperty("")
    private Integer aliveFlag;

    @ApiModelProperty("")
    private String saasCode;

    @ApiModelProperty("")
    private String state;
}