package myhouse.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myhouse.entity.User;
import myhouse.service.UserService;

@Controller
public class AccountController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "admin/checkAdminLogin", method = RequestMethod.POST)
	public String checkAdminLogin(
			@RequestParam(name = "userName", required = true) String userName,
			@RequestParam(name = "password", required = true) String password,
			HttpSession session, Model model) {
		User admin = userService.adminLogin(userName, password);
		if (admin == null) {
			model.addAttribute("error", "登录失败，请检查登录名密码是否有误!");
			return "admin/admin-login";
		} else {
			session.setAttribute("admin", admin);
			return "redirect:/admin/admin-index";
		}
	}
}
