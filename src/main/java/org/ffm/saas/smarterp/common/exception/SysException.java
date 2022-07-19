package org.ffm.saas.smarterp.common.exception;

import java.util.Arrays;

public class SysException extends RuntimeException implements IException {

    private static final long serialVersionUID = 3116483353040779859L;

    private transient Object[] methodArgs;
    private int errorCode = 50000;

    public SysException(int errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public SysException(int errorCode, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;
    }

    public SysException(int errorCode, String msg, Object[] methodArgs) {
        super(msg);
        this.errorCode = errorCode;
        setMethodArgs(methodArgs);
    }
    

    public SysException(int errorCode, String msg, Object[] methodArgs, Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;
        setMethodArgs(methodArgs);
    }
    
    public SysException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public Object[] getMethodArgs() {
        return this.methodArgs;
    }
    
    @Override
    public String getMsg() {
        return super.getMessage();
    }
    
    @Override
    public int getCode() {
        return errorCode;
    }
    
    @Override
    public Throwable getThrowable() {
        return super.getCause();
    }
    
    private void setMethodArgs(Object[] methodArgs) {
        this.methodArgs = methodArgs == null ? new Object[0] : Arrays.copyOf(methodArgs, methodArgs.length);
    }
}
