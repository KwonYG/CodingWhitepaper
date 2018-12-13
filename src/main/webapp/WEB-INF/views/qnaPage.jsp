<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>QNA</title>
    <link rel="stylesheet" type="text/css" href="resources/css/commonStyle.css">
    <link rel="stylesheet" type="text/css" href="resources/css/qnaStyle.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/prism/prism.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.css">
</head>

<body>
<header class="header">
        <nav>
            <ul class="nav justify-content-center">
                <li class="nav-item">
                    <a class="nav-link active" href="list">MAIN</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Q&A</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="rank">RANK</a>
                </li>
            </ul>
        </nav>
        <c:choose>
        		<c:when test="${sessionScope.isUser == 'true'}">
        			<div class="login"><button type="button" class="btn btn-light" onclick="location.href='logOut'">${sessionScope.userServiceId}님 LOGOUT</button></div>
        		</c:when>
        		<c:otherwise>
        			<div class="login"><button type="button" class="btn btn-light" onclick="location.href='loginForm'">LOGIN</button></div>
        		</c:otherwise>
        	</c:choose>
    </header>

<hr>


<section>
    <h2>Q&A PAGE</h2>
    <article>
        <div class="bord1">
            <div style="font-size: 14px">
                <img src="resources/img/person1.png">
                ${question.userName}<br>
                <fmt:formatDate value="${question.createDate}" pattern="yyyy.MM.dd hh:mm" />
            </div>
            <h3>${question.title}</h3>
            <hr>
            <div>${question.content}</div>
            <hr>
        </div>
        <br>
        <c:choose>
        		<c:when test="${sessionScope.isUser == 'true' && sessionScope.userServiceId == question.userServiceId}">
        				<button type="button" class="btn btn-outline-primary" onclick="location.href='delete/question?id=${question.id}'">삭제하기</button>
        				<button type="button" class="btn btn-outline-primary" onclick="location.href='update?id=${question.id}'">질문수정</button>
        		</c:when>
        	</c:choose>
        <button type="button" class="btn btn-outline-info" onclick="location.href='aregister?id=${question.id}'">답변하기</button>
        <br><br>
        <c:forEach items="${answerList}" var="answer">
        <div class="bord2">
            <div style="font-size: 14px">
                <img src="resources/img/person2.png">
                ${answer.userName} (${answer.userEmail})<br>
                <fmt:formatDate value="${answer.createDate}" pattern="yyyy.MM.dd hh:mm" /> 
            </div>
            <hr>
            <div><a href="review?id=${answer.id}">리뷰 보러가기</a></div>
        </div>
        <c:choose>
        		<c:when test="${sessionScope.isUser == 'true' && sessionScope.userServiceId == answer.serviceId}">
        				<button type="button" class="btn btn-outline-primary" onclick="location.href='delete/answer?id=${answer.id}'">삭제하기</button>
        				<button type="button" class="btn btn-outline-primary" onclick="location.href='update?id=${question.id}'">답변수정</button>
        		</c:when>
        	</c:choose>
        </c:forEach>
    </article>

</section>	
<script src="resources/prism/prism.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.js"></script>
</body>

</html>