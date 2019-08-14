<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">

 $(document).ready(function(){
	 var url="TestAction";
	
	 $("#btn").bind("click",function(){
	// var typeName="明天会更好";
	//var typeName=$('#labelID').val;
	// var js ={"cname":typeName};
	 //var ns =JSON.stringify(js);
// 		 $.post(url, {keyName : ns}, function(data){
// 		 $("#labelID").html("<h1>"+data+"</h1>")
		 
// 	 },"JSON");
// 	 $.ajax({
// 			type: "POST",   
// 	       	url:url,
// 	       	//contentType: "application/json",//不使用contentType: “application/json”则data可以是对象
// 	       	data: {"keyName": ns}, //请求参数
// 	       	processData: true, // 允许传参
// 	       	dataType: 'json', //设置需要返回的数据类型
// 	       	success: callback_myajax, //请求成功处理函数
// 	        	error : function() {
// 	               alert("系统异常，请稍后重试！");
// 	        },
// 			error:function(){
// 				alert("系统异常，请稍后重试！");
// 			}//这里不要加","
// 		});
 $.ajax({
			type: "POST",   
	       	url:url,
	       	//contentType: "application/json",//不使用contentType: “application/json”则data可以是对象
	       	data: {}, //请求参数
	       	processData: true, // 允许传参
	       	dataType: 'json', //设置需要返回的数据类型
	       	success: callback_myajax, //请求成功处理函数
	        	error : function() {
	               alert("系统异常，请稍后重试！");
	        },
			error:function(){
				alert("系统异常，请稍后重试！");
			}//这里不要加","
		});
	 function callback_myajax(data){
			//var d = eval("("+data+")");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
			 $("#labelID").html("<h1>"+data+"</h1>")
		}
 });
 });


</script>
</head>
<body>
<%-- <s:textfield id="userNmID" name="name"></s:textfield>  --%>
<input type="button" value="点我" id="btn">
<label id="labelID"></label>
</body>
</html>