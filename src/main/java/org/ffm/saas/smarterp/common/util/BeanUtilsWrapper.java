package org.ffm.saas.smarterp.common.util;

import org.springframework.beans.BeanUtils;

public class BeanUtilsWrapper extends BeanUtils {
    private BeanUtilsWrapper(){}
    
    public static <T> T copy(Object source, T target){
        BeanUtils.copyProperties(source, target);
        return target;
    }
    
    
}
