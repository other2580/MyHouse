package myhouse.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Type {
	private Integer id;
	@NotBlank(message = "请填写房型名称")
	@Length(max = 10, message = "长度不能超过10个字符")
	private String name;

	public Type() {
	}

	public Type(Integer id, String name) {
		this.id = id;
		this.name = name;
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
}
