<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>${p1}</center>
<center>${p2}</center>
<center>${id}</center>
<script type="text/javascript" src="./../lib/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	$.get("/test01/ajx",{"id":1324},function(data){
		alert(JSON.stringify(data));
	});
</script>
</body>
</html>