package com.mkyong;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	Logger logger = Logger.getLogger(WelcomeController.class);
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		this.logger.info("info log");
		this.logger.debug("debug log");
		this.logger.error("error log");
		return "welcome";
	}
	
	@RequestMapping("/hi")
	@ResponseBody
	public String welcome1(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}
}