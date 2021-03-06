package myhouse.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/admin-login")
	public String adminLogin() {
		return "admin/admin-login";
	}

	@RequestMapping("/admin-index")
	public String index() {
		return "admin/admin-index";
	}

	@RequestMapping("/typeManager")
	public String typeManager() {
		return "admin/typeManager";
	}

	@RequestMapping("/districtManager")
	public String districtManager() {
		return "admin/districtManager";
	}

	@RequestMapping("/streetManager")
	public String streetManager() {
		return "admin/streetManager";
	}

	@RequestMapping("/userManager")
	public String userManager() {
		return "admin/userManager"; 
	}

	@RequestMapping("/houseManager")
	public String houseManager() {
		return "admin/houseManager"; 
	}
}
