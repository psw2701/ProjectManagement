<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

tr, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="4"><a href="${pageContext.request.contextPath }/insert.do">게시글쓰기</a></td>
		</tr>
		<tr>
			<td>프로젝트 이름</td>
			<td>시작 날짜</td>
			<td>종료 날짜</td>
			<td>상태</td>
		</tr>
		<c:forEach items="${list }" var="project">
			<tr>
	
				<td><a href="read.do?no=${project.no }">${project.name }</td>  
				
				<td>${project.start_date }</td>
				
				<td>${project.end_date }</td>
				
				<td>${project.progress }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>