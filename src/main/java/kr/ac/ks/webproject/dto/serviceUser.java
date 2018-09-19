package kr.ac.ks.webproject.dto;

public class serviceUser {
	private int id;
	private String name;
	private String email;
	private String createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "serviceUser [id=" + id + ", name=" + name + ", email=" + email + ", createDate=" + createDate + "]";
	}

}
