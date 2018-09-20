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
	<h1>TestPage</h1><br><br><br>
	
	<c:forEach items="${questionList}" var="question">
	${question.id}<br>
	${question.title}<br>
	${question.userName}<br>
	${question.createDate}<br>
	<br><br>
	</c:forEach>
</body>
</html>