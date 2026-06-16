package com.codebyarunyadav.git_action_docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.codebyarunyadav.git_action_docker",
		"com.codebyarunyadav.git_action_docker.controller"
})

public class DemoGitActionDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGitActionDockerApplication.class, args);
	}

}
