package com.dmm.middleware.hystrix.value;

import com.dmm.middleware.hystrix.annotation.DoHystrix;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * @author Mean
 * @date 2025/2/14 17:07
 * @description 接口功能扩展
 */
public interface IValueService {

	Object access(ProceedingJoinPoint jp, Method method, DoHystrix doHystrix, Object[] args) throws Throwable;

}
