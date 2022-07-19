package org.ffm.saas.smarterp.common.rest;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.ffm.saas.smarterp.common.exception.AppException;
import org.ffm.saas.smarterp.common.model.DataResult;
import org.ffm.saas.smarterp.common.util.JsonUtil;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

@SuppressWarnings("deprecation")
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @Autowired(required = false)
    private IErrorMsgHandler hander;
    
    private static final Map<Class<?>, Integer> EXCEPTIONS = new HashMap<>(); 
   
  
    static{
        EXCEPTIONS.put(HttpRequestMethodNotSupportedException.class, HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        EXCEPTIONS.put(HttpMediaTypeNotSupportedException.class, HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
        EXCEPTIONS.put(HttpMediaTypeNotAcceptableException.class, HttpServletResponse.SC_NOT_ACCEPTABLE);
        EXCEPTIONS.put(MissingPathVariableException.class, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        EXCEPTIONS.put(MissingServletRequestParameterException.class, HttpServletResponse.SC_BAD_REQUEST);
        EXCEPTIONS.put(ServletRequestBindingException.class, HttpServletResponse.SC_BAD_REQUEST);
        EXCEPTIONS.put(ConversionNotSupportedException.class, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        EXCEPTIONS.put(TypeMismatchException.class, HttpServletResponse.SC_BAD_REQUEST);
        EXCEPTIONS.put(HttpMessageNotReadableException.class, HttpServletResponse.SC_BAD_REQUEST);
        EXCEPTIONS.put(HttpMessageNotWritableException.class, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        EXCEPTIONS.put(MethodArgumentNotValidException.class, HttpServletResponse.SC_BAD_REQUEST);
        EXCEPTIONS.put(MissingServletRequestPartException.class, HttpServletResponse.SC_BAD_REQUEST);
        EXCEPTIONS.put(BindException.class, HttpServletResponse.SC_BAD_REQUEST);
        EXCEPTIONS.put(NoHandlerFoundException.class, HttpServletResponse.SC_NOT_FOUND);
        EXCEPTIONS.put(IllegalArgumentException.class, HttpServletResponse.SC_BAD_REQUEST);
		EXCEPTIONS.put(MethodArgumentTypeMismatchException.class, HttpServletResponse.SC_BAD_REQUEST);
    }
    
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public DataResult<Object> defaultErrorHandler(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception e) {
        Exception ex = e;
        if (!(ex instanceof AppException)) {
            log.error(String.format("url:%s,  orgs:%s, case:%s", getReqUrl(req),
                JsonUtil.object2JSON(req.getParameterMap()), ex));
        }
    
        if (hander != null) {
            ex = hander.process(ex);
            if (ex == null){
                return DataResult.fail(null);
            }
        }
        
        return getDateResult(ex);

    }
    
    

    private String getReqUrl(HttpServletRequest req) {
        String path = req.getRequestURI();
        String queryStr = req.getQueryString();
        if (queryStr != null) {
            path += "?" + req.getQueryString();
        }
        return path;
    }
    

    private DataResult<Object> getDateResult(Exception ex){
    	Integer status = GlobalExceptionHandler.EXCEPTIONS.get(ex.getClass());
     
		String message = ex.getMessage();
		if (ex instanceof MethodArgumentTypeMismatchException) {
			message = message + "  which type cannot match the filed " + ((MethodArgumentTypeMismatchException) ex).getName();
		}
		
		if (status == null) {
			status = 500;
			message = "system error!";
		}
        return DataResult.fail(status * 100, message);
    }
    

}
