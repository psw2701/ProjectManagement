<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/insert.do" method="post">
		<fieldset>
		<p>
			<label>프로젝트이름</label>
			<input type="text" name="name" value="${map.projectManagement.name }" size="40">
		</p>
		<p>
			<label>프로젝트 내용</label>
			<textarea rows="10" cols="50" name="content">${map.content.content }</textarea>
		</p>
		<p>
			<label>시작날짜</label>
			<input type="text" name="start" value="${map.projectManagement.start_date }" size="40">
		</p>
		<p>
			<label>마감날짜</label>
			<input type="text" name="end" value="${map.projectManagement.end_date }" size="40">
		</p>
		<p>
			<label>상태</label>
			<select name="progress">
				<option value="준비">준비</option>
				<option value="진행중">진행중</option>
				<option value="종료">종료</option>
				<option value="보류">보류</option>
			</select>
		</p>
		<p>
			<input type="submit" value="수정">
			<input type="reset" value="취소">
		</p>
		</fieldset>
	</form>

</body>
</html>