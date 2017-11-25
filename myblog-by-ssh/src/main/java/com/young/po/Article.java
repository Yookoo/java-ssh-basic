package com.young.po;

/**
 * ArArtcle entity. @author MyEclipse Persistence Tools
 */

public class Article implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String content;
	private String jointime;
	private Integer categoryId;
	private Integer userId;
	private Integer click;
	private String keywords;

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Article(Integer id, String title, String content, String jointime, Integer categoryId, Integer userId,
			Integer click, String keywords) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.jointime = jointime;
		this.categoryId = categoryId;
		this.userId = userId;
		this.click = click;
		this.keywords = keywords;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getJointime() {
		return this.jointime;
	}

	public void setJointime(String jointime) {
		this.jointime = jointime;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getClick() {
		return this.click;
	}

	public void setClick(Integer click) {
		this.click = click;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

}