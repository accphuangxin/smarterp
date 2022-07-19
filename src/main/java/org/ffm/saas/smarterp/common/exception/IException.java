package org.ffm.saas.smarterp.common.exception;

import java.util.Arrays;

public interface IException {
    public Object[] getMethodArgs();
    
    public String getMsg();
    
    public int getCode();
    
    public Throwable getThrowable();
}
