package com.jpa.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/test") 
		public String test() {
		int a =67;
		int b =89;
		int c = 79;
		return "this is just testing  sum of a and b is " + (a + b + c);
	}
}
