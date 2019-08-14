<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
	//获取上下文
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort() + path;// + "/";
%>

<script type="text/javascript" src="<%=basePath%>/jquery/jquery-2.1.4.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<s:form action="TestAjaxAction" namespace="/" id="TestAjaxform">
		<label style="float: left;">账号:</label>
		<label style="float: left;">
	        <s:textfield id="user_nm" name="sys_user.user_nm" value="%{#u.user_nm}" />
	    </label>
	    <br>
	    <label style="float: left;">密码:</label>
	    <label style="float: left;">
	        <s:password id="password" name="sys_user.password" value="%{#u.password}" />
	    </label>
	    <br>
	    <br>
	    <br>
	    <s:submit id="loginbtn" value="登录" style="float: left; width: 200px; margin-right: 50px;" />
	    <s:submit id="cancelbtn" value="取消" style="float: left; width: 200px; margin-right: 50px;" />
    </s:form>
</body>
</html>