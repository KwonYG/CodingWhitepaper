package kr.ac.ks.webproject.dto;

public class AnswerCode {
	private Long id;
	private Long answerId;
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "AnswerCode [id=" + id + ", answerId=" + answerId + ", content=" + content + "]";
	}

}
