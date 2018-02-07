package myhouse.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import myhouse.entity.Type;
import myhouse.service.TypeService;

@Controller
@RequestMapping("/admin")
public class TypeController {
	@Autowired
	private TypeService typeService;

	@RequestMapping("/getTypeInfo")
	@ResponseBody
	public Map<String, Object> getTypeInfo() {
		Map<String, Object> map = new HashMap<>();
		map.put("data", typeService.getAll());
		return map;
	}

	@RequestMapping("/delType")
	@ResponseBody
	public boolean delType(int id) {
		try {
			return typeService.delete(id) > 0 ? true : false;
		} catch (Exception e) {
			return false;
		}
	}

	@RequestMapping("/getTypeById")
	@ResponseBody
	public Type getTypeById(int id) {
		return typeService.getTypeById(id);
	}

	@RequestMapping("/checkTypeName")
	@ResponseBody
	public boolean checkTypeName(int id, String name) {
		Type type = typeService.checkNameByUse(name);
		if (type == null)
			return true;
		if (type.getId() == id)
			return true;
		else
			return false;
	}

	@RequestMapping("/saveType")
	@ResponseBody
	public Map<String, Object> saveType(@Valid Type type,
			BindingResult bindingResult) {
		Map<String, Object> map = new HashMap<>();
		if (bindingResult.hasErrors()) {
			map.put("state", false);
			map.put("message", "分类名不符合输入规则！");
		} else {
			try {
				if (type.getId() > 0) {
					typeService.update(type);
				} else {
					typeService.add(type);
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
