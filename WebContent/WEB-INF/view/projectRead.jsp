<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	
		<tr>
			<td>프로젝트 이름</td>
			<td>${map.projectManagement.name }</td>
		</tr>
	
		<tr>
			<td>프로젝트 내용</td>
			<td>${map.content.content }</td>
		</tr>
			<tr>
			<td>시작날짜</td>
			<td>${map.projectManagement.start_date }</td>
		</tr>
			<tr>
			<td>종료날짜</td>
			<td>${map.projectManagement.end_date }</td>
		</tr>
			<tr>
			<td>상태</td>
			<td>${map.projectManagement.progress }</td>
		</tr>
	</table>
	<a href="update.do?no=${map.projectManagement.no}" >[수정]</a> <a href="delete.do?no=${map.projectManagement.no }">[삭제]</a> <a href="list.do">[돌아가기]</a>
</body>
</html>