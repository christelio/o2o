package com.imooc.o2o.entity;

import java.util.Date;

//��ϸͼƬ��
public class ProductImg {
	//ͼƬID
	private Long productImgId;
	//ͼƬ��ַ
	private String imgAddr;
	//ͼƬ����
	private String imgDesc;
	//ͼƬȨ��
	private Integer priority;
	//����ʱ��
	private Date createTime;
	//�����ĸ���ƷID
	private Long productId;
	
	public Long getProductImgId() {
		return productImgId;
	}
	public void setProductImgId(Long productImgId) {
		this.productImgId = productImgId;
	}
	public String getImgAddr() {
		return imgAddr;
	}
	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}
	public String getImgDesc() {
		return imgDesc;
	}
	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
