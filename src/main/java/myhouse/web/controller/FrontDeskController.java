package myhouse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontDeskController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/userInfo")
	public String userInfo() {
		return "userInfo";
	}
}
