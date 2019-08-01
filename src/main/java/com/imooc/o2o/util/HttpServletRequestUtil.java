package com.imooc.o2o.util;

import javax.servlet.http.HttpServletRequest;

//key的转换工具类
public class HttpServletRequestUtil {
	//将key转换成int类型
	public static int getInt(HttpServletRequest request,String key)
	{
		try {
			
			return Integer.decode(request.getParameter(key));
		}
		catch(Exception e)
		{
			return -1;
		}
	}
	//将key转换成long类型
	public static long getLong(HttpServletRequest request,String key)
	{
		try {
			
			return Long.valueOf(request.getParameter(key));
		}
		catch(Exception e)
		{
			return -1L;
		}
	}
	//将key转换成double类型
	public static double getDouble(HttpServletRequest request,String key)
	{
		try {
			
			return Double.valueOf(request.getParameter(key));
		}
		catch(Exception e)
		{
			return -1d;
		}
	}
	//将key转换成String类型
	public static String getString(HttpServletRequest request,String key)
	{
		try {
			String result=request.getParameter(key);
			if(result!=null)
				result=result.trim();
			if("".equals(result))
				result=null;
			return result;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	//将key转换成boolean类型
	public static boolean getBoolean(HttpServletRequest request,String key)
	{
		try {
			
			return Boolean.valueOf(request.getParameter(key));
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
