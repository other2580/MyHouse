package myhouse.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import myhouse.entity.Street;
import myhouse.service.StreetService;

@Controller
@RequestMapping("/admin")
public class StreetController {
	@Autowired
	private StreetService streetService;

	@RequestMapping("/getStreetInfo")
	@ResponseBody
	public Map<String, Object> getStreetInfo(
			@RequestParam(name = "districtId", required = false, defaultValue = "0") int districtId,
			@RequestParam(name = "streetName", required = false, defaultValue = "") String streetName,
			int start, int length) {
		Map<String, Object> map = new HashMap<>();
		map.put("data", streetService.getStreetsPagings(districtId, streetName,
				start, length));
		map.put("recordsTotal",
				streetService.fetchStreetRows(districtId, streetName));
		map.put("recordsFiltered",
				streetService.fetchStreetRows(districtId, streetName));
		return map;
	}

	@RequestMapping("/getStreetByPrefix")
	@ResponseBody
	public List<String> getStreetByPrefix(String prefix) {
		return streetService.getStreetByPrefix(prefix);
	}

	@RequestMapping("/delStreet")
	@ResponseBody
	public boolean delStreet(int id) {
		try {
			return streetService.delete(id) > 0 ? true : false;
		} catch (Exception e) {
			return false;
		}
	}

	@RequestMapping("/getStreetById")
	@ResponseBody
	public Street getStreetById(int id) {
		return streetService.getStreetById(id);
	}

	@RequestMapping("/checkStreetName")
	@ResponseBody
	public boolean checkStreetName(String name, int id) {
		Street street = streetService.checkNameByUse(name);
		if (street == null) {
			return true;
		} else if (street.getId() == id) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping("/saveStreet")
	@ResponseBody
	public Map<String, Object> saveStreet(@Valid Street street,
			BindingResult bindingResult) {
		Map<String, Object> map = new HashMap<>();
		if (bindingResult.hasErrors()) {
			map.put("state", false);
			map.put("message", "街道名不符合输入规则！");
		} else {
			try {
				if (street.getId() > 0) {
					streetService.update(street);
				} else {
					streetService.add(street);
				}
				map.put("state", true);
				map.put("message", "OK!");
			} catch (Exception e) {
				map.put("state", false);
				map.put("message", e.getMessage());
			}
		}
		return map;
	}

	@RequestMapping("/getStreetByDistrictId")
	@ResponseBody
	public List<Street> getStreetByDistrictId(int districtId) {
		return streetService.getStreetByDistrictId(districtId);
	}

}
