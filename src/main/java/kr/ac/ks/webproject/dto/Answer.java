package kr.ac.ks.webproject.dto;

import java.util.Date;
import java.util.List;

public class Answer {
	private Long id;
	private Long userId;
	private String content;
	private String subContent;
	private Long questionId;
	private Date createDate;

	private String serviceId;
	private String userName;
	private String userEmail;

	private List<AnswerCode> codeList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubContent() {
		return subContent;
	}

	public void setSubContent(String subContent) {
		this.subContent = subContent;
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

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
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

	public List<AnswerCode> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<AnswerCode> codeList) {
		this.codeList = codeList;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", userId=" + userId + ", content=" + content + ", subContent=" + subContent
				+ ", questionId=" + questionId + ", createDate=" + createDate + ", serviceId=" + serviceId
				+ ", userName=" + userName + ", userEmail=" + userEmail + ", codeList=" + codeList + "]";
	}

}
