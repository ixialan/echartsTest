$(document).ready(function() {
		
	$("#selectdivID").hide();
	$("#guessdivID").hide();
	$("#playID").bind("click", function(){
		$("#selectdivID").css('display','block');
	});
	$("#notplayID").bind("click", function(){
		$("#selectdivID").hide();
		$("#guessdivID").hide();
		$("#labelID").html('');
		$("#selectvalueID").val('0');
		$("#guessnumID").val('0');
	});
		
	var select = $("#selectvalueID")[0];//转dom对象 赋值value,标签的话用innerHtml,
	
	select.onchange = function() {
		
		$("#guessdivID").css('display','block');
		
		$("#guessnumID").val("");
		
		var typeName = select.value;
		
		if(typeName==0){
			$("#guessdivID").hide();
		}
		
		var url = "CreateAjaxAction_ajaxQuery";
		var nmJson = {"cname" : typeName};
		var nameStr = JSON.stringify(nmJson);

		$.post(url, {keyName : nameStr}, function(data) {
			

		}, "JSON");
	}
	
	var text = $("#guessnumID")[0];
	
	$("#resultID").bind("click", function() {
		
		var url = "CuessAjaxAction_ajaxQuery";
		var typeName = text.value;
		
		// 正则表达式，只接收0-9数字
		var Regx = /^[0-9]*$/;
		// 判断获取值是否是数字，空字符串为0
		var flg = Regx.test(typeName);
		
		if(typeName.length === 0 || !flg){
			alert("请提交有效的数字！");
			return false;
		}
		
		var nmJson = {"cname" : typeName};
		var nameStr = JSON.stringify(nmJson);

		$.post(url, {keyName : nameStr}, function(data) {
			$("#labelID").html("<h1>" + data + "</h1>");
			//$("#guessdivID").append("<h1>"+data+"</h1>")
			if (data == "恭喜您猜对了！") {
				$("#guessnumID").val("");
			}
		}, "JSON");
	});
		
});