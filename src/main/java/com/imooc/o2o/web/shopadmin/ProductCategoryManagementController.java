package com.imooc.o2o.web.shopadmin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.o2o.dto.Result;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ProductCategoryStateEnum;
import com.imooc.o2o.service.ProductCategoryService;
@Controller
@RequestMapping("/shopadmin")
public class ProductCategoryManagementController {

	@Autowired
	private ProductCategoryService productCategoryService;
	
	//通过在线的shopId查询当前商品列表
	@RequestMapping(value="/getproductcategorylist",method=RequestMethod.GET)
	@ResponseBody
	private Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request)
	{
		List<ProductCategory>list=null;
		Shop currentShop=(Shop)request.getSession().getAttribute("currentShop");
		currentShop=new Shop();
		currentShop.setShopId(1L);
		if(currentShop!=null&&currentShop.getShopId()>0)
		{
			list=productCategoryService.getProductCategoryList(currentShop.getShopId());
			return new Result<List<ProductCategory>>(true,list);
		}
		else
		{
			ProductCategoryStateEnum ps=ProductCategoryStateEnum.INNER_ERROR;
			return new Result<List<ProductCategory>>(false,ps.getState(),ps.getStateInfo());
		}
		
	}
}
