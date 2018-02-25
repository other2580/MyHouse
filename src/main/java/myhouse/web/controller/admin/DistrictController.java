package myhouse.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import myhouse.entity.District;
import myhouse.service.DistrictService;

@Controller
@RequestMapping("/admin")
public class DistrictController {

	@Autowired
	private DistrictService districtService;

	@RequestMapping("/getDistrictInfo")
	@ResponseBody
	public Map<String, Object> getDistrictInfo() {
		Map<String, Object> map = new HashMap<>();
		map.put("data", districtService.getAll());
		return map;
	}

	@RequestMapping("/getAllDistrict")
	@ResponseBody
	public List<District> getAllDistrict() {
		return districtService.getAll();
	}

	@RequestMapping("/getDistrictById")
	@ResponseBody
	public District getDistrictById(int id) {
		return districtService.getDistrictById(id);
	}

	@RequestMapping("/delDistrict")
	@ResponseBody
	public boolean delDistrict(int id) {
		try {
			districtService.delete(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@RequestMapping("/checkDistrictName")
	@ResponseBody
	public boolean checkDistrictName(int id, String name) {
		District district = districtService.checkNameByUse(name);
		if (district == null)
			return true;
		else if (district.getId() == id)
			return true;
		else
			return false;
	}

	@RequestMapping("/saveDistrict")
	@ResponseBody
	public Map<String, Object> saveDistrict(@Valid District district,
			BindingResult bindingResult) {
		Map<String, Object> map = new HashMap<>();
		if (bindingResult.hasErrors()) {
			map.put("state", false);
			map.put("message", "区域名不符合输入规则！");
		} else {
			try {
				if (district.getId() > 0) {
					districtService.update(district);
				} else {
					districtService.add(district);
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
}
