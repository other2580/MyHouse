package myhouse.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		} else if (admin.getIsInUse() == 0) {
			model.addAttribute("error", "登录失败，该账户已被禁止使用!");
			return "admin/admin-login";
		} else {
			session.setAttribute("admin", admin);
			return "redirect:/admin/admin-index";
		}
	}

	@RequestMapping(value = "checkUserLogin", method = RequestMethod.POST)
	public String checkUserLogin(
			@RequestParam(name = "userName", required = true) String userName,
			@RequestParam(name = "password", required = true) String password,
			HttpSession session, Model model) {
		User user = userService.login(userName, password);
		if (user == null) {
			model.addAttribute("error", "登录失败，请检查登录名密码是否有误!");
			return "login";
		} else if (user.getIsInUse() == 0) {
			model.addAttribute("error", "登录失败，该账户已被禁止使用!");
			return "login";
		} else {
			session.setAttribute("loginUser", user);
			return "redirect:/index";
		}
	}

	@RequestMapping("admin/getUserInfo")
	@ResponseBody
	public Map<String, Object> getUserInfo(
			@RequestParam(name = "isAdmin", required = false, defaultValue = "2") int isAdmin,
			@RequestParam(name = "isInUse", required = false, defaultValue = "2") int isInUse,
			@RequestParam(name = "userName", required = false, defaultValue = "") String userName,
			int start, int length) {
		Map<String, Object> map = new HashMap<>();
		map.put("data", userService.getUserPagings(isAdmin, isInUse, userName,
				start, length));
		map.put("recordsTotal",
				userService.fetchUserRows(isAdmin, isInUse, userName));
		map.put("recordsFiltered",
				userService.fetchUserRows(isAdmin, isInUse, userName));
		return map;
	}

	@RequestMapping("admin/getUserByPrefix")
	@ResponseBody
	public List<String> getUserByPrefix(String prefix) {
		return userService.getUserByPrefix(prefix);
	}

	@RequestMapping("admin/modifyByUse")
	@ResponseBody
	public boolean modifyByUse(int id, int isInUse) {
		try {
			return userService.modifyByUse(id, (isInUse > 0 ? 0 : 1)) > 0
					? true
					: false;
		} catch (Exception e) {
			return false;
		}
	}

	@RequestMapping("admin/modifyByAdmin")
	@ResponseBody
	public boolean modifyByAdmin(int id, int isAdmin) {
		try {
			return userService.modifyByAdmin(id, (isAdmin > 0 ? 0 : 1)) > 0
					? true
					: false;
		} catch (Exception e) {
			return false;
		}
	}

	@RequestMapping(value = {"admin/checkUserName", "checkUserName"})
	@ResponseBody
	public boolean checkUserName(
			@RequestParam(name = "userName", required = true) String userName) {
		if (userService.checkUserNameByUse(userName) == null)
			return true;
		else
			return false;
	}

	@RequestMapping("admin/saveUser")
	@ResponseBody
	public Map<String, Object> saveUser(@Valid User user,
			BindingResult bindingResult) {
		Map<String, Object> map = new HashMap<>();
		if (bindingResult.hasErrors()) {
			map.put("state", false);
			map.put("message", "有选项不符合输入规则！");
		} else {
			try {
				userService.register(user);
				map.put("state", true);
				map.put("message", "OK!");
			} catch (Exception e) {
				map.put("state", false);
				map.put("message", e.getMessage());
			}
		}
		return map;
	}

	@RequestMapping("/userRegister")
	public String userRegister(@Valid User user, BindingResult bindingResult,
			HttpSession session, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("error", "有输入项不符合输入规则！");
			return "register";
		} else {
			try {
				user.setIsAdmin(0);
				user.setIsInUse(1);
				userService.register(user);

				session.setAttribute("loginUser", user);
				return "redirect:/index";
			} catch (Exception e) {
				model.addAttribute("user", user);
				model.addAttribute("error", "有输入项不符合输入规则！");
				return "register";
			}
		}
	}

	@RequestMapping("admin/getUserName")
	@ResponseBody
	public List<User> getUserName() {
		return userService.getUserInfo();
	}

	@RequestMapping("admin/checkAdminPwd")
	@ResponseBody
	public boolean checkAdminPwd(String password, HttpSession session) {
		User user = (User) session.getAttribute("admin");
		if (password.equals(user.getPassword()))
			return true;
		else
			return false;
	}

	@RequestMapping("admin/modifyPwd")
	@ResponseBody
	public Map<String, Object> modifyPwd(String password, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		try {
			User user = (User) session.getAttribute("admin");
			userService.modifyPwd(password, user.getId());
			map.put("state", true);
			map.put("message", "Ok");
		} catch (Exception e) {
			map.put("state", false);
			map.put("message", "修改密码出错！");
		}
		return map;
	}

	@RequestMapping("admin/logout")
	public String adminLogout(HttpSession session) {
		session.removeAttribute("admin");
		return "redirect:/admin/admin-login";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginUser");
		return "redirect:/index";
	}
}
