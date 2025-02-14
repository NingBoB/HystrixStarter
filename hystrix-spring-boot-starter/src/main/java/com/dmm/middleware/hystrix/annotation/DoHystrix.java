package com.dmm.middleware.hystrix.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Mean
 * @date 2025/2/14 17:06
 * @description DoHystrix   切入点的注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DoHystrix {
	String returnJson() default "";     // 超时结果
	int timeoutValue() default 0;       // 超时时间
}
