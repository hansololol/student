<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<%
	request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원정보 출력창</title>
<c:choose>
 <c:when test='${msg=="addMember" }'>
 	<script>
 		window.onload=function(){
 			alert("회원을 등록했습니다.");
 		}
 	</script>
 </c:when>
 <c:when test='${msg=="modified" }'>
 	<script>
 		window.onload=function(){
 			alert("회원정보를 수정했습니다.");
 		}
 	</script>
 </c:when>
  <c:when test='${msg=="deleted" }'>
 	<script>
 		window.onload=function(){
 			alert("회원 정보를 삭제했습니다.");
 		}
 	</script>
 </c:when>
 </c:choose>
 <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
 <style>
	a{
		text-decoration: none;
		color:black;
	}
	
</style>
</head>
<body>
	<h1>회원정보</h1>
	<div class="text-success">
  <hr>
</div>
	<div class="cls2" align="right"><a href="${contextPath }/member/memberForm.do">회원검색</a><img alt="돋보기" src="https://cdn.pixabay.com/photo/2017/01/10/23/01/seo-1970475_1280.png" width="30" height="35"></div>
	<table class="table" align="center" border="1">
		<thead class="table-light">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>등수</b></td>
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>이메일</b></td>
			<td width="7%"><b>가입일</b></td>
			<td width="7%"><b>수정</b></td>
			<td width="7%"><b>삭제</b></td>
			</tr>
			</thead>
			
		<c:choose>
			<c:when test="${empty memberList }">
				<tr>
					<td colspan=7 align="center">
					<b>등록된 회원이 없습니다.</b>
					</td>
				</tr>
			</c:when>
			<c:when test="${! empty memberList }">
				<c:forEach var="mem" items="${memberList }" varStatus="status">
					<tr align="center">
						<td>${status.index +1}등</td>
						<td><a href="${contextPath }/member/resultSubject.do?id=${mem.id }&admin=admin">${mem.id }</a></td>
						<td>${mem.pwd }</td>
						<td>${mem.name }</td>
						<td>${mem.email }</td>
						<td>${mem.birth }</td>
						<td><a href="${contextPath }/member/modMember.do?id=${mem.id }">수정</a></td>
						<td><a href="${contextPath }/member/removeMember.do?id=${mem.id }">삭제</a></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>  
</body>
</html>