<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>FreeMarker</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="1111.css">
	<link type="text/css" rel="stylesheet" href="2222.css">
	<link type="text/css" rel="stylesheet" href="3333.css">
	<link type="text/css" rel="stylesheet" href="4444.css">
	<script type="text/javascript" src="jquery.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <a href="module.jsp">测试 开始渲染HTML文件</a><br>
    <script>
    function addCSS(url) {
        var link = document.createElement('link');
        link.type = 'text/css';
        link.rel = 'stylesheet';
        link.href = url;
        var flg=true;
        $("head").find("link").each(function(){
               console.log($(this).attr("href"));
               if(url==$(this).attr("href")){
                 flg=false;
               }
        });
        if(flg){$("head").append(link);}
    }

    function abctest(){
    	$.getScript("123.js"); 
    	addCSS('123.css');
    }
    </script>
    <input type="button" value="加载JS及CSS文件  进入装修模式"  onclick="abctest()" />
    <input type="button" value="执行"  onclick="abc()" />
    <div class="testv">这个文字 给你个颜色看看</div>
  </body>
</html>