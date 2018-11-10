package kr.ac.ks.webproject.dto;

import java.util.Date;

public class Answer {
	private Long id;
	private String content;
	private Long questionId;
	private Date createDate;
	private String userName;
	private String userEmail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
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
		return "Answer [id=" + id + ", content=" + content + ", questionId=" + questionId + ", createDate=" + createDate
				+ ", userName=" + userName + ", userEmail=" + userEmail + "]";
	}

}
