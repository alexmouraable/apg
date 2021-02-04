package br.com.ratel.apg.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ratel.apg.domain.entry.password.PrintPasswordEntry;
import br.com.ratel.apg.domain.entry.password.request.PrintPasswordRequest;

@Controller
@RequestMapping("password")
public class PasswordController {
	@Autowired
	private PrintPasswordEntry printPasswordEntry;
	
	@RequestMapping("/print-password")
	public ModelAndView goToPrintPasswordPage(PrintPasswordRequest printPasswordRequest) {
		return new ModelAndView("password/print-password");
	}	
	
	@PostMapping("/print-password")
	public ModelAndView printPassword(PrintPasswordRequest printPasswordRequest) {
		this.printPasswordEntry.execute(printPasswordRequest);
		return new ModelAndView("redirect:print-password");
	}
}
