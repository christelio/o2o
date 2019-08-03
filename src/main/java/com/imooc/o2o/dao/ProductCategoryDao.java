package com.imooc.o2o.dao;

import java.util.List;

import com.imooc.o2o.entity.ProductCategory;

public interface ProductCategoryDao {
	//通过店铺id查询商品类别
	List<ProductCategory> queryProductCategoryList(long shopId);
}
