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
			<div class="col-lg-6 col-sm-6 col-md-6">
				<form action="${user == null?'/user/submit':'/user/update'}" method="post">
					<div class="form-group">
						<label>学号</label>
						<input type="text" name = user.id value="${user.id}" class="form-controll" placeholder="请输入学号">
					</div>
					<div class="form-group">
						<label>姓名</label>
						<input type="text" name = user.name value="${user.name}" class="form-controll" placeholder="请输入姓名">
					</div>
					<div class="form-group">
						<label>年龄</label>
						<input type="text" name = user.age value="${user.age}" class="form-controll" placeholder="请输入年龄">
					</div>
					<div class="form-group">
						<label>性别</label>
						<div class="radio-inline">
							<input type="radio" name = user.sex value="1" <c:if test="${user!=null && user.sex == 1}"> checked="checked"</c:if> class="form-controll">男
						</div>
						<div class="radio-inline">
							<input type="radio" name = user.sex value="2" <c:if test="${user!=null && user.sex == 2}"> checked="checked"</c:if> class="form-controll">女
						</div>
					</div>
					<div class="form-group">
						<label>备注</label>
						<input type="text" name = user.remark  value = "${user.remark}" class="form-controll" placeholder="备注">
					</div>
					<div style="text-align:center">
						<button type="submit" class="btn btn-primary" style="width:120px;font-size:30px">提交</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>