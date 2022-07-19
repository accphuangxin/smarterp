package org.ffm.saas.smarterp.common.model;

import lombok.Data;

@Data
public class PageRequest<T>{
    private T paramData;
    private Integer pageNum = 0;
    private Integer pageSize = 10;
}
