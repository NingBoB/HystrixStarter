package com.dmm.middleware.hystrix;

import com.dmm.middleware.hystrix.annotation.DoHystrix;
import com.dmm.middleware.hystrix.value.IValueService;
import com.dmm.middleware.hystrix.value.impl.HystrixValueImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Mean
 * @date 2025/2/14 17:08
 * @description DoHystrixPoint  切面
 */
@Aspect
// @Component
public class DoHystrixPoint {

	@Pointcut("@annotation(com.dmm.middleware.hystrix.annotation.DoHystrix)")
	public void aopPoint() {}

	@Around("aopPoint() && @annotation(doHystrix)")     // 直接通过方法入参的方式可以更加方便拿到注解，处理起来也更优雅。？？？
	public Object doRouter(ProceedingJoinPoint jp, DoHystrix doHystrix) throws Throwable {
		// 获取注解中的参数
		// Method method = getMethod(jp);
		// DoHystrix doHystrixAnnotation = method.getAnnotation(DoHystrix.class);
		// int timeoutValue = doHystrixAnnotation.timeoutValue();
		IValueService valueService = new HystrixValueImpl(doHystrix.timeoutValue());
		return valueService.access(jp, getMethod(jp), doHystrix, jp.getArgs());
	}

	public Method getMethod(ProceedingJoinPoint jp) throws NoSuchMethodException {
		Signature sig = jp.getSignature();
		MethodSignature methodSignature = (MethodSignature) sig;
		return jp.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
	}

}

