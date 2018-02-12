package com.cn.my.annotation;

import java.lang.reflect.Method;
import java.util.Date;


import com.cn.my.bean.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TimeSpan {
	public static final String EDP = "execution(* com.cn.my.serviceImpl.*ServiceImpl.*(..))";
	private final static Logger logger = LoggerFactory.getLogger(TimeSpan.class);
	
	
//	@Before(EDP)
	public void before(){
		System.out.println("方法执行前的时间"+new Date());
	}

//	@After(EDP)
	public void after(){
		System.out.println("方法执行前的时间"+new Date());
	}

//	@Around(EDP)
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		Date beginDate = new Date();
		Object[] parms = joinPoint.getArgs();
		Object object = null;
		User user = new User();
		user.setId(1);
		user.setUsername("张三");
		String ip = "127.0.0.1";

		try {
			object = joinPoint.proceed(parms);
			String targetName = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			Object[] arguments = joinPoint.getArgs();
			Class targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();
			String operationType = "";
			String operationName = "";
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					Class[] clazzs = method.getParameterTypes();
					if (clazzs.length == arguments.length) {
						Log log = method.getAnnotation(Log.class);
						if (null!=log) {
							operationType = log.operationName();
							operationName = method.getAnnotation(Log.class).operationName();
							method.getAnnotation(Log.class).operationName();
							break;
						}
						else{
							return null;
						}

					}
				}
			}
			System.out.println("=====controller后置通知开始=====");
			System.out.println("请求方法:"
					+ (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")
					+ "." + operationType);
			System.out.println("方法描述:" + operationName);
			System.out.println("请求人:" + user.getUsername());
			System.out.println("请求IP:" + ip);
			System.out.println("=====controller后置通知结束=====");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("==后置通知异常==");
			logger.error("异常信息12:{}", e.getMessage());
		}
		Date endDate = new Date();
		String className = Class.forName(joinPoint.getTarget().getClass().getName()).toString();
		className = className.contains("$$") ? (className.split("$$"))[0] : className;
		double timeSpan = (endDate.getTime() - beginDate.getTime()) / 1.00;
		logger.info(className + "类" + joinPoint.getSignature().getName() + "方法的执行时间为" + timeSpan + "ms");
		return object;
	}
}
