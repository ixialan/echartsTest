<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"src="../jquery/jquery-3.2.1.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
	$("#btnID").bind("click", function() {
		
		var url = "JqueryAjaxAction_ajaxQuery";
		var typeName = $("#userNmID").val();
		var nmJson = {"cname":typeName};
		var nameStr = JSON.stringify(nmJson); 
		$.post(url, {keyName: nameStr}, function(data){
			$("#showID").html("<h1>"+data+"</h1>");
        }, "JSON");

	});
});  
/*  $.ajax({ url: jqueryAjax.jsp, context: document.body, success: function(){
    $(this).addClass("done");
  }}); */
   
</script>
<script type="text/javascript">

  /*   $("#btnID").click(function(){
    	var url="JqueryAjaxAction_ajaxQuery"
    	var typeName = $("#userNmID").val();
		var nmJson = {"cname":typeName};
		var nameStr = JSON.stringify(nmJson); 
          //Ajax调用处理
        $.ajax({
           type: "POST",
           url: url,
           data: {"keyName":nameStr},
           processData:true,
           dataType:json,
           success:callback_my
           success: function(data){
                    $("#showID").html('<h1>'+data+'</h1>');
              }
        });
        
     }); */

</script>
</head>
<body>
<s:textfield id="userNmID" name="name"></s:textfield>
<input type="button" id="btnID" value="jqueryAjax">
<div id="showID"></div>
<%-- <s:submit value="提交按钮"></s:submit>
<s:reset value="重置"></s:reset> --%>
</body>
</html>