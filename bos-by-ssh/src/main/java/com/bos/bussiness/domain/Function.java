package com.bos.bussiness.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Function entity. @author MyEclipse Persistence Tools
 */

public class Function implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Function function;
	private String name;
	private String code;
	private String description;
	private String path;
	private String generatemenu;
	private Integer zindex;
	private Set<Role> roles = new HashSet<Role>();
	private Set<Function> functions = new HashSet<Function>();

	// Constructors

	/** default constructor */
	public Function() {
	}

	/** minimal constructor */
	public Function(String id) {
		this.id = id;
	}

	/** full constructor */
	public Function(String id, Function function, String name, String code,
			String description, String path, String generatemenu,
			Integer zindex, Set<Role> roles, Set<Function> functions) {
		this.id = id;
		this.function = function;
		this.name = name;
		this.code = code;
		this.description = description;
		this.path = path;
		this.generatemenu = generatemenu;
		this.zindex = zindex;
		this.roles = roles;
		this.functions = functions;
	}

	// Property accessors
	/**
	 * 此处应注意pId的第二个字母是大写所以在写get方法时，第一位必须小写：getpId()
	 * @return
	 */
	public String getpId() {
		if(function!=null){
			return function.getId();
		} else {
			return "0";
		}
		
	}
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Function getFunction() {
		return this.function;
	}
	public void setFunction(Function function) {
		this.function = function;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getGeneratemenu() {
		return this.generatemenu;
	}

	public void setGeneratemenu(String generatemenu) {
		this.generatemenu = generatemenu;
	}

	public Integer getZindex() {
		return this.zindex;
	}

	public void setZindex(Integer zindex) {
		this.zindex = zindex;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}



}