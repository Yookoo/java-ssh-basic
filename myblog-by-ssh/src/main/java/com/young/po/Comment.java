package com.young.po;

/**
 * CoComment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private Integer articleId;
	private Integer commentUserId;
	private String jointime;
	private Integer userId;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Comment(Integer id, String content, Integer articleId, Integer commentUserId, String jointime,
			Integer userId) {
		this.id = id;
		this.content = content;
		this.articleId = articleId;
		this.commentUserId = commentUserId;
		this.jointime = jointime;
		this.userId = userId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getArticleId() {
		return this.articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getCommentUserId() {
		return this.commentUserId;
	}

	public void setCommentUserId(Integer commentUserId) {
		this.commentUserId = commentUserId;
	}

	public String getJointime() {
		return this.jointime;
	}

	public void setJointime(String jointime) {
		this.jointime = jointime;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}