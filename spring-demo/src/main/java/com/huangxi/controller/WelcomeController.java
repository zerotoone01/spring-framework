package com.huangxi.controller;

import com.huangxi.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class WelcomeController {
	@Autowired
	private WelcomeService welcomeService;

	public void handleRequest(){
		welcomeService.sayHello("come from controller");
	}

}
