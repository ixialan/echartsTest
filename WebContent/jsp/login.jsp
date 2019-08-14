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
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;// + "/";
%>
<link rel="shortcut icon" type="image/x-icon" href="img/Icon.png" />
<script type="text/javascript" src="<%=basePath%>/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	
	
</script>

<title>登录</title>
</head>
<body onload="showErrorMsg()">
  	 <s:head/>
	<div class="nav">
	   <h1>TECSOON SYSTEM</h1>
	</div>
	<div id="container">
	<s:form action="LoginAction" namespace="/" id="tecsoonform">
	    <s:bean name="com.tecsoon.www.vo.Sys_user" id="u"></s:bean>
	    <p>
            <label style="float: left;">账号:</label>
	        <!-- <input name="sys_user.userName" id="userName" type="text" value="%{#u.userName}" class="zh" /> -->
	        <label style="float: left;">
	            <s:textfield id="user_nm" name="sys_user.user_nm" value="%{#u.user_nm}" />
	        </label>
       </p>
       <p>
	        <label style="float: left;">密码:</label>
	        <!-- <input name="sys_user.userPass" id="userPass" type="password" class="pass" value="%{#u.userPass}" /> -->
	        <label style="float: left;">
	            <s:password id="password" name="sys_user.password" value="%{#u.password}" />
	        </label>
       </p>
	        <%-- <s:a href="LoginAction.action" id="a_login" class="button3 font3">登录</s:a> --%>
            <%-- <s:a href="###" class="button3 font3">取消</s:a> --%>
            <s:submit id="loginbtn" value="登录" style="width: 200px; margin-left: 0px;" />
		    <s:submit value="取消" style="width: 200px; margin-left: 0px;" />
	</s:form>
	<hr>
	<s:actionerror/>
	<%-- <div id="dataArea">
		<font color="red">
		    <s:property value="%{getText('error.username.null')}"/>
		    <s:property value="%{getText('error.userpass.null')}"/>
		    <s:property value="%{getText('error.username.login')}"/>
		    <s:property value="%{getText('error.userpass.login')}"/>
		    <s:property value="%{getText('error.login.username.match')}"/>
		    <s:property value="%{getText('error.login.userpass.match')}"/>
		</font>
	</div> --%>
	</div>
</body>
</html>
