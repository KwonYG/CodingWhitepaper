<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>QNA</title>
    <link rel="stylesheet" type="text/css" href="resources/css/commonStyle.css">
    <link rel="stylesheet" type="text/css" href="resources/css/rankStyle.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <style>
        #content {
            border: 3px solid black;
            position: relative;
        }
    </style>
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
        <h2>Ranking</h2>
        <article>
            <div class="winner">
                <div style="font-size: 14px">
                    <img src="resources/img/person1.png">
                    ${winner.serviceId}<br>
                    ${winner.name}
                </div>
                <h3>답변 수 : <b>${winner.answerCount} 개</b></h3>
            </div>

            <c:forEach items="${secondToThird}" var="semiWinner">
                <div class="bord1">
                    <div style="font-size: 14px">
                        <img src="resources/img/person1.png">
                        ${semiWinner.serviceId }<br>
                        ${semiWinner.name }
                    </div>
                    <h3>답변 수 : <b>${semiWinner.answerCount } 개</b></h3>
                </div>
            </c:forEach>

            <c:forEach items="${restRankers}" var="rest">
                <div class="bord2">
                    <div style="font-size: 14px">
                        <img src="resources/img/person1.png">
                        ${rest.serviceId }<br>
                        ${rest.name }
                    </div>
                    <h5>답변 수 : <b>${rest.answerCount} 개</b></h5>
                </div>
            </c:forEach>

        </article>

    </section>
</body>

</html>