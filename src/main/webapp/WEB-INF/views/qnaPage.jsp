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
	<h1>TEST QnA PAGE</h1><br><br><br>
	
	${question.id}<br>
	${question.title}<br>
	${question.content}<br>
	${question.createDate}<br>
	<br><br>
	
	<a href="aregister?id=${question.id}">답변달기</a><br>
	====================Answers===================<br><br>

	<c:forEach items="${answerList}" var="answer">
		${answer.id}<br>
		${answer.content}<br>
		${answer.userName}<br>
		${answer.userEmail}<br>
		${answer.createDate}<br>
		<br><br>
	</c:forEach>
	
</body>
</html>