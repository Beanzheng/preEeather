<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="JavaScript">
function loadXMLDoc()
{
	
	var xmlhttp;
	if (window.XMLHttpRequest)
	{
		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		// IE6, IE5 浏览器执行代码
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			var str = document.getElementById("test");
			document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
			alert(document.write(str.innerHTML));
		}
	}
	
	xmlhttp.open("GET","ajax.txt",true);
	xmlhttp.send();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div id="myDiv"><h2>使用 AJAX 修改该文本内容</h2></div>
	<button id ="test" type="button" onclick="loadXMLDoc()">修改内容</button>
</body>
</html>