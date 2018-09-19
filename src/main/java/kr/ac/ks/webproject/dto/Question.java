package kr.ac.ks.webproject.dto;

import java.util.Date;
import java.util.List;

public class Question {
	private int id;
	private String title;
	private String content;
	private int userId;
	private Date createDate;

	private List<Answer> answerList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", content=" + content + ", userId=" + userId
				+ ", createDate=" + createDate + ", answerList=" + answerList + "]";
	}

}
