package com.imooc.o2o.entity;

import java.util.Date;
//�û���Ϣ��
public class PersonInfo {
	//�û�ID
	private Long userId;
	//�û�����
	private String name;
	//�û�ͷ��
	private String profileImg;
	//�û�����
	private String email;
	//�û��Ա�
	private String gender;
	//�û�״̬
	private Integer enableStatus;
	//�û����:1(�˿�),2(���),3(��������Ա)
	private Integer userType;
	//�û�����ʱ��
	private Date createTime;
	//�û����һ���޸�ʱ��
	private Date lastEditTime;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getEnableStatus() {
		return enableStatus;
	}
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
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
}