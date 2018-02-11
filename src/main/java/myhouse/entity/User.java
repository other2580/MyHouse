package myhouse.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	private Integer id;
	@NotBlank(message = "请输入用户名！")
	@Length(max = 20, message = "长度不能超过20个字符")
	private String userName;
	@NotBlank(message = "请输入密码！")
	@Length(max = 12, message = "长度不能超过12个字符")
	private String password;
	@NotBlank(message = "请输入姓名！")
	@Length(max = 20, message = "长度不能超过20个字符")
	private String name;
	@NotBlank(message = "请输入电话号码！")
	private String phone;
	@Email(message = "请输入正确的邮箱地址！")
	private String email;
	private Integer isAdmin;
	private Integer isInUse;

	public User() {
	}

	public User(Integer id, String userName, String password, String name, String phone, String email, Integer isAdmin,
			Integer isInUse) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.isAdmin = isAdmin;
		this.isInUse = isInUse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getIsInUse() {
		return isInUse;
	}

	public void setIsInUse(Integer isInUse) {
		this.isInUse = isInUse;
	}
}
