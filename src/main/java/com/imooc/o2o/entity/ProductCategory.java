package com.imooc.o2o.entity;

import java.util.Date;

//��Ʒ�����
public class ProductCategory {
	//��Ʒ���id
	private Long productCategoryId;
	//����id
	private Long shopId;
	//��Ʒ�������
	private Long productCategoryName;
	//��ƷȨ��
	private Integer priority;
	//��Ʒ����ʱ��
	private Date createTime;
	
	public Long getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public Long getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(Long productCategoryName) {
		this.productCategoryName = productCategoryName;
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
	
	
}
