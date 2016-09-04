<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center><h1>render</h1></center>
	<center><a style="color:black;text-decoration:none" href="/render/forwardwp">1</a></center>
	<center><a target="blank" style="color:black;text-decoration:none" href="/render/textxml">text</a></center>
	<center><a target="blank" style="color:black;text-decoration:none" href="/render/texthtml">text</a></center>
	<center><a style="color:black;text-decoration:none" href="/render/error">error404</a></center>
	<center><a style="color:black;text-decoration:none" href="/render/none">null</a></center>
	<center><a style="color:black;text-decoration:none" href="javascript:aja('/render/json')">json</a></center>
	<center>${users.age}</center>
	<script type="text/javascript" src="./../lib/jquery-3.1.0.min.js"></script>
	<script type="text/javascript">	
		function aja(url){
				$.get(url,function(data){
					var obj = JSON.stringify(data);
					alert(obj);
				});
		}
	</script>
</body>
</html>