package com.imooc.o2o.entity;

import java.util.Date;

//ͷ����
public class HeadLine {
	//ͷ��ID
	private Long lineId;
	//ͷ������
	private String lineName;
	//ͷ������
	private String lineLink;
	//ͷ��ͼƬ
	private String lineImg;
	//Ȩ��
	private Integer priority;
	//״̬ 0������,1����
	private Integer enableStatus;
	
	
	
	public Long getLineId() {
		return lineId;
	}
	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public String getLineLink() {
		return lineLink;
	}
	public void setLineLink(String lineLink) {
		this.lineLink = lineLink;
	}
	public String getLineImg() {
		return lineImg;
	}
	public void setLineImg(String lineImg) {
		this.lineImg = lineImg;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getEnableStatus() {
		return enableStatus;
	}
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
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
	//����ʱ��
	private Date createTime;
	//���һ���޸�ʱ��
	private Date lastEditTime;


}