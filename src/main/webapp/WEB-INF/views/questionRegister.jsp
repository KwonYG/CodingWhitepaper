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
	
	<form method="post" action="writequestion">
        title : <input type="text" name="title"><br>
        <textarea name="content" id="content" cols="60" rows="6"></textarea>
        <br> <input type="submit" value="등록">
    </form>
    
    
	<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
	<script>
	CKEDITOR.replace('content');
	</script>
</body>
</html>