<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONTokener"%>
<%@page import="com.denglu.util.SignUtil"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.denglu.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
/**
分享
支持 新浪、腾讯、搜狐、网易、人人
**/
String appid = Constants.APP_ID;									// 灯鹭获取的appid
String mediaUserID = "1,2";											// 灯鹭获取的mediaUserID，多个mediaUserID用,连接
String content = "分享内容";											// 分享的内容
String url = "http://www.denglu.cc/news/developer/12.html";			// 分享内容的访问链接
String userID = "123456";											// 网站的用来标识用户的唯一行ID 
String timestamp = "" + System.currentTimeMillis();					// 时间戳
String sign_type = request.getParameter("sign_type");				// 签名方式

Map<String, String> map = new TreeMap<String, String>();			// 用于参数排序，仅作参考
map.put("appid", appid);
map.put("uid", userID);
map.put("muid", mediaUserID);
map.put("content", content);
map.put("url", url);
map.put("timestamp", timestamp);
map.put("sign_type", sign_type);

String sign = SignUtil.signMD5(map, Constants.API_KEY);				// 生成签名

String urlPath = Constants.DENGLU_URL + "/api/v3/share?appid=" + appid + "&muid=" + mediaUserID + "&uid=" + userID + "&content=" + content + "&url=" + url + "&timestamp=" + timestamp + "&sign_type=" + sign_type + "&sign=" + sign;

try {
	String result = SignUtil.connect(urlPath);
	
	JSONTokener jsonTokener = new JSONTokener(result);			// 解析字符串为json格式，仅作参考
	Object o = jsonTokener.nextValue();
	JSONObject jsonObj = (JSONObject) o;
}  catch (Exception e) {
	e.printStackTrace();
}
%>