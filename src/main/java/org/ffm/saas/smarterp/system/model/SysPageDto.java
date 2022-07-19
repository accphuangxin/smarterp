package org.ffm.saas.smarterp.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel("")
public class SysPageDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private String code;

    @ApiModelProperty("")
    private String url;

    @ApiModelProperty("")
    private String name;

    @ApiModelProperty("")
    private String saasCode;

    @ApiModelProperty("")
    private String isCache;
}