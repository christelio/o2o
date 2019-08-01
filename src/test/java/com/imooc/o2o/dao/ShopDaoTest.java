package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;

import exception.ShopOperationException;

public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
	@Test
	@Ignore
	public void  testInsertShop()
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
		shop.setShopName("音乐");
		shop.setShopDesc("test");
		shop.setShopAddr("asd");
		shop.setPhone("1564164");
		shop.setShopImg("asdasd");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		shop.setPriority(2);
		shop.setLastEditTime(new Date());
		
		
		int effectedNum=shopDao.insertShop(shop);
		assertEquals(1,effectedNum);
	}
	@Test
	@Ignore
	public void  testUpdateShop()
	{
		Shop shop=new Shop();
		PersonInfo owner=new PersonInfo();
		Area area=new Area();
		ShopCategory shopCategory=new ShopCategory();

		shop.setShopId(1L);
		//shop.setShopCategory(shopCategory);
		shop.setShopName("音乐");
		shop.setShopDesc("成都");

		shop.setPriority(2);
		shop.setLastEditTime(new Date());
		
		
		int effectedNum=shopDao.updateShop(shop);
		assertEquals(1,effectedNum);
	}
	
	@Test
	@Ignore
	public void testQueryByShopId()
	{
		long shopId=1;
		Shop shop=shopDao.queryByShopId(shopId);
		System.out.println(shop.getArea().getAreaId());
		System.out.println(shop.getArea().getAreaName());
	}
	@Test
	public void testQueryShopList()
	{
		Shop shopCondition=new Shop();
		PersonInfo owner=new PersonInfo();
		owner.setUserId(1L);
		shopCondition.setOwner(owner);
		ShopCategory sc=new ShopCategory();
		sc.setShopCategoryId(1L);
		shopCondition.setShopCategory(sc);
		List<Shop> shopList=shopDao.queryShopList(shopCondition,0,2);
		System.out.println(shopList.size());
		System.out.println(shopDao.queryShopCount(shopCondition));
		//System.out.println(shopList.size());
	}
	
	
	
}
