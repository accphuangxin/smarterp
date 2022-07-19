package org.ffm.saas.smarterp.common.rest;

import org.ffm.saas.smarterp.common.exception.SysException;

/**
 * Created by huangxin on 2016/9/7.
 */
public interface IErrorMsgHandler {
    public Exception process(Exception ex);
}
