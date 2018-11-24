<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestPage</title>
<link rel="stylesheet" href="resources/prism/prism.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.css">
<style>
	#content{
		border : 3px solid black;
		position: relative;
	}

</style>
</head>
<body>
	<h1>TEST QnA PAGE</h1><br><br><br>
	${question.id}<br>
	${question.userName}<br>
	${question.title}<br>
	<div id="content">
	${question.content}<br>
	</div>
	${question.createDate}<br>
	<br><br>
	<a href="update?id=${question.id}">질문 수정</a><br>
	<a href="aregister?id=${question.id}">답변달기</a><br>
	====================Answers===================<br><br>

	<c:forEach items="${answerList}" var="answer">
		${answer.id}<br>
		<div id="content">
			<div class="code_wrap">
				<div class="code_area" style="height:100%; top:0;">
					<div class="code_box">${answer.content}</div>
				</div>
			</div>
		</div><br>
		${answer.userName}<br>
		${answer.userEmail}<br>
		${answer.createDate}<br>
		<br><br>
	</c:forEach>
	<script src="resources/prism/prism.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.js"></script>
</body>
</html>