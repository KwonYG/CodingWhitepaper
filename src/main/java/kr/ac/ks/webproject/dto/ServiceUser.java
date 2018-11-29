package kr.ac.ks.webproject.dto;

import java.util.Date;

public class ServiceUser {
	private Long id;
	private String serviceId;
	private String password;
	private String name;
	private String email;
	private int questionCount;
	private int answerCount;
	private Date createDate;

	// 인자가 있는 생성자를 쓸 경우 기본 생성자 필수
	public ServiceUser() {

	}

	public ServiceUser(Long id, String serviceId, String password, String name, String email, int questionCount,
			int answerCount, Date createDate) {
		this.id = id;
		this.serviceId = serviceId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.questionCount = questionCount;
		this.answerCount = answerCount;
		this.createDate = createDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isMatchPassword(String newPassword) {
		if (newPassword == null)
			return false;

		return newPassword.equals(this.password);
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	public int getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "ServiceUser [id=" + id + ", serviceId=" + serviceId + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", questionCount=" + questionCount + ", answerCount=" + answerCount
				+ ", createDate=" + createDate + "]";
	}

}
