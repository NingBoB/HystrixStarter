package com.dmm.middleware.hystrix.config;

import com.dmm.middleware.hystrix.DoHystrixPoint;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mean
 * @date 2025/2/14 19:42
 * @description HystrixAutoConfigure
 */
@Configuration
public class HystrixAutoConfigure {

	/**
	 * 将切入点配置成bean
	 */
	@Bean
	@ConditionalOnMissingBean
	public DoHystrixPoint doHystrixPoint() {
		return new DoHystrixPoint();
	}

}
