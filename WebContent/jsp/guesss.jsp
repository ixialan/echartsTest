<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="../js/guessnumber.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div style="margin: 50px;">
		<span>猜数字游戏：</span><input style="margin-left: 20px; width: 100px;" id="playID" type="button" value="开始"><input style="margin-left: 20px; width: 100px;" id="notplayID" type="button" value="结束">
		<hr>
		<div id="selectdivID" style="margin-top: 20px;">
			<div style="float: left;"><span>请选择游戏难度:</span></div><div style="float: left; margin-left: 20px;"><s:select id="selectvalueID" style="width:120px;" list="#{1:'容易',2:'较难',3:'最难'}" listKey="key" listValue="value"  headerKey="0" headerValue=""></s:select></div>
		</div>
		<br>
		<hr>
		<div id="guessdivID" style="margin-top: 20px;">
			<div style="height: 20px;">
				<label>请输入猜想数字：</label><input type="text" id="guessnumID"><input style="margin-left: 20px; width: 100px;" id="resultID" type="button" value="提交结果">
			</div>
			<hr>
			<label id="labelID"></label>
		</div>
	</div>
</body>
</html>