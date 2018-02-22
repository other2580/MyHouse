package myhouse.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import myhouse.service.HouseService;
import myhouse.service.PhotoService;

@Controller
public class HouseController {
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private PhotoService photoService;

	@RequestMapping("admin/getHouseInfo")
	@ResponseBody
	public Map<String, Object> getHouseInfo(
			@RequestParam(name = "userId", required = false, defaultValue = "0") int userId,
			@RequestParam(name = "districtId", required = false, defaultValue = "0") int districtId,
			@RequestParam(name = "streetId", required = false, defaultValue = "0") int streetId,
			@RequestParam(name = "typeId", required = false, defaultValue = "0") int typeId,
			@RequestParam(name = "minPrice", required = false, defaultValue = "0") int minPrice,
			@RequestParam(name = "maxPrice", required = false, defaultValue = "0") int maxPrice,
			@RequestParam(name = "state", required = false, defaultValue = "2") int state,
			int start, int length) {

		Map<String, Object> map = new HashMap<>();
		map.put("data", houseService.getHousesPagings(userId, districtId,
				streetId, typeId, minPrice, maxPrice, state, start, length));
		map.put("recordsTotal", houseService.fetchHouseRows(userId, districtId,
				streetId, typeId, minPrice, maxPrice, state));
		map.put("recordsFiltered", houseService.fetchHouseRows(userId,
				districtId, streetId, typeId, minPrice, maxPrice, state));
		return map;
	}

	@RequestMapping("admin/modifyHouseState")
	@ResponseBody
	public boolean modifyHouseState(
			@RequestParam(name = "id", required = true) int id,
			@RequestParam(name = "state", required = true) int state) {
		try {
			return houseService.modifyState(id, (state > 0 ? 0 : 1)) > 0
					? true
					: false;
		} catch (Exception e) {
			return false;
		}
	}

	@RequestMapping("admin/houseDetailed/{id}")
	public String houseDetailed(@PathVariable("id") int id, Model model) {
		model.addAttribute("house", houseService.getHouseById(id));
		model.addAttribute("photo", photoService.getPhotoByHouseIdId(id));
		return "admin/houseDetailed";
	}
}
