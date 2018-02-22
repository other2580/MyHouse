package myhouse.entity;

public class Photo {
	private Integer id;
	private String title;
	private String fileName;
	private Integer houseId;

	public Photo() {
	}

	public Photo(Integer id, String title, String fileName, Integer houseId) {
		super();
		this.id = id;
		this.title = title;
		this.fileName = fileName;
		this.houseId = houseId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
}
