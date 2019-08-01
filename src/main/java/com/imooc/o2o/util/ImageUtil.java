package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

//图片工具类
public class ImageUtil {
//	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	//当前时间的格式
	private static final SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
	//生成随机数
	private static final Random r=new Random();
	private static Logger logger= LoggerFactory.getLogger(ImageUtil.class);
	
	
	public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile)
	{
		File newFile =new File(cFile.getOriginalFilename());
		try {
			cFile.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
			e.printStackTrace();
		}
		return newFile;	
	}
	
	
	/*处理缩略图,并返回新生成图片的相对值
	 * 
	 * */
	public static String generateThumbnail(InputStream thumbnailInputStream,String fileName,String targetAddr)
	{
		//文件随机名
		String realFileName=getRandomFileName();
		//文件的扩展名jpg或类似
		String extension=getFileExtension(fileName);
		//创建图片文件的路径
		makeDirPath(targetAddr);
		//
		String relativeAddr=targetAddr+realFileName+extension;
		File dest=new File(PathUtil.getImgBasePath()+relativeAddr);
		logger.debug("current complete addr is:"+PathUtil.getImgBasePath()+relativeAddr);
		try {
			Thumbnails.of(thumbnailInputStream).size(200,200)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("C:/Users/y/Desktop/xiaohuangren.jpg")), 0.25f)//用绝对路径的水印,相对报错
			.outputQuality(0.8f).toFile(dest);		
		}catch(IOException e)
		{
			logger.error(e.toString());
			e.printStackTrace();
		}
		return relativeAddr;
	}
	
	/*
	 * 生成随机文件名,随机5位数+当前年月日
	 * 
	 * */
	public static String getRandomFileName()
	{
		//获取随机5位数
		int rannum=r.nextInt(89999)+10000;
		//获取当前的时间
		String nowTimeStr=sDateFormat.format(new Date());
		//返回
		return nowTimeStr+rannum;
	}
	
	/*
	 *获取输入文件流的扩展名字
	 *
	 * */
	private static String getFileExtension(String fileName)
	{
		
		return fileName.substring(fileName.lastIndexOf("."));
	}
	
	/*创建目标路径所涉及到的目录
	 * 
	 * */
	private static void makeDirPath(String targetAddr)
	{
		String realFileParentPath=PathUtil.getImgBasePath()+targetAddr;
		File dirPath=new File(realFileParentPath);
		if(!dirPath.exists())
		{
			dirPath.mkdirs();
		}
	}
	/*删除店铺原来的图片
	 * storePath是图片路径或目录
	 * 目录则删除该目录下的所有文件
	 * 文件则删除文件
	 * @param storePath
	 * */
	public static void deleteFileOrPath(String storePath) {
		File fileOrPath = new File(PathUtil.getImgBasePath()+storePath);
		
		if (fileOrPath.exists()) {
			if (fileOrPath.isDirectory()) {
				File files[] = fileOrPath.listFiles();
				for (int i = 0; i < files.length; i++)
					files[i].delete();
			}
		}
		fileOrPath.delete();
	}
	
}
