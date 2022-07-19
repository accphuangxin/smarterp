package org.ffm.saas.smarterp.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel("")
public class SysMenuDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private String code;

    @ApiModelProperty("")
    private String parentCode;

    @ApiModelProperty("")
    private String pageCode;

    @ApiModelProperty("")
    private String remark;

    @ApiModelProperty("")
    private String status;

    @ApiModelProperty("")
    private Integer sortIndex;

    @ApiModelProperty("")
    private String name;

    @ApiModelProperty("")
    private String state;

    @ApiModelProperty("")
    private String saasCode;
}