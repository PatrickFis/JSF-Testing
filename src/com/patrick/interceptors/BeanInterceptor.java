package com.patrick.interceptors;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class BeanInterceptor {
	private static final Logger log = Logger.getLogger("beanInterceptor");
	
	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		Object result = context.proceed();
		log.log(Level.INFO, "{0} called", context.getMethod().getName());
		return result;
	}
	
}
