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

<title>ECHARTS练习</title>
<script type="text/javascript" src="<%=basePath%>/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/echarts.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#lab").click(function(){
		
	    // 下面这行代码就是你要的ID属性
		var url = "EchartsTest1_1Action_ajaxQuery";
		//var typeName = $(this).attr("value");
        //var jsonName = {cname: typeName}; //创建json对象
		//var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串
		$.post(url, {}, function(data){
        
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main1'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			//window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
				alert(111);
			});
        }, "JSON");
	});
});
</script>
</head>
<body>
	
	<label id="lab">显示ECHARTS</label>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="main1" style="width: auto; height:500px;"></div>
</body>
</html>