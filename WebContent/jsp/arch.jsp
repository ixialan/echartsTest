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
<!-- <form action="UviewAction" method="post" namespace="/" > -->

<!--   uview_nm: <input type="text" name="uview_id"/> <br>   -->
<!--   uview_nm: <input type="text" name="uview_nm"/> <br>   -->
<!--   uview_no: <input type="text" name="address"/> <br>  -->
				
<s:form action="UviewAction" method="post" namepace="/">
	编号：<s:textfield id="uview_id" name="uview_id" value="%{#uview_id}"/>
	名字：<s:textfield id="uview_nm" name="uview_nm" value="%{#uview_nm}"/>
	<s:submit id="loginbtn" value="查询" style="float:left;width: 200px;margin-right:50px;"/>
	</s:form>


<!-- </form> -->

</body>
</html>