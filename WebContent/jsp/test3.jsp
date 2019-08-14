<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../jquery/jquery-3.2.1.js"></script>
<!-- <script type="text/javascript">
$(document).ready(function(){
	$("#btn").bind("click",function(){
   var typeName="你好，阳光";
  var url="TestAction2";
  var nj={"cname":typeName};
  var ns=JSON.stringify(nj);
  $.post(url,{keyName:ns},function(data){
	  $("#labelID").html("<h3>"+data+"</h3>");
  });
  });
});
</script> -->
<script type="text/javascript">
$(document).ready(function(){
	$("#btn").bind("click",function(){
   var typeName="你好，阳光";
  var url="TestAction2";
  var nj={"cname":typeName};
  var ns=JSON.stringify(nj);
 $.ajax({
	type:"POST",
	url:url,
	data:{"keyName":ns},
	processData:true,
	dataType:'json',
 	success: callback_myajax, //请求成功处理函数
	error : function() {
       alert("系统异常，请稍后重试！");
},
error : function() {
    alert("系统异常，请稍后重试！");
}
});
function callback_myajax(data){
//var d = eval("("+data+")");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
 $("#labelID").html("<h3>"+data+"</h3>")
}
 });
  });



</script>
</head>
<body>
<input type="button" id="btn" value="祝福">
<label id="labelID"></label>

</body>
</html>