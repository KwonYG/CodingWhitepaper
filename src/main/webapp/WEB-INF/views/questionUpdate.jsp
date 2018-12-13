<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="resources/css/commonStyle.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>Insert title here</title>
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
                <div class="login"><button type="button" class="btn btn-light" onclick="location.href='logOut'">${sessionScope.userServiceId}님
                        LOGOUT</button></div>
            </c:when>
            <c:otherwise>
                <div class="login"><button type="button" class="btn btn-light" onclick="location.href='loginForm'">LOGIN</button></div>
            </c:otherwise>
        </c:choose>
    </header>

    <hr class="mg0">


    <div class="bord3 form-container" style="margin:10px;">
        <form method="post" action="postUpdate?id=${question.id}">
            <div class="form-group">
                <label for="InputTitle">TITLE</label>
                <input type="text" name="title" class="form-control" id="titleInput" placeholder="제목을 입력하세요" value="${question.title}"
                    required>
            </div>
            <textarea name="content" id="content" cols="60" rows="6" required>${question.content}</textarea>
            <br>
            <button type="submit" class="btn btn-outline-info">등록</button>
        </form>
    </div>

    <script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
    <script>
        CKEDITOR.replace('content');
    </script>
</body>

</html>