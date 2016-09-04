<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/batch/getbactch">
		<center><input type="text" name="user[0].id"></center>
		<center><input type="text" name="user[1].id"></center>
		<br>
		<center><input type="text" name="user[0].name"></center>
		<center><input type="text" name="user[1].name"></center>
		<br>
		<center><input type="text" name="user[0].age"></center>
		<center><input type="text" name="user[1].age"></center>
		<br>
		<center><input type="text" name="user[0].sex"></center>
		<center><input type="text" name="user[1].sex"></center>
		<br>
		<center><input type="text" name="user[0].remark"></center>
		<center><input type="text" name="user[1].remark"></center>
		<br>
		<center><input type="submit" value="提交"></center>
	</form>
	<a href="/batch/downloadFile">downloadFile</a>
	<a href="/batch/getInfoByPage/1">getInfoByPage</a>
	<a href="/batch/getPage">getPage</a>
	<a href="/batch/execins">execins</a>
	<table>
		<tbody>
			<c:forEach items="${con}" var="user">
				<tr><td>${user.id}</td><td>${user.name}</td><td>${user.age}</td><td>${user.sex}</td><td>${user.remark}</td></tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>