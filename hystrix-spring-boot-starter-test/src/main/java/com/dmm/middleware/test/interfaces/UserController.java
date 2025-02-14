package com.dmm.middleware.test.interfaces;

import com.dmm.middleware.hystrix.annotation.DoHystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mean
 * @date 2025/2/14 19:30
 * @description UserController
 */
@RestController
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * 测试：http://localhost:8081/api/queryUserInfo?userId=aaa
	 */
	@DoHystrix(timeoutValue = 350, returnJson = "{\"code\":\"1111\",\"info\":\"调用方法超过350毫秒，熔断返回！\"}")
	// @RequestMapping(path = "/api/queryUserInfo", method = RequestMethod.GET)
	@GetMapping("/api/queryUserInfo")
	public UserInfo queryUserInfo(@RequestParam String userId) throws InterruptedException {
		logger.info("查询用户信息，userId：{}", userId);
		Thread.sleep(1000);
		return new UserInfo("虫虫:" + userId, 19, "天津市东丽区万科赏溪苑14-0000");
	}

}
