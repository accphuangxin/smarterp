package org.ffm.saas.smarterp.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel("")
public class SysAuthButtonDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private String buttonId;

    @ApiModelProperty("")
    private String buttonCode;

    @ApiModelProperty("")
    private String roleId;

    @ApiModelProperty("")
    private String roleCode;

    @ApiModelProperty("")
    private String remark;

    @ApiModelProperty("")
    private String buttonName;
}