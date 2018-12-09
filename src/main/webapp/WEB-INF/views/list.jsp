<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="resources/css/commonStyle.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Title</title>
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
        			<div class="login"><button type="button" class="btn btn-light" onclick="location.href='logOut'">LOGOUT</button></div>
        		</c:when>
        		<c:otherwise>
        			<div class="login"><button type="button" class="btn btn-light" onclick="location.href='loginForm'">LOGIN</button></div>
        		</c:otherwise>
        </c:choose>
    </header>
    
    <hr class="mg0">

    <!--<div style="background-color: dodgerblue"><br><br><br><br><br><br><br><br></div>-->
    <img src="resources/img/main1.jpg" class="mainImg">

    <section>
      <c:forEach items="${questionList}" var="question">
      	<article>
            <table class="center">
                <tr rowspan="2">
                    <th rowspan="2"><a href="question?id=${question.id}">${question.title}</a></th>
                    <td> ${question.userName} </td>
                </tr>
                <tr>
                    <td> ${question.createDate} </td>
                </tr>
            </table>
        </article>
        </c:forEach>

        <div class="right"><a class="btn btn-outline-secondary" href="qregister">글쓰기</a></div>

        <div class="text-center">
            <ul class="pagination justify-content-center">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>
                <c:forEach items="${pageStartList}" var="pageIndex" varStatus="status">
                <li class="page-item"><a class="page-link" href="list?start=${pageIndex}">${status.index + 1}</a></li>
                </c:forEach>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>
            </ul>
        </div>
    </section>

    <footer>
        <br>
        경성대학교 소프트웨어학과<br>
        2018-2 프로젝트수업 성낙운교수님<br>
        [TED] 권영근 정영훈 황선혜
    </footer>
</body>
</html>