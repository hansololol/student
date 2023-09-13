<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     isELIgnored="false"
    %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath }"  />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보 보기</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
</script>
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
	<h1 style="text-align:center">내정보 보기</h1>
    <h3>${member.id }님의 정보 </h3>
		
	<table border="0" align="center" class="table table-striped table-hover">
		<tr>
			<td align="center">이름</td>
			<td>${member.name }</td>
			<td  rowspan="4"><img src="${contextPath }/download.do?imageFileName=${member.imageFileName}&articleNO=${member.id}" width="150" height="200"><br></td>
		</tr>
		<tr>
			<td align="center">이메일</td>
			<td>${member.email}</td>
		</tr>
			<td align="center">생년월일</td>
			<td>${member.birth}</td>
	</table>
		<c:choose>
		<c:when test="${subject=='null' }">
			<p>성적 입력하기</P>
			<form method="get" action="${contextPath }/member/addSubject.do" enctype="text/plain">
				<table border="0" align="center" class="table-success" id="hidden_t" type="hidden" >
					<tr>
						<td align="center">국어</td>
						<td align="center">영어</td>
						<td align="center">수학</td>
						<td align="center">한국사</td>
						<td align="center">등록</td>
					</tr>
						<tr>
							<td><input type="text" name="korean" required></td>
							<td><input type="text" name="english" required></td>
							<td><input type="text" name="math" required></td>
							<td><input type="text" name="history" required></td> 
							<td><input type="submit" value="등록"></td> 
						</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			<table border="0" align="center" class="table table-striped table-hover">
			
				<tr>
					<td align="center">점수 총합</td>
					<td align="center">평균 점수</td>
					<td align="center">전체 등수</td>
				</tr>
					<tr>
						<td>${subject.sum}</td>
						<td>${subject.avg}</td>
						<td>${subject.rank}</td>
					</tr>
			</table>
			<a href="${contextPath }/member/modMember.do?id=${member.id }">수정하기</a>
		</c:otherwise>
		</c:choose>
	
</body>
</html>