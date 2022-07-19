package org.ffm.saas.smarterp.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageResponse<T>{
    /**
     * 记录总数
     */
    private long total;
    
    /**
     * 当前页数据集合
     */
    private List<T> datas;
    
    /**
     * 请求页码
     */
    private Integer pageNum;
    
    /**
     * 请求页面大小
     */
    private Integer pageSize;
    
    @JsonIgnore
    public static <T> PageResponse<T> builder(PageInfo<T> pageInfo){
        return new PageResponse<T>(
            pageInfo.getTotal(),
            pageInfo.getList(),
            pageInfo.getPageNum(),
            pageInfo.getPageSize()
        );
    }
    
}
