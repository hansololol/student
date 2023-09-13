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
<style type="text/css">

  @import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap');

	#maintable a{
	text-decoration: none;
	color: black;
	text-align: right;
	}
	#logo{
		font-family: 'Nanum Pen Script', cursive;
		color: rgb(240, 240, 240);
		font-size: 70px;
		text-align: right;
	}
	#maintable a:hover{
		color:blue;
	}
</style>
<meta charset="UTF-8">
<title>헤더</title>
</head>
<body>
<table border="0" width="100%" id="maintable">
	<tr>
		<td>
		<c:choose>
			<c:when test="${isLogOn==true && member!=null && admin!='admin'}">
				환영합니다 ${member.name }님!
				<a href="${contextPath }/member/logout.do">로그아웃</a>
			</c:when>
			<c:when test="${isLogOn==true  && admin=='admin'}" >
				환영합니다 관리자 님!
				<a href="${contextPath }/member/logout.do">로그아웃</a>
			</c:when>
			<c:otherwise>
				<a href="${contextPath}/member/loginForm.do">   로그인  </a>
				<a href="${contextPath}/member/memberForm.do">  회원가입  </a>
			</c:otherwise>
		</c:choose>
		
			<a href="${contextPath }/main.do">
				메인 페이지
			</a>
		</td>
</table>

<h1 id="logo">
	꿈과 희망이 가득한 그린 학교
</h1>
</body>
</html>