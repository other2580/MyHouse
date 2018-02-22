package myhouse.entity;

import java.util.Date;

public class House {
	private Integer id;
	private Integer userId;
	private String userName;
	private Integer typeId;
	private String typeName;
	private Integer streetId;
	private String streetName;
	private Integer floor;
	private double price;
	private Date updateTime;
	private String topic;
	private String content;
	private double longitude;
	private double latitude;
	private Integer state;

	public House() {
	}

	public House(Integer id, Integer userId, Integer typeId, Integer streetId,
			Integer floor, double price, Date updateTime, String topic,
			String content, double longitude, double latitude, Integer state) {
		this.id = id;
		this.userId = userId;
		this.typeId = typeId;
		this.streetId = streetId;
		this.floor = floor;
		this.price = price;
		this.updateTime = updateTime;
		this.topic = topic;
		this.content = content;
		this.longitude = longitude;
		this.latitude = latitude;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getStreetId() {
		return streetId;
	}

	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
}
