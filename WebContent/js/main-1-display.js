/* 页面加载完成，定事件 */
$(document).ready(function() {
	
	$("#bigbtn1_1").hide();
	$("#popup1_1").mouseover(function(){
		$("#bigbtn1_1").css('display','block');
	});
	$("#popup1_1").mouseout(function(){
		$("#bigbtn1_1").hide();
	});
	
	$("#bigbtn1_2").hide();
	$("#popup1_2").mouseover(function(){
		$("#bigbtn1_2").css('display','block');
	});
	$("#popup1_2").mouseout(function(){
		$("#bigbtn1_2").hide();
	});
	
	$("#bigbtn1_3").hide();
	$("#popup1_3").mouseover(function(){
		$("#bigbtn1_3").css('display','block');
	});
	$("#popup1_3").mouseout(function(){
		$("#bigbtn1_3").hide();
	});
	
	$("#bigbtn1_1").hide();
	$("#popup1_1").mouseover(function(){
		$("#bigbtn1_1").css('display','block');
	});
	$("#popup1_1").mouseout(function(){
		$("#bigbtn1_1").hide();
	});
	
	$("#database1").hide();
	$("#demo_box_1").mouseover(function(){
		$("#database1").css('display','block');
	});
	$("#demo_box_1").mouseout(function(){
		$("#database1").hide();
	});
	$("#database2").hide();
	$("#demo_box_3").mouseover(function(){
		$("#database2").css('display','block');
	});
	$("#demo_box_3").mouseout(function(){
		$("#database2").hide();
	});
	$("#database3").hide();
	$("#demo_box_5").mouseover(function(){
		$("#database3").css('display','block');
	});
	$("#demo_box_5").mouseout(function(){
		$("#database3").hide();
	});
	
	$("#diagramchange1").hide();
	$("#demo_box_2").mouseover(function(){
		$("#diagramchange1").css('display','block');
	});
	$("#demo_box_2").mouseout(function(){
		$("#diagramchange1").hide();
	});
	$("#diagramchange2").hide();
	$("#demo_box_4").mouseover(function(){
		$("#diagramchange2").css('display','block');
	});
	$("#demo_box_4").mouseout(function(){
		$("#diagramchange2").hide();
	});
	$("#diagramchange3").hide();
	$("#demo_box_6").mouseover(function(){
		$("#diagramchange3").css('display','block');
	});
	$("#demo_box_6").mouseout(function(){
		$("#diagramchange3").hide();
	});
	
	btn1_1();//点击提交，执行AJAX
	
	$('#demo_box_1').popmenu({'borderRadius':'10px'});
	$('#demo_box_2').popmenu({'background':'#e67e22','focusColor':'#c0392b','borderRadius':'10px'});
	$('#demo_box_3').popmenu({'borderRadius':'10px'});
	$('#demo_box_4').popmenu({'background':'#e67e22','focusColor':'#c0392b','borderRadius':'10px'});
	$('#demo_box_5').popmenu({'borderRadius':'10px'});
	$('#demo_box_6').popmenu({'background':'#e67e22','focusColor':'#c0392b','borderRadius':'10px'});
	
	$("#database1x").hide();
	$("#demo_box_1x").mouseover(function(){
		$("#database1x").css('display','block');
	});
	$("#demo_box_1x").mouseout(function(){
		$("#database1x").hide();
	});
	$("#database2x").hide();
	$("#demo_box_3x").mouseover(function(){
		$("#database2x").css('display','block');
	});
	$("#demo_box_3x").mouseout(function(){
		$("#database2x").hide();
	});
	$("#database3x").hide();
	$("#demo_box_5x").mouseover(function(){
		$("#database3x").css('display','block');
	});
	$("#demo_box_5x").mouseout(function(){
		$("#database3x").hide();
	});
	
	$("#diagramchange1x").hide();
	$("#demo_box_2x").mouseover(function(){
		$("#diagramchange1x").css('display','block');
	});
	$("#demo_box_2x").mouseout(function(){
		$("#diagramchange1x").hide();
	});
	$("#diagramchange2x").hide();
	$("#demo_box_4x").mouseover(function(){
		$("#diagramchange2x").css('display','block');
	});
	$("#demo_box_4x").mouseout(function(){
		$("#diagramchange2x").hide();
	});
	$("#diagramchange3x").hide();
	$("#demo_box_6x").mouseover(function(){
		$("#diagramchange3x").css('display','block');
	});
	$("#demo_box_6x").mouseout(function(){
		$("#diagramchange3x").hide();
	});
	
	$('#demo_box_1x').popmenu({'borderRadius':'10px'});
	$('#demo_box_2x').popmenu({'background':'#e67e22','focusColor':'#c0392b','borderRadius':'10px'});
	$('#demo_box_3x').popmenu({'borderRadius':'10px'});
	$('#demo_box_4x').popmenu({'background':'#e67e22','focusColor':'#c0392b','borderRadius':'10px'});
	$('#demo_box_5x').popmenu({'borderRadius':'10px'});
	$('#demo_box_6x').popmenu({'background':'#e67e22','focusColor':'#c0392b','borderRadius':'10px'});
});
	
