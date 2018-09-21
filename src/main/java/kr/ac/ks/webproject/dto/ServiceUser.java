package kr.ac.ks.webproject.dto;

import java.util.Date;

public class ServiceUser {
	private Long id;
	private String name;
	private String email;
	private Date createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "ServiceUser [id=" + id + ", name=" + name + ", email=" + email + ", createDate=" + createDate + "]";
	}

}
