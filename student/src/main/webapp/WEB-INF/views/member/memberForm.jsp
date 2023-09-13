
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
isELIgnored="false"
%>
<%
request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
<script>
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
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>회원가입 창</title>
</head>
<body>
<form action="${contextPath }/member/addMember.do" class="row g-3 needs-validation" novalidate method="post" encType="multipart/form-data">
	<h1 align="center">회원가입창</h1><br>
	<table border="1" width="80%" align="center"  class="table table-bordered">
		<tr align="center">
			<td width="200"><p align="right">아이디</td>
			<td width="400"><input type="text" name="id"></td>
			</tr>
			<tr align="center">
			<td width="200"><p align="right">비밀번호</td>
			<td width="400"><input type="password" name="pwd"></td>
			</tr >
			<tr align="center">
			<td width="200"><p align="right">이름</td>
			<td width="400"><input type="text" name="name"></td>
			</tr>
			<tr align="center">
			<td width="200"><p align="right">이메일</td>
			<td width="400"><input type="text" name="email"></td>
			</tr>
			<tr align="center">
				<td width="200"><p align="right">생년월일</td>
				<td width="400"><input type="date" name="birth"></td>
			</tr>
			<tr align="center">
				<td width="200"><p align="right">사진 등록하기</td>
				<td width="400"><input type="file" name="imageFileName" onchange="readURL(this);">
				<img id="preview" src="" width="200" height="200"></td>
			</tr>
		<tr  align="center">
			<td colspan="2"><input type="submit" value="가입하기" class="btn btn-light"><span> </span><input type="reset" value="다시입력" class="btn btn-light">
		</table>
	</form>
</body>
</html>