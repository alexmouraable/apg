package br.com.ratel.apg.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("password")
public class PasswordController {
	@RequestMapping("/print-password")
	public String goToPrintPasswordPage() {
		return "password/print-password";
	}	
}
