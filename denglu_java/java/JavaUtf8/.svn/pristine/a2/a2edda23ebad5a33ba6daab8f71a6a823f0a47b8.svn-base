<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONTokener"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="com.denglu.util.Constants"%>
<%@page import="com.denglu.util.SignUtil"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
/**
* 获取用户信息
**/

String token = "";		// 登陆授权后post过来的token

Map<String, String> map = new TreeMap<String, String>();	// 用于参数排序，仅作参考
String timestamp = "" + System.currentTimeMillis();			// 时间戳
String sign_type = "MD5";									// 签名方式
map.put("token", token);
map.put("timestamp", timestamp);
map.put("sign_type", sign_type);

String sign = SignUtil.signMD5(map, Constants.API_KEY);		// 生成签名

// 获取用户信息接口url
String urlPath = Constants.DENGLU_URL + "/api/v3/user_info?token=" + token + "&timestamp=" + timestamp + "&sign_type=" + sign_type + "&sign=" + sign;

try {
	String result = SignUtil.connect(urlPath);
	
	JSONTokener jsonTokener = new JSONTokener(result);			// 解析字符串为json格式，仅作参考
	Object o = jsonTokener.nextValue();
	JSONObject jsonObj = (JSONObject) o;
}  catch (Exception e) {
	e.printStackTrace();
}

//获取用户信息后，处理(请根据您的业务逻辑来编写程序，以下只作为参考)
////////////////////////////////////////////////////////////////////////////
// 如果用户是第一次登陆网站
	// 把用户数据存到网站数据库
	// 绑定为网站用户时，需要把绑定信息同步到灯鹭，可调用绑定用户接口
	// 第一次登陆，可以调用发送登陆新鲜事的接口
	// 跳转到登陆成功页
// 如果是老用户，直接到登陆成功页
/////////////////////////////////////////////////////////////////////////////
%>