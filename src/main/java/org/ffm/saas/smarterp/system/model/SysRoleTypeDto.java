package org.ffm.saas.smarterp.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel("")
public class SysRoleTypeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private String roleTypeCode;

    @ApiModelProperty("")
    private String roleTypeName;

    @ApiModelProperty("")
    private Integer status;

    @ApiModelProperty("")
    private String remark;

    @ApiModelProperty("")
    private Integer sortIndex;

    @ApiModelProperty("")
    private String saasCode;

    @ApiModelProperty("")
    private String roleTypeGroup;
}