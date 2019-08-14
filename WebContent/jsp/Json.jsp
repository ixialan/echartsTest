<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   var person ={"name":"Jack","age":18,"sex":"male","hoby":["抽烟","喝酒","烫头"],"student":{"name","TOM","age":18,"shoby":["看代码","写代码","码代码"],"getName":function(a){
	   return "老王"+a;
   }}};
   
   alert( person.getName("是坏蛋"));
var str = "{\"name\":\"jack\"}";
var jsonStr = eval("(str)");
alert(jsonStr);

</script>
</head>
<body>

</body>
</html>