<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
// $(document).ready(function() {
// $("#resultID").bind("click", function() {

// 	var url = "QueryAjaxAction";
// 	/* var typeName = text.value;
// 	if(typeName.length === 0 ){
// 		alert("请提交有效的busidomn_id！");
// 		return false;
// 	} */
	
// 	var cName = "111";
// 	var nmJson = {"cname" : cName};
// 	var nameStr = JSON.stringify(nmJson);

// 	$.post(url, {"map" : nameStr}, function(data) {
// 		var d = eval("("+data+")")
// 		//alert(d.uview_id);
// 		$("#labelID1").html("<h1>" + d.uview_id + "</h1>");
// 		$("#labelID2").html("<h1>" + d.uview_nm + "</h1>");
// 		$("#labelID3").html("<h1>" + d.uview_no + "</h1>");
// 	}, "JSON");
// });
// });
$(document).ready(function() {
	
	//$("#alternatecolor").hide();
	$("#resultID").bind("click", function() {
		//$("#tablalternatecolor").css('display','block');
		var url = "QueryAjaxAction";
		var cName = "111";
	 	var nmJson = {"cname" : cName};
	 	var nameStr = JSON.stringify(nmJson);
//         var jsonName = {"cname": typeName}//创建json对象
// 		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串 
		
		$.ajax({
			type: "POST",   
	       	url:url,
	       	//contentType: "application/json",//不使用contentType: “application/json”则data可以是对象
	       	data: {"cn": nameStr}, //请求参数
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
			var d = eval("("+data+")");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
			//$("#showID").html("<h1>"+data+"</h1>");
			$("#labelID1").html("<h1>" + d.uview_id + "</h1>");
	 		$("#labelID2").html("<h1>" + d.uview_nm + "</h1>");
	 		$("#labelID3").html("<h1>" + d.uview_no + "</h1>");
		}
	});
});
</script>
 <!-- CSS goes in the document HEAD or added to your external stylesheet -->
<!--<style type="text/css">
table.imagetable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.imagetable tr {
	background:#b5cfd2 url('img/cell-blue.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
table.imagetable td {
	background:#dcddc0 url('img/cell-grey.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
</style> -->
<script type="text/javascript">
function altRows(id){
	if(document.getElementsByTagName){  
		
		var table = document.getElementById(id);  
		var rows = table.getElementsByTagName("tr"); 
		 
		for(i = 0; i < rows.length; i++){          
			if(i % 2 == 0){
				rows[i].className = "evenrowcolor";
			}else{
				rows[i].className = "oddrowcolor";
			}      
		}
	}
}

window.onload=function(){
	altRows('alternatecolor');
}
</script>


<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
table.altrowstable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #a9c6c9;
	border-collapse: collapse;
}
table.altrowstable tr {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.altrowstable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
.oddrowcolor{
	background-color:#d4e3e5;
}
.evenrowcolor{
	background-color:#9400D3;
}
</style>

</head>
<body>
<input style="margin-left: 20px; width: 100px;" id="resultID" type="button" value="查找">
 <label id="labelID"></label>
<table border="1" class="altrowstable" id="alternatecolor">
   <tr>
   <td style="color:#D02090;">
       <h1>uview_id</h1>
   </td>
   <td style="color:#D02090;">
      <h1>uview_nm</h1> 
   </td>
   <td style="color:#D02090;">
      <h1>uview_no</h1> 
   </td>
   </tr>
   <tr>
   <td style="color:#D02090;">
       <label id="labelID1"></label>
   </td>
    <td style="color:#D02090;">
       <label id="labelID2"></label>
   </td>
    <td style="color:#D02090;">
       <label id="labelID3"></label>
   </td>
   </tr>

</table> 

</body>


</html>