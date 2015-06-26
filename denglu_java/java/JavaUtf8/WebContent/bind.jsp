
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONTokener"%>
<%@page import="com.denglu.util.Constants"%>
<%@page import="com.denglu.util.SignUtil"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="/errorpage.jsp"%>
<%
Long userID = (Long)session.getAttribute("se_user_id");
if (null == userID) {
	return;
}
String token = request.getParameter("token");
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
	
	long mediaUserID = (Integer)jsonObj.get("mediaUserID");
	
	//按网站具体逻辑操作
	
	// 判断是否绑定了
	//if (已绑定) {
	//	抛出异常或return
	//}

	
	// 和媒体用户建立关联（按网站具体逻辑操作）
	// 1、关联上媒体用户
	// 2、绑定信息同步到灯鹭
	String userName = "用户";										// 用户名
	String userEmail = "test@denglu.cc";							// 网站用户的邮箱
	String appid = Constants.APP_ID;								// 灯鹭获取的appid
	timestamp = "" + System.currentTimeMillis();					// 时间戳
	map = new TreeMap<String, String>();							// 用于参数排序，仅作参考
	map.put("appid", appid);
	map.put("uid", "" + userID);
	map.put("uname", userName);
	map.put("uemail", userEmail);
	map.put("muid", "" + mediaUserID);
	map.put("timestamp", timestamp);
	map.put("sign_type", sign_type);
	sign = SignUtil.signMD5(map, Constants.API_KEY);			// 生成签名
	urlPath = Constants.DENGLU_URL + "/api/v3/bind?appid=" + appid + "&muid=" + mediaUserID + "&uid=" + userID + "&uname=" + userName + "&uemail=" + userEmail + "&timestamp=" + timestamp + "&sign_type=" + sign_type + "&sign=" + sign;
	SignUtil.connect(urlPath);
	// 3、发送登陆新鲜事
	timestamp = "" + System.currentTimeMillis();				// 时间戳	
	map = new TreeMap<String, String>();						// 用于参数排序，仅作参考
	map.put("appid", appid);
	map.put("muid", "" + mediaUserID);
	map.put("timestamp", timestamp);
	map.put("sign_type", sign_type);
	sign = SignUtil.signMD5(map, Constants.API_KEY);			// 生成签名
	urlPath = Constants.DENGLU_URL + "/api/v3/send_login_feed?appid=" + appid + "&muid=" + mediaUserID + "&timestamp=" + timestamp + "&sign_type=" + sign_type + "&sign=" + sign;
	SignUtil.connect(urlPath);
	// 4、跳转到指定页面
	response.sendRedirect("/");
}  catch (Exception e) {
	e.printStackTrace();
}
%>