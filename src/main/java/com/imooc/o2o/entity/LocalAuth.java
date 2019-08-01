package com.imooc.o2o.entity;

import java.util.Date;
//本地账号类
public class LocalAuth {
	
	//本地ID
	private Long localAuthId;
	//本地用户名
	private String username;
	//本地密码
	private String password;
	//创建时间
	private Date createTime;
	//最后一次修改时间
	private Date lastEditTime;
	//用来获取用户ID
	private PersonInfo personIn;
	public Long getLocalAuthId() {
		return localAuthId;
	}
	public void setLocalAuthId(Long localAuthId) {
		this.localAuthId = localAuthId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	public PersonInfo getPersonIn() {
		return personIn;
	}
	public void setPersonIn(PersonInfo personIn) {
		this.personIn = personIn;
	}
}
