<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>TEST Login Form </h1>
	<form method="post" action="login">
		ID : <input type="text" name="serviceId" placeholder="사용자 아이디"><br>
        password : <input type="password" name="password" placeholder="사용자 비밀번호"><br>
        
        <br> <input type="submit" value="로그인">
    </form>
    <br>
    ${failMessage}
</body>
</html>