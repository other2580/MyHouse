package myhouse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("admin/admin-index")
	public String index() {
		return "admin/admin-index";
	}
}
