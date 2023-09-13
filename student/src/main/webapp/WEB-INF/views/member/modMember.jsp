<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
    <%
	request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>

<script type="text/javascript">

	function readURL(input) {
		if(input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				$('#preview').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
<style type="text/css">
.col-md-4{
	display:block;
	width:500px;
	margin:0 auto;
}

</style>
<title>회원 정보 수정창</title>
</head>
<body>
	<form action="${contextPath }/member/updateMember.do" method="post" enctype="multipart/form-data" class="row g-3 needs-validation" novalidate>
		<h1 align="center">회원정보 수정창</h1>
		 <div class="col-md-4">
				<label for="exampleInputEmail1" class="form-label">아이디</label>
				<input type="text" name="id" id="i_id" value=${member.id } readonly class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			 <div class="col-md-4">
				<label for="exampleInputEmail1" class="form-label">비밀번호</label>
				<input type="password" name="pwd" value=${member.pwd } class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
				</div>
				<div class="col-md-4">
				<label for="exampleInputEmail1" class="form-label">이름</label>
				<input type="text" name="name" value=${member.name } class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
				</div>
			 <div class="col-md-4">
				<label for="exampleInputEmail1" class="form-label">이메일</label>
				<input type="text" name="email" value=${member.email} class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div class="col-md-4">
				<label for="exampleInputEmail1" class="form-label">이미지</label>
				<input type="file" name="image" onchange="readURL(this);" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
				<img id="preview" src="" width="200" height="200"></td>
			</div>
 				<div class="col-md-4" align="center" style="margin-top:30px">
				 <input type="submit" class="btn btn-primary" value="수정하기">
				 <input type="reset" class="btn btn-primary" value="다시입력" >
				</div>
				 </form>
				 </body>
				 </html>	 