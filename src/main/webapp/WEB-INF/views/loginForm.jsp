<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="modal-header">
  <button type="button" class="close" data-dismiss="modal" onclick="history.back(-1);">X</button>
  <h1>Login</h1>
</div>
<div class="modal-body">
  <form method="post" action="login" class="form-horizontal">
	  <div class="form-group">
	    <label for="inputEmail3" class="col-sm-2 control-label">ID</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="serviceId" placeholder="사용자 아이디" required>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" name="password" placeholder="사용자 비밀번호" required>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-default">Sign in</button>
	      <button type="button" class="btn btn-default"onclick="location.href='joinForm'">Sign Up</a>
	    </div>
	  </div>
	</form>
    <br>
  <div class="modal-footer">
     ${failMessage}
  </div>
</div>
</body>
</html>


