package org.ffm.saas.smarterp.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel("")
public class SysAuthSourceDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private String resourceId;

    @ApiModelProperty("")
    private String resourceCode;

    @ApiModelProperty("")
    private String roleId;

    @ApiModelProperty("")
    private String roleCode;

    @ApiModelProperty("")
    private String saasCode;

    @ApiModelProperty("")
    private String remark;

    @ApiModelProperty("")
    private Date modifyTime;

    @ApiModelProperty("")
    private String modifyUser;
}