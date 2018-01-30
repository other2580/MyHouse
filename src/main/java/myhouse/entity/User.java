package myhouse.entity;

public class User {
	private Integer id;
	private String userName;
	private String password;
	private String name;
	private String phone;
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
