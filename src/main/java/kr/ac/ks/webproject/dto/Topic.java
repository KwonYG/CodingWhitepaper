package kr.ac.ks.webproject.dto;

import java.util.Date;
import java.util.List;

public class Topic {
	private int id;
	private String content;
	private int likeCount;
	private int dislikeCount;
	private Date createDate;
	private List<TopicComment> commentList;

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

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<TopicComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<TopicComment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", content=" + content + ", likeCount=" + likeCount + ", dislikeCount="
				+ dislikeCount + ", commentList=" + commentList + "]";
	}

}
