package com.codebyarunyadav.git_action_docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping()
	
	String getString()
	{
		return "This is Git Action Docker Example";
	}

}
