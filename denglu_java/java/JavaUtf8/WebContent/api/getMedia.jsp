<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONTokener"%>
<%@page import="com.denglu.util.SignUtil"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.denglu.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
/**
* 获取供应商信息
**/

String appid = Constants.APP_ID;							// 灯鹭获取的appid
String timestamp = "" + System.currentTimeMillis();			// 时间戳
String sign_type = "MD5";									// 签名方式

Map<String, String> map = new TreeMap<String, String>();	// 用于参数排序，仅作参考
map.put("appid", appid);
map.put("timestamp", timestamp);
map.put("sign_type", sign_type);

String sign = SignUtil.signMD5(map, Constants.API_KEY);		// 生成签名

String urlPath = Constants.DENGLU_URL + "/api/v3/get_media?appid=" + appid + "&timestamp=" + timestamp + "&sign_type=" + sign_type + "&sign=" + sign;

try {
	String result = SignUtil.connect(urlPath);
	
	JSONTokener jsonTokener = new JSONTokener(result);			// 解析字符串为json格式，仅作参考
	Object o = jsonTokener.nextValue();
	JSONObject jsonObj = (JSONObject) o;
}  catch (Exception e) {
	e.printStackTrace();
}


%>