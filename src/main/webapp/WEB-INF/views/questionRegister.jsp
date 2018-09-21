<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>QuestionRegister TEST </h1>
	
	<form method="post" action="write">
        name : <input type="text" name="name"><br>
        email : <input type="text" name="email"><br>
        <textarea name="content" cols="60" rows="6"></textarea>
        <br> <input type="submit" value="등록">
    </form>
	
</body>
</html>