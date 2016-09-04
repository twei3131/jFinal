<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1>students</h1></center>
<center><h1><a style="color:black;text-decoration:none;" href="/students/setsave">students</a></h1></center>
<form id="getsaveForm">
	<div style="float:left;"><label>学号：</label><input type="text" name="student.id"></div>
	<div style="float:left;"><label>姓名：</label><input type="text" name="student.name"></div>
	<div style="float:left;"><label>年级：</label><input type="text" name="student.grage"></div>
	<div style="float:left;"><label>班级：</label><input type="text" name="student.class"></div>
	<div style="float:left;"><button>提交</button>
</form>
<script type="text/javascript" src="./../lib/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	$("#getsaveForm button").on('click',function(){
		$.post("/students/getsave",$("#getsaveForm").serialize(),function(data){
			
			alert(data);
		});
	});
</script>
</body>
</html>