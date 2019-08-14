<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user</title>
</head>
<body>
<s:property value="userInfo.user_nm"/> 登陆啦!
<s:iterator id="u" value="userInfo">
	 <s:property value='#u.getUser_nm()'/>
</s:iterator>
</body>
</html>