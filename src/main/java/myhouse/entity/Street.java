package myhouse.entity;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Street {
	private Integer id;
	@NotBlank(message = "请填写街道名称")
	@Length(max = 20, message = "长度不能超过20个字符")
	private String name;
	@Min(value = 1, message = "请选择具体区域")
	private Integer districtId;
	private String districtName;

	public Street() {
	}

	public Street(Integer id, String name, Integer districtId) {
		this.id = id;
		this.name = name;
		this.districtId = districtId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
}
