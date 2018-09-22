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
	
	<a>답변달기</a>
</body>
</html>