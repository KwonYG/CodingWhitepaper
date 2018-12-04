package kr.ac.ks.webproject.dto;

import java.util.Date;
import java.util.List;

public class Question {
	private Long id;
	private String title;
	private String content;
	private Long userId;
	private Date createDate;

	private String userName;
	private String userEmail;
	private String userServiceId;

	private List<Answer> answerList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	public String getUserServiceId() {
		return userServiceId;
	}

	public void setUserServiceId(String userServiceId) {
		this.userServiceId = userServiceId;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", content=" + content + ", userId=" + userId
				+ ", createDate=" + createDate + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userServiceId=" + userServiceId + ", answerList=" + answerList + "]";
	}

}