/* 提交结果，执行AJAX */
function btn1_1() {
	
	var url = "EchartsTest1_1Action_ajaxQuery";
	$.post(url, "", function(data){
		
    	// 基于准备好的dom，初始化echarts图表
		var myChart = echarts.init(document.getElementById('main1'));
	    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
		var jsonStr = JSON.parse(data);
		
		//alert(data);
		// 为echarts对象加载数据 
		myChart.setOption(jsonStr);
		
		window.onresize = myChart.resize;
		
		myChart.on("click", function(data) {
			//alert(JSON.stringify(echarts));
			//alert(JSON.stringify(data.data.text));
		});
    }, "json").error(function(e){
    	alert("EchartsTest1_1Action:系统异常，请稍后重试！");
	});
    
	var url = "EchartsTest1_2Action_ajaxQuery";
	$.post(url, "", function(data){
    	// 基于准备好的dom，初始化echarts图表
		var myChart = echarts.init(document.getElementById('main2'));
	    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
		var jsonStr = JSON.parse(data);
		//alert(data);
		// 为echarts对象加载数据 
		myChart.setOption(jsonStr);
		
		window.onresize = myChart.resize;
		
		myChart.on("click", function(data) {
			//alert(JSON.stringify(echarts));
			//alert(JSON.stringify(data.data.text));
		});
    }, "json").error(function(e){
    	alert("EchartsTest1_2Action:系统异常，请稍后重试！");
	});
	
    var url = "EchartsTest1_3Action_ajaxQuery";
    $.post(url, "", function(data){
    	
    	// 基于准备好的dom，初始化echarts图表
		var myChart = echarts.init(document.getElementById('main3'));
	    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
		var jsonStr = JSON.parse(data);
		//alert(data);
		// 为echarts对象加载数据 
		myChart.setOption(jsonStr);
		
		window.onresize = myChart.resize;
		
		myChart.on("click", function(data) {
			//alert(JSON.stringify(echarts));
			//alert(JSON.stringify(data.data.text));
		});
    }, "json").error(function(e){
    	alert("EchartsTest1_3Action:系统异常，请稍后重试！");
	});
	

	$.ajax({
		type: "POST",   
       	url:"NavigateTestAction_ajaxQuery",
       	contentType: "application/json",
       	data: "", //请求参数
       	processData: false,
       	dataType: 'JSON', //设置需要返回的数据类型
       	success: callback_navigate, //请求成功处理函数
           error : function() {
               alert("系统异常，请稍后重试！");
        },
		error:function(){
			alert("系统异常，请稍后重试！");
		}//这里不要加","
	});

	function callback_navigate(data){
		var d = eval("("+data+")");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
		
		//得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来
	    $("#fa-book-count").append("<h1>"+d.count0+"</h1>");
	    $("#fa-book-count").append("<p>"+d.name0+"</p>");
	    $("#fa-database-count").append("<h1>"+d.count1+"</h1>");
	    $("#fa-database-count").append("<p>"+d.name1+"</p>");
	    $("#fa-object-group-count").append("<h1>"+d.count2+"</h1>");
	    $("#fa-object-group-count").append("<p>"+d.name2+"</p>");
	    $("#fa-sitemap-count").append("<h1>"+d.count3+"</h1>");
	    $("#fa-sitemap-count").append("<p>"+d.name3+"</p>");
//	    for(var i in data){ 
//            if (data.hasOwnProperty(i)) {
//            	//alert(data[i].count);
//            	$("div").append("<h1>"+data[i].count+"</h1>");
//            	$("div").append("<p>"+data[3].name+"</p>");
//            } 
//        }
	}
	
	//------------------------点击main1区域图形切换按钮开始---------------------------------
	
	$(".demo_li").click(function(){
		
	    // 下面这行代码就是你要的ID属性
		var url = "EchartsTest1_1Action_ajaxQuery";
		var typeName = $(this).attr("value");
        var jsonName = {cname: typeName}; //创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串
//		alert(cname);
		$.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main1'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	
	
	//给按钮绑定点击事件
	$("#treeMapecharts1_1").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#treeMapecharts1_1").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main1'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	
	//给按钮绑定点击事件
	$("#barecharts1_1").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#barecharts1").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main1'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	
	//给按钮绑定点击事件
	$("#areaecharts1").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#areaecharts1").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main1'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	
	//给按钮绑定点击事件
	$("#pieecharts1").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#pieecharts1").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main1'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	
	//给按钮绑定点击事件
	$("#lineecharts1").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#lineecharts1").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main1'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	//------------------------点击main1区域图形切换按钮结束---------------------------------
	
	//------------------------点击main1区域数据切换按钮开始---------------------------------
	//给按钮绑定点击事件
	$("#datachange1_1").bind("click", function() {
		var url = "EchartsTest1_1Action_ajaxQuery";
		var dataType = $("#datachange1_1").attr("value");//获取Echarts类型名
		var jsonName = {dbdata: dataType}//创建json对象
		var dbdata = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
		$.post(url, {dataType: dbdata}, function(data){
			
			// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main1'));
			//data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
		}, "json");
	});
	
	
	//------------------------点击main1区域数据切换按钮结束---------------------------------
	
	//------------------------点击main2区域图形切换按钮开始---------------------------------
	//给按钮绑定点击事件
	$("#treeMapecharts2").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#treeMapecharts2").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main2'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	
	//给按钮绑定点击事件
	$("#barecharts2").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#barecharts2").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main2'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	
	//给按钮绑定点击事件
	$("#areaecharts2").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#areaecharts2").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main2'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	
	//给按钮绑定点击事件
	$("#pieecharts2").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#pieecharts2").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main2'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	
	//给按钮绑定点击事件
	$("#lineecharts2").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#lineecharts2").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main2'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	//------------------------点击main2区域图形切换按钮结束---------------------------------
	
	//------------------------点击main3区域图形切换按钮开始---------------------------------
	//给按钮绑定点击事件
	$("#treeMapecharts3").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#treeMapecharts3").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main3'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	
	//给按钮绑定点击事件
	$("#barecharts3").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#barecharts3").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main3'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	
	//给按钮绑定点击事件
	$("#areaecharts3").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#areaecharts3").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main3'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	
	//给按钮绑定点击事件
	$("#pieecharts3").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#pieecharts3").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main3'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	
	//给按钮绑定点击事件
	$("#lineecharts3").bind("click", function() {
        var url = "ChangeEchartsAction_ajaxQuery";
        var typeName = $("#lineecharts3").attr("value");//获取Echarts类型名
        var jsonName = {cname: typeName}//创建json对象
		var cname = JSON.stringify(jsonName); //将json对象转换成json格式的字符串    
        $.post(url, {typeName: cname}, function(data){
        	
        	// 基于准备好的dom，初始化echarts图表
			var myChart = echarts.init(document.getElementById('main3'));
		    //data就是ajax调用后，返回的数据，想怎么使用就怎么使用
			var jsonStr = JSON.parse(data);
			//alert(data);
			// 为echarts对象加载数据 
			myChart.setOption(jsonStr);
			
			window.onresize = myChart.resize;
			
			myChart.on("click", function(data) {
				//alert(JSON.stringify(echarts));
				//alert(JSON.stringify(data.data.text));
			});
        }, "json");
	});
	//------------------------点击main2区域图形切换按钮结束---------------------------------
	//=================================================================================================
	
}
