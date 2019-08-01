package com.imooc.o2o.entity;

import java.util.Date;
//微信账号类
public class WechatAuth {
	//微信账户
	private Long weChatAuthId;
	//openID作为与公众号绑定的唯一标识
	private String openId;
	//创建时间
	private Date createTime;
	//用来获取用户ID
	private PersonInfo personInfo;
	
	
	
	public Long getWeChatAuthId() {
		return weChatAuthId;
	}
	public void setWeChatAuthId(Long weChatAuthId) {
		this.weChatAuthId = weChatAuthId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
}
