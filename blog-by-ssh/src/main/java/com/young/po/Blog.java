package com.young.po;

/**
 * BlBlog entity. @author MyEclipse Persistence Tools
 */

public class Blog implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String description;
	private String title;

	// Constructors

	/** default constructor */
	public Blog() {
	}

	/** minimal constructor */
	public Blog(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Blog(Integer id, Integer userId, String description, String title) {
		this.id = id;
		this.userId = userId;
		this.description = description;
		this.title = title;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}