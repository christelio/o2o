package com.imooc.o2o.service;
import java.util.List;

import com.imooc.o2o.entity.ProductCategory;
public interface ProductCategoryService {
	/*查询某个店铺下的所有店铺信息*/
	List<ProductCategory>  getProductCategoryList(long shopId);
}
