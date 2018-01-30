package myhouse.entity;

import java.util.Date;

public class Message {
	private Integer id;
	private Integer fromUserId;
	private Integer toUserId;
	private Date createTime;
	private String content;
	private Integer isRead;
	private Integer isDeletedByFormUser;
	private Integer isDeletedByToUser;

	public Message() {
	}

	public Message(Integer id, Integer fromUserId, Integer toUserId, Date createTime, String content, Integer isRead,
			Integer isDeletedByFormUser, Integer isDeletedByToUser) {
		this.id = id;
		this.fromUserId = fromUserId;
		this.toUserId = toUserId;
		this.createTime = createTime;
		this.content = content;
		this.isRead = isRead;
		this.isDeletedByFormUser = isDeletedByFormUser;
		this.isDeletedByToUser = isDeletedByToUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(Integer fromUserId) {
		this.fromUserId = fromUserId;
	}

	public Integer getToUserId() {
		return toUserId;
	}

	public void setToUserId(Integer toUserId) {
		this.toUserId = toUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public Integer getIsDeletedByFormUser() {
		return isDeletedByFormUser;
	}

	public void setIsDeletedByFormUser(Integer isDeletedByFormUser) {
		this.isDeletedByFormUser = isDeletedByFormUser;
	}

	public Integer getIsDeletedByToUser() {
		return isDeletedByToUser;
	}

	public void setIsDeletedByToUser(Integer isDeletedByToUser) {
		this.isDeletedByToUser = isDeletedByToUser;
	}
}
