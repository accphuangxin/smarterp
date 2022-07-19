package org.ffm.saas.smarterp.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel("")
public class SysRoleDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private String roleCode;

    @ApiModelProperty("")
    private String roleName;

    @ApiModelProperty("")
    private String roleTypeCode;

    @ApiModelProperty("")
    private String orgCode;

    @ApiModelProperty("")
    private String saasCode;
}