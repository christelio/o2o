package com.imooc.o2o.util;

/*
 * 1.依据执行环境的不同提供根路径
 * 2.返回项目子路径
 * */
public class PathUtil {
	private static String seperator = System.getProperty("file.separator");
	public static String getImgBasePath()
	{
	
		String os=System.getProperty("os.name");//获得系统的操作系统
		String basePath="";
		if(os.toLowerCase().startsWith("win"))
		{
			basePath="D:/projectdev/image/";
		}
		else
		{
			basePath="/home/xiangze/image/";
		}
		basePath=basePath.replace("/",seperator);//linux和windows的/不同所以要替换
		return basePath;
	}
	
	public static String getShopImagePath(long shopId)
	{
		String imagePath="upload/item/shop/"+shopId+"/";
		return imagePath.replace("/",seperator);
	}
}
