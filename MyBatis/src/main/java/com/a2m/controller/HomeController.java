package com.a2m.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	
	@GetMapping("/login")
	public String login(@RequestParam(name = "success", defaultValue = "unknow") String success
			) {
		return "login";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/login-error")
	public String error() {
		return "loginError";
	}
	@GetMapping("/login-success")
	public String success() {
		return "loginSuccess";
	}
}
