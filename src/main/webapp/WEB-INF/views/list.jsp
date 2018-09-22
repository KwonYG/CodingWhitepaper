<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestPage</title>
</head>
<body>
	<h1>TEST LIST PAGE</h1><br><br><br>
	
	<c:forEach items="${questionList}" var="question">
	${question.id}<br>
	<a href="question?id=${question.id}">${question.title}</a><br>
	${question.userName}<br>
	${question.createDate}<br>
	<br><br>
	</c:forEach>
	
	<c:forEach items="${pageStartList}" var="pageIndex" varStatus="status">
		<a href="list?start=${pageIndex}">${status.index + 1}</a> &nbsp; &nbsp;
	</c:forEach>
	<br><br>
	<a href="qregister">글쓰기</a>
</body>
</html>