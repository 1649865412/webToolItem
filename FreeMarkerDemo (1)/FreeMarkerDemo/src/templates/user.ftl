<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title> 测试</title>
  </head>
  <body>
班级是：<input type='text' value='${classR.name}' />
<#list classR.user as us>
名字是：<input type='text' value='${us.userName}' />
密码是: <input type='text' value='${us.userPassword}' />
</#list>
猪的名字<input type='text' value='${pig.name}' />
猪的年岁<input type='text' value='${pig.age}' />
猪的重量<input type='text' value='${pig.weight}' />
<#include "Book.html"> 
</body>
</html>
