/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author mxl
 * @version $ HttpUtil.java v1.0, 2017年4月25日 下午7:53:07 mxl Exp $
 */
public class HttpUtil {
	
	private static final Logger	logger	= Logger.getLogger("HttpUtil");
	
	/**
	 * 
	 * 允许 JS 跨域设置
	 * 
	 * <p>
	 * <!-- 使用 nginx 注意在 nginx.conf 中配置 -->
	 * 
	 * http { ...... add_header Access-Control-Allow-Origin *; ...... }
	 * </p>
	 * 
	 * <p>
	 * 非 ngnix 下，如果该方法设置不管用、可以尝试增加下行代码。
	 * 
	 * response.setHeader("Access-Control-Allow-Origin", "*");
	 * </p>
	 * 
	 * @param response
	 *            响应请求
	 */
	public static void allowJsCrossDomain(HttpServletResponse response) {
	
		response.setHeader("Access-Control-Allow-Credentials" , "true");
		response.setHeader("Access-Control-Allow-Methods" ,
				"GET, OPTIONS, POST, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Headers" ,
				"Origin, X-Requested-With, Content-Type, Accept");
		response.setHeader("Access-Control-Max-Age" , "3600");
	}
	
	/**
	 * 
	 * <p>
	 * 判断请求是否为 AJAX
	 * </p>
	 * 
	 * @param request
	 *            当前请求
	 * @return
	 */
	public static boolean isAjax(HttpServletRequest request) {
	
		return "XMLHttpRequest".equals(request.getHeader("X-Requested-With")) ? true
				: false;
	}
	
	/**
	 * 
	 * <p>
	 * 获取当前 URL 包含查询条件
	 * </p>
	 * 
	 * @param request
	 * @param encode
	 *            URLEncoder编码格式
	 * @return
	 * @throws IOException
	 */
	public static String getQueryString(HttpServletRequest request,
			String encode) throws IOException {
	
		StringBuffer sb = new StringBuffer(request.getRequestURL());
		String query = request.getQueryString();
		if (query != null && query.length() > 0) {
			sb.append("?").append(query);
		}
		return URLEncoder.encode(sb.toString() , encode);
	}
	
	/**
	 * 
	 * <p>
	 * getRequestURL是否包含在URL之内
	 * </p>
	 * 
	 * @param request
	 * @param url
	 *            参数为以';'分割的URL字符串
	 * @return
	 */
	public static boolean inContainURL(HttpServletRequest request, String url) {
	
		boolean result = false;
		if (url != null && !"".equals(url.trim())) {
			String[] urlArr = url.split(";");
			StringBuffer reqUrl = new StringBuffer(request.getRequestURL());
			for (int i = 0; i < urlArr.length; i++) {
				if (reqUrl.indexOf(urlArr[i]) > 1) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * <p>
	 * GET 请求
	 * </p>
	 * 
	 * @param request
	 * @return boolean
	 */
	public static boolean isGet(HttpServletRequest request) {
	
		if ("GET".equalsIgnoreCase(request.getMethod())) {
			return true;
		}
		return false;
	}
	
	/**
	 * <p>
	 * POST 请求
	 * </p>
	 * 
	 * @param request
	 * @return boolean
	 */
	public static boolean isPost(HttpServletRequest request) {
	
		if ("POST".equalsIgnoreCase(request.getMethod())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * <p>
	 * 请求重定向至地址 location
	 * </p>
	 * 
	 * @param response
	 *            请求响应
	 * @param location
	 *            重定向至地址
	 */
	public static void sendRedirect(HttpServletResponse response,
			String location) {
	
		try {
			response.sendRedirect(location);
		} catch (IOException e) {
			logger.severe("sendRedirect location:" + location);
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>
	 * 获取Request Playload 内容
	 * </p>
	 * 
	 * @param request
	 * @return Request Playload 内容
	 */
	public static String requestPlayload(HttpServletRequest request)
			throws IOException {
	
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(
						inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer , 0 , bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}
		return stringBuilder.toString();
	}
	
	/**
	 * <p>
	 * 获取当前完整请求地址
	 * </p>
	 * 
	 * @param request
	 * @return 请求地址
	 */
	public static String getRequestUrl(HttpServletRequest request) {
	
		StringBuffer url = new StringBuffer(request.getScheme());
		// 请求协议 http,https
		url.append("://");
		url.append(request.getHeader("host"));// 请求服务器
		url.append(request.getRequestURI());// 工程名
		if (request.getQueryString() != null) {
			// 请求参数
			url.append("?").append(request.getQueryString());
		}
		return url.toString();
	}
}
