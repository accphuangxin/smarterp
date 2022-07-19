package org.ffm.saas.smarterp.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel("")
public class SysCodeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private String value;

    @ApiModelProperty("")
    private String text;

    @ApiModelProperty("")
    private String code;

    @ApiModelProperty("")
    private String parent;

    @ApiModelProperty("")
    private String remark;

    @ApiModelProperty("")
    private String saasCode;

    @ApiModelProperty("")
    private String org;
}