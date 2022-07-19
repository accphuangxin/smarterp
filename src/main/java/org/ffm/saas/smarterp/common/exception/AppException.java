package org.ffm.saas.smarterp.common.exception;

import java.util.Arrays;

/**
 * @author xinhuang
 */
public class AppException extends RuntimeException implements IException {

    private static final long serialVersionUID = 8688953989589840707L;

    private transient Object[] methodArgs;
    private int errorCode = 40000;

    public AppException(int errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }
    public AppException(String msg) {
        super(msg);
        this.errorCode = errorCode;
    }
    
    public AppException(int errorCode, String msg, Object[] methodArgs) {
        super(msg);
        setMethodArgs(methodArgs);
        this.errorCode = errorCode;
    }
    
    
    @Override
    public int getCode() {
        return this.errorCode;
    }
    
    @Override
    public Throwable getThrowable() {
        return null;
    }
    
    @Override
    public String getMsg(){
        return super.getMessage();
    }
    @Override
    public Object[] getMethodArgs() {
        return this.methodArgs;
    }
    
  
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
    
    
    private void setMethodArgs(Object[] methodArgs) {
        this.methodArgs = methodArgs == null ? new Object[0] : Arrays.copyOf(methodArgs, methodArgs.length);
    }


}
