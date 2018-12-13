<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<body>
    <h1>회원가입</h1>
    <hr>
    <div class="container">
        <form name="join" method="post" onsubmit="return validate();" action="join" class="form-horizontal">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">ID</label>
                <div class="col-sm-10">
                    <input id="idInput" class="form-control" type="text" name="serviceId" placeholder="사용자 아이디"
                        required>
                    <p class="result">
                        <span class="msg">아이디를 확인하여 주십시오.</span> <input type="button" class="btn btn-default idCheck" value="중복 체크" style="margin:5px;">
                    </p>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <input id="pwInput" class="form-control" type="password" name="password" placeholder="사용자 비밀번호"
                        required>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Password 확인</label>
                <div class="col-sm-10">
                    <input id="pwCheckInput" class="form-control" type="password" placeholder="사용자 비밀번호 확인" required>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">name</label>
                <div class="col-sm-10">
                    <input id="nameInput" class="form-control" type="text" name="name" placeholder="사용자 이름" required>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">email</label>
                <div class="col-sm-10">
                    <input id="emailInput" class="form-control" type="text" name="email" placeholder="사용자 이메일" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button id="joinBtn" type="submit" class="btn btn-default" disabled="disabled">Join</button>
                </div>
            </div>
        </form>
    </div>
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script src='resources/js/joinFormJs.js'></script>
</body>

</html>