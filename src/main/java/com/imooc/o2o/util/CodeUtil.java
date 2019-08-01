package com.imooc.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
	public static boolean checkVerifyCode(HttpServletRequest request) {
		//生成的验证码
		String verifyCodeExpected = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//用户打的验证码
		String vertifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
		if (vertifyCodeActual == null || !vertifyCodeActual.equals(verifyCodeExpected))
			return false;
		return true;
	}
}
