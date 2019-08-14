<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<s:form action="IndexAction" method="post" namepace="/">
	<s:textfield id="userNm" name="user_nm" value="%{#user_nm}"/>
	<s:password id="password" name="password" value="%{#passwprd}"/>
	<s:submit id="loginbtn" value="登录" style="float:left;width: 200px;margin-right:50px;"/>
	</s:form>
	
</body>
</html>