package kr.ac.ks.webproject.dto;

import java.util.Date;

public class TopicComment {
	private int id;
	private String content;
	private int agree_flag;
	private int topicId;
	private Date createDate;
	private String userName;
	private String userEmail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAgree_flag() {
		return agree_flag;
	}

	public void setAgree_flag(int agree_flag) {
		this.agree_flag = agree_flag;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "TopicComment [id=" + id + ", content=" + content + ", agree_flag=" + agree_flag + ", topicId=" + topicId
				+ ", createDate=" + createDate + ", userName=" + userName + ", userEmail=" + userEmail + "]";
	}

}
