package com.imooc.o2o.web.shopadmin;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.service.AreaService;
import com.imooc.o2o.service.ShopCategoryService;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.CodeUtil;
import com.imooc.o2o.util.HttpServletRequestUtil;


@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private ShopCategoryService shopCategoryService;
	
	
	@RequestMapping(value="/getshopmanagementinfo",method=RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getShopManagementInfo(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		long shopId = HttpServletRequestUtil.getLong(request, "shopId");
		if (shopId <= 0) {
			Object currentShopObj = request.getSession().getAttribute("currentShop");
			if (currentShopObj == null) {
				modelMap.put("redirect", true);
				modelMap.put("url", "/o2o/shopadmin/shoplist");
			} else {
				Shop currentShop = (Shop) currentShopObj;
				modelMap.put("redirect", true);
				modelMap.put("shopId", currentShop.getShopId());
			}
		} else {
			Shop currentShop = new Shop();
			currentShop.setShopId(shopId);
			request.getSession().setAttribute("currentShop", currentShop);
			modelMap.put("redirect", false);
		}

		return modelMap;
	}
	/*
	 * 获取一个用户下的店铺列表*/
	@RequestMapping(value="/getshoplist",method=RequestMethod.GET)
	@ResponseBody
	private Map<String,Object>getShopList(HttpServletRequest request)
	{
		
		Map<String,Object>modelMap=new HashMap<String,Object>();
		PersonInfo user=new PersonInfo();
		user.setUserId(1L);
		user.setName("寺尾聪");
		request.getSession().setAttribute("user",user);
		user=(PersonInfo)request.getSession().getAttribute("user");
		try {
			Shop shopCondition=new Shop();
			shopCondition.setOwner(user);
			ShopExecution se=shopService.getShopList(shopCondition, 0,100);
			modelMap.put("shopList",se.getShopList());
			modelMap.put("user",user);
			modelMap.put("success",true);
		}
		catch(Exception e){
			modelMap.put("success",false);
			modelMap.put("errMsg",e.getMessage());
		}
		return modelMap;
	}
	
	/*
	 * 通过Id查询店铺信息*/
	@RequestMapping(value="/getshopbyid",method=RequestMethod.GET)
	@ResponseBody
	private Map<String,Object>getShopById(HttpServletRequest request)
	{
		System.out.println("123");
		Map<String,Object> modelMap=new HashMap<String,Object>();
		Long shopId=HttpServletRequestUtil.getLong(request, "shopId");
		if(shopId>-1)
		{
			try {
				Shop shop=shopService.getByShopId(shopId);
				List<Area> areaList=areaService.getAreaList();
				modelMap.put("shop",shop);
				modelMap.put("areaList",areaList);
				modelMap.put("success",true);
			}catch(Exception e)
			{
				modelMap.put("success",false);
				modelMap.put("errMsg",e.toString());
			}
		}else {
			modelMap.put("success",false);
			modelMap.put("errMsg","empty shopId");
		}
		return modelMap;
	}
	
	/*
	 * 通过Id查询店铺信息*/
	@RequestMapping(value="/getshopinitinfo",method=RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> getShopInitInfo()
	{
		Map<String,Object>modelMap=new HashMap<String,Object>();
		List<ShopCategory> shopCategoryList=new ArrayList<ShopCategory>();
		List<Area> areaList=new ArrayList<Area>();
		try {		
		shopCategoryList=shopCategoryService.getShopCategoryList(new ShopCategory());
		areaList=areaService.getAreaList();
		modelMap.put("shopCategoryList", shopCategoryList);
		modelMap.put("areaList", areaList);
		modelMap.put("success",true);
		}
		catch(Exception e)
		{
			modelMap.put("success",false);
			modelMap.put("errMsg",e.getMessage());
		}
			
		return modelMap;
	}
	
	/*
	 * 注册店铺
	 * 
	 * */
	@RequestMapping(value = "/registershop", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> registerShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if(!CodeUtil.checkVerifyCode(request))//验证码判断
		{
			
			modelMap.put("sucess",false);
			modelMap.put("errMsg","输入了错误的验证码");
			return modelMap;
		}	
		// 1.接收并转化相应的参数,包括店铺信息和图片信息
		// shopStr为前端内容
		String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
		// 外部导入类,可以将String转换成pojo
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;

		try {
			// 将shopStr json转换成shop实体类
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		CommonsMultipartFile shopImg = null;
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (commonsMultipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
			shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "上传图片不能为空");
			return modelMap;
		}

		// 2.注册店铺
		if (shop != null && shopImg != null) {
			PersonInfo owner =(PersonInfo)request.getSession().getAttribute("user");
			shop.setOwner(owner);
			//因为这种转换文件的思路会导致文件的冗余所以不用来
			/*File shopImgFile = new File(PathUtil.getImgBasePath() + ImageUtil.getRandomFileName());
			try {
				shopImgFile.createNewFile();
			} catch (IOException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", "请输入店铺信息");
				return modelMap;
			}

			try {
				// 通过流转换将CommonsMultipartFile转换File
				inptStreamToFile(shopImg.getInputStream(), shopImgFile);
			} catch (IOException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", "请输入店铺信息");
				return modelMap;
			}*/

			ShopExecution se;// ShopExecution用来充当操作返回的结果类
			try {
				se = shopService.addShop(shop, shopImg.getInputStream(), shopImg.getOriginalFilename());
				if (se.getState() == ShopStateEnum.CHECK.getState()) {
					modelMap.put("success", true);
					@SuppressWarnings("unchecked")
					List<Shop> shopList = (List<Shop>) request.getSession().getAttribute("shpList");
					if (shopList == null || shopList.size() == 0) {
						shopList = new ArrayList<Shop>();
					}
					shopList.add(se.getShop());
					request.getSession().setAttribute("shopList", shopList);

				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", "请输入店铺信息");

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				modelMap.put("success", false);
				modelMap.put("errMsg", "请输入店铺信息");
			}
			
			return modelMap;
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入店铺信息");
			return modelMap;
		}

		// 3.返回结果
	}

	
	/*
	 * 修改店铺
	 * */
	@RequestMapping(value = "/modifyshop", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> modifyShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if(!CodeUtil.checkVerifyCode(request))//验证码判断
		{	
			modelMap.put("sucess",false);
			modelMap.put("errMsg","输入了错误的验证码");
			return modelMap;
		}	
		// 1.接收并转化相应的参数,包括店铺信息和图片信息
		// shopStr为前端内容
		String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
		// 外部导入类,可以将String转换成pojo
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;

		try {
			// 将shopStr json转换成shop实体类
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		CommonsMultipartFile shopImg = null;
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (commonsMultipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
			shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
		} 

		// 2.修改店铺信息
		if (shop != null && shop.getShopId()!=null) {
			PersonInfo owner = new PersonInfo();
			owner.setUserId(1L);
			shop.setOwner(owner);
			ShopExecution se;
			try {
				if (shopImg == null) {
					se = shopService.modifyShop(shop, null, null);
				} else {
					se = shopService.modifyShop(shop, shopImg.getInputStream(), shopImg.getOriginalFilename());
				}
				if (se.getState() == ShopStateEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", "请输入店铺信息");

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				modelMap.put("success", false);
				modelMap.put("errMsg", "请输入店铺信息");
			}
			
			return modelMap;
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入店铺Id");
			return modelMap;
		}

		// 3.返回结果
	}

}
