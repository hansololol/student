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
<title>사이드 메뉴</title>
<style type="text/css">
	.no-underline{
		text-decoration: none;
		color: black;
	}
	h2{
		font-size: 20px;
	}
</style>
</head>
<body>
	<h1><b>사이드 메뉴</b></h1>
	<c:choose>
			<c:when test="${isLogOn==true && admin=='admin'}">
				<h2>
					<a href="${contextPath }/member/listMembers.do" class="no-underline">학생정보보기</a><br>
				</h2>
			</c:when>
			<c:when test="${isLogOn==true && member!=null}">
				<h2>
					<a href="${contextPath }/member/resultSubject.do?id=${member.id }" class="no-underline">내정보보기</a><br>
				</h2>
			</c:when>
			<c:otherwise>
				<h2>
					
				</h2>
			</c:otherwise>
		</c:choose>
</body>
</html>