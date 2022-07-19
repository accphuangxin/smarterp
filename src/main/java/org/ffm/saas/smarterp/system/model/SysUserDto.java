package org.ffm.saas.smarterp.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel("")
public class SysUserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private String loginId;

    @ApiModelProperty("")
    private String name;

    @ApiModelProperty("")
    private String password;

    @ApiModelProperty("")
    private String aliveFlag;

    @ApiModelProperty("")
    private String mobilePhone;

    @ApiModelProperty("")
    private String orgCode;

    @ApiModelProperty("")
    private String inJoinTime;

    @ApiModelProperty("")
    private Integer loginCount;

    @ApiModelProperty("")
    private String eMail;

    @ApiModelProperty("")
    private String saasCode;
}