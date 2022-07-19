package org.ffm.saas.smarterp.common.mybaits;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.springframework.stereotype.Component;

//@Signature(type = ParameterHandler.class, method = "setParameters", args = PreparedStatement.class)
//@Signature(type = Executor.class, method = "createCacheKey", args = {MappedStatement.class, Object.class, RowBounds.class, BoundSql.class}

@Component
@Intercepts(@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}))
@Slf4j
public class FillSysFieldPlugin implements Interceptor {
    
    private Properties properties = new Properties();
    
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        fillField(invocation);
        
        
        return invocation.proceed();
    }
    
    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    
    private void fillField(Invocation invocation) {
        try {
            Object[] args = invocation.getArgs();
            SqlCommandType sqlCommandType = null;
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                String className = arg.getClass().getName();
                log.info(i + " 参数类型：" + className);
                //第一个参数处理。根据它判断是否给“操作属性”赋值。
                if (arg instanceof MappedStatement) {
                    MappedStatement ms = (MappedStatement) arg;
                    sqlCommandType = ms.getSqlCommandType();
                    log.info("操作类型：" + sqlCommandType);
                    if (sqlCommandType == SqlCommandType.INSERT || sqlCommandType == SqlCommandType.UPDATE) {
                        continue;
                    } else {
                        break;
                    }
                }
                if (sqlCommandType == SqlCommandType.INSERT) {
                    for (Field f : arg.getClass().getDeclaredFields()
                    ) {
                        f.setAccessible(true);
                        switch (f.getName()) {
                            case "createBy":
                                setProperty(arg, "createBy", "111");
                                break;
                            case "createTime":
                                setProperty(arg, "createTime", new Date());
                                break;
                            case "updateBy":
                                setProperty(arg, "updateBy", "111");
                                break;
                            case "updateTime":
                                setProperty(arg, "updateTime", new Date());
                                break;
                            case "saasCode":
                                setProperty(arg, "saasCode", "default");
                                break;
                        }
                    }
                } else if (sqlCommandType == SqlCommandType.UPDATE) {
                    for (Field f : arg.getClass().getDeclaredFields()
                    ) {
                        f.setAccessible(true);
                        switch (f.getName()) {
                            case "updateBy":
                                setProperty(arg, "updateBy", "111");
                                break;
                            case "updateTime":
                                setProperty(arg, "updateTime", new Date());
                                break;
                        }
                    }
                }
            }
        }catch (Throwable throwable){
            log.error(throwable.getMessage());
        }
    }
    
    /**
     * 为对象的操作属性赋值
     *
     * @param bean
     */
    private void setProperty(Object bean, String name, Object value) {
        try {
            //根据需要，将相关属性赋上默认值
           BeanUtils.setProperty(bean, name, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }
    
}
