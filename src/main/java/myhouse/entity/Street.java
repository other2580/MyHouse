package myhouse.entity;

public class Street {
	private Integer id;
	private String name;
	private Integer districtId;

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
}
