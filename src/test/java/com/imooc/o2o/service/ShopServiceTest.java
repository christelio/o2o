package com.imooc.o2o.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;

import exception.ShopOperationException;

public class ShopServiceTest extends BaseTest{
	@Autowired
	private ShopService shopService;
	
	@Test
	public void testGetShopList()
	{
		Shop shopCondition=new Shop();
		ShopCategory sc=new ShopCategory();
		sc.setShopCategoryId(1L);
		shopCondition.setShopCategory(sc);
		ShopExecution se=shopService.getShopList(shopCondition,2,5);
		System.out.println(se.getShopList().size());
		//System.out.println(se.getCount());
	}
	
	@Test
	@Ignore
	public void testAddShop() throws FileNotFoundException 
	{
		Shop shop=new Shop();
		PersonInfo owner=new PersonInfo();
		Area area=new Area();
		ShopCategory shopCategory=new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(1);
		shopCategory.setShopCategoryId(1L);
		
		
		shop.setOwner(owner);
		shop.setShopCategory(shopCategory);
		shop.setArea(area);
		
		shop.setShopId(1L);
		shop.setShopName("音乐2");
		shop.setShopDesc("王晰");
		shop.setShopAddr("坚持的男低音");
		shop.setPhone("1564164");
	
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		shop.setPriority(2);
		shop.setLastEditTime(new Date());
		File shopImg=new File("D:/o2o_images/xiaohuangren.jpg");
		InputStream is=new FileInputStream(shopImg);
		
		ShopExecution se=shopService.addShop(shop,is,shopImg.getName());
		System.out.println(se);
	}
	@Test
	@Ignore
	public void testModifyShop() throws ShopOperationException,FileNotFoundException
	{
		Shop shop=new Shop();
		shop.setShopId(1L);
		shop.setShopName("加油");
		File shopImg=new File("D:/吴磊/wulei_1.jpg");
		InputStream is=new FileInputStream(shopImg);
		ShopExecution shopExecution=shopService.modifyShop(shop, is,"wulei_1.jpg");
		System.out.println(shopExecution.getShop().getShopImg());
		
	}
}
