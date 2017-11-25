package com.young.po;

/**
 * AcUser entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String nickname;
	private String password;
	private String jointime;
	private String telephone;
	private Integer sex;
	private String question;
	private String answer;
	private String lastdate;
	private String headpath;
	private Integer flag;
	private String description;
	private String school;
	private String qq;
	private String address;
	private String birthday;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public User(Integer id, String username, String password, String jointime, String telephone, Integer sex,
			String question, String answer, String lastdate, String headpath, Integer flag, String description,
			String school, String qq, String address, String birthday) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.jointime = jointime;
		this.telephone = telephone;
		this.sex = sex;
		this.question = question;
		this.answer = answer;
		this.lastdate = lastdate;
		this.headpath = headpath;
		this.flag = flag;
		this.description = description;
		this.school = school;
		this.qq = qq;
		this.address = address;
		this.birthday = birthday;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJointime() {
		return this.jointime;
	}

	public void setJointime(String jointime) {
		this.jointime = jointime;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getLastdate() {
		return this.lastdate;
	}

	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}

	public String getHeadpath() {
		return this.headpath;
	}

	public void setHeadpath(String headpath) {
		this.headpath = headpath;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}