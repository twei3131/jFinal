<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
	<form id="ajaxForm1" action="/formNormal" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<input type="file" class="form-control" name="file"/>
		</div>
		<button type="button" onclick="ajaxUpload('ajaxForm1')" class="btn btn-primary">上传</button>
	</form>
	<br>
	<br>
	<form action="/paraNormal" method="post" enctype="multipart/form-data">
		<label class="btn btn-default">
			选择一个文件
			<input style="display:none;" onchange="showFileName(this.value)" type="file" class="form-control" name="file"/>
		</label>
		<div id="fname" style="color:red;font-size:30px;font-weight:600}"></div>
		<div class="form-group">
			<input type="text" class="form-control" name="param">
		</div>
		<button type="submit" class="btn btn-primary">上传</button>
	</form>
	<div id="temp"></div>
	<center><h1>${wedss}</h1></center>
	<script type="text/javascript" src="./../lib/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="./../lib/jquery.form.min.js"></script>
	<script type="text/javascript">
		function showFileName(value){
			var content = value.split("\\");
			var text = content[content.length - 1];
			$("#fname").css({"margin-left":"114px","margin-top": "-37px"});
			$("#fname").text(text);
		}
		
		function ajaxUpload(id){
			$("#"+id).ajaxSubmit({
				type:"post",
				url:"/formNormal",
				dataType:"json",
				success:function(data){
					var objs = JSON.stringify(data);
					$("#temp").text(objs);
					alert(objs);
				}
			});
		}
	</script>
</body>
</html>