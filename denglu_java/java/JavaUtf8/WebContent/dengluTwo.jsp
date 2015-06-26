<%@page import="com.denglu.util.Constants"%>
<%@page import="com.denglu.util.SignUtil"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONTokener"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="/errorpage.jsp"%>
<%  
    String username = "杨荣忠";
    username = java.net.URLEncoder.encode(username.toString(),"UTF-8");
	response.sendRedirect("http://localhost:8080/customer/anonymousRegister.html?useremail=1649865888&username="+username);
%>

