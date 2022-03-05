package br.com.igreja.mvc.cadastro1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@GetMapping
	@RequestMapping("/login")
	public String login() {
		System.out.println("aquiiii");
		return "login";
	}
	
	

}
