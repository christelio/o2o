package com.imooc.o2o.service;


import java.io.InputStream;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;

import exception.ShopOperationException;

public interface ShopService {
	/*
	 * 新增店铺
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return 
	 * */
	
	ShopExecution addShop(Shop shop,InputStream shopImgInputStream,String fileName);
	/*
	 * 通过店铺Id查询店铺信息
	 * @return
	 * 
	 * 
	 * */
	Shop getByShopId(long shopId);
	/*
	 * 更新店铺信息,包括对图片的处理
	 * @Param shop
	 * @param shopImg
	 * @return
	 * @throws ShopOperationException
	 * 
	 * */
	ShopExecution modifyShop(Shop shop,InputStream shopImgInputStream,String fileName )throws ShopOperationException;

	/*
	 * 根据shopCondition分页返回相应店铺列表
	 * @Param shopCondition
	 * @Param pageIndex
	 * @Param pageSize
	 * @return
	 * 
	 * */
	public ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);

}
