package ar.edu.unlam.talleweb.timelineme.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.talleweb.timelineme.persistence.PersistenceException;
import ar.edu.unlam.talleweb.timelineme.services.LoginService;




@Controller
@RequestMapping("/login")
public class LoginController {

	LoginService loginService = new LoginService();

	@RequestMapping("/auth")
	public ModelAndView authenticate(
			@RequestParam("username") String username,
			@RequestParam("password") String password) throws PersistenceException {

		ModelAndView dispatch = null;

		if (loginService.authenticate(username, password)) {
			dispatch = new ModelAndView("welcome", "message", "Bienvenido, @" + username); 
		} else {
			dispatch = new ModelAndView("error", "message", "Ingreso incorrecto");
		}

		return dispatch;

	}

}
