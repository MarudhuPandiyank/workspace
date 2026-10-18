package com.micro.basetemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${server.port}")
	private int serverPort;

	@GetMapping("/api/hello")
	public String hello() {
		return "Hello from base-template";
	}

	@GetMapping("/api/instance")
	public String instance() {
		return "base-template on port " + serverPort;
	}

}