package com.imooc.o2o.entity;

import java.util.Date;
//΢���˺���
public class WechatAuth {
	//΢���˻�
	private Long weChatAuthId;
	//openID��Ϊ�빫�ںŰ󶨵�Ψһ��ʶ
	private String openId;
	//����ʱ��
	private Date createTime;
	//������ȡ�û�ID
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