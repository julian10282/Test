package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
	
	@GetMapping("/404")
	public String notFound() {
		return "404";
	}
	
	@GetMapping("/500")
	public String errorFound() {
		return "500";
	}


}
