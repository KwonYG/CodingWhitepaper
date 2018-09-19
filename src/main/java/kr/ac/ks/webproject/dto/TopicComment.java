package kr.ac.ks.webproject.dto;

public class TopicComment {
	private int id;
	private String content;
	private int agree_flag;
	private int topicId;
	private String createDate;

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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "TopicComment [id=" + id + ", content=" + content + ", agree_flag=" + agree_flag + ", topicId=" + topicId
				+ ", createDate=" + createDate + "]";
	}

}
