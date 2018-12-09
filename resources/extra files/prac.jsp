<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="resources/css/commonStyle.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
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
                <div class="btn-group">
                    <!-- 버튼태그 -->
                    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
                        메뉴버튼
                        <!-- 버튼태그 우측 메뉴출력을 위한 화살표표시
        (없어도 무관하나 메뉴버튼이라는것을 알려주기 위함) -->
                        <span class="caret"></span>
                    </button>
                    <!--메뉴버튼 클릭시 하단 표출된 리스트 영역  -->
                    <ul class="dropdown-menu">
                        <!-- 메뉴1 -->
                        <li><a href="#">메뉴1</a></li>
                        <!-- 메뉴2 -->
                        <li><a href="#">메뉴2</a></li>
                    </ul>
                </div>


                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" id="menu1" type="button" data-toggle="dropdown">${sessionScope.userServiceId}
                        님
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">HTML</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">CSS</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">JavaScript</a></li>
                        <li role="presentation" class="divider"></li>
                        <li role="presentation"><a href="logOut" role="menuitem" tabindex="-1">${sessionScope.userServiceId}
                                님</a></li>
                    </ul>
                </div>
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

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script>$('.dropdown-toggle').dropdown();</script>
</body>

</html>