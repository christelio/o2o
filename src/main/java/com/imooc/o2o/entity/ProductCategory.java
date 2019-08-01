package com.imooc.o2o.entity;

import java.util.Date;

//商品类别类
public class ProductCategory {
	//商品类别id
	private Long productCategoryId;
	//店铺id
	private Long shopId;
	//商品类别名字
	private Long productCategoryName;
	//商品权重
	private Integer priority;
	//商品创建时间
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
