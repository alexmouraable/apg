package br.com.ratel.apg.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ratel.apg.application.presenter.PrintPasswordPresenter;
import br.com.ratel.apg.application.web.presenter.viewmodel.PrintPasswordScreenViewModel;
import br.com.ratel.apg.domain.constant.PasswordType;
import br.com.ratel.apg.domain.entry.password.PrintPasswordEntry;
import br.com.ratel.apg.domain.entry.password.request.PrintPasswordRequest;

@Controller
@RequestMapping("password")
class PasswordController {
	@Autowired
	private PrintPasswordPresenter<PrintPasswordScreenViewModel[]> printPasswordPresenter;

	@Autowired
	private PrintPasswordEntry printPasswordEntry;

	@RequestMapping("/print-password")
	public ModelAndView goToPrintPasswordPage(PrintPasswordRequest printPasswordRequest) {
		ModelAndView modelAndView = new ModelAndView("password/print-password");
		modelAndView.addObject("passwordTypes", this.printPasswordPresenter.toViewModel(PasswordType.values()));
		return modelAndView;
	}

	@PostMapping("/print-password")
	public String printPassword(PrintPasswordRequest printPasswordRequest) {
		this.printPasswordEntry.execute(printPasswordRequest);
		return "redirect:print-password";
	}
}
