<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
	<div id="main" class="container">
		<div class="row">
			<div class="col-lg-12 col-sm-12 col-md-12">
				<div class="pull-right"><a href="/user/form" class="btn btn-primary">新增用户</a></div>
				<table class="table table-hover table-bordered">
					<thead><td>ID</td><td>姓名</td><td>年龄</td><td>性别</td><td>备注</td><td>操作</td></thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<tr><td>${user.id}</td><td>${user.name}</td><td>${user.age}</td><td>${user.sex}</td><td>${user.remark}</td><td><a href="/user/edit/${user.id}" class="btn btn-primary btn-sm">修改</a><a href="/user/delete/${user.id}" class="btn btn-danger btn-sm">删除</a></td></tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>