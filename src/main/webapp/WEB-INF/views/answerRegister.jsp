<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="resources/css/commonStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        .CodeMirror {
	border: 1px solid #eee;
	height: auto;
}</style>
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
    <section>
        <div class="bord3">
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <c:forEach items="${codes}" var="code" varStatus="status">
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="heading${status.count}">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse${status.count}"
                                    aria-expanded="true" aria-controls="collapse${status.count}">
                                    코드 ${status.count}
                                </a>
                            </h4>
                        </div>
                        <div id="collapse${status.count}" class="panel-collapse collapse in" role="tabpanel"
                            aria-labelledby="heading${status.count}">
                            <div class="panel-body">
                                <textarea class="codeMirrorTargetEditor">${code.content}</textarea><br>
                                <textarea name="editor" class="commentEditor" style="width:100%; height:150px;"></textarea><br>

                                <button type="button" id="commentBtn" class="btn btn-outline-info">Add comment</button><br>
                                <br>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <br>
            <h3>추가 설명 :</h3>
            <div class="bord3_">
                <form method="post" action="writeanswer?id=${param.id}">
                    <textarea name="content" rows="8" cols="80" id="postTextArea" style="display:none;"></textarea><br>
                    <textarea name="subContent" style="width:100%; height:200px;"></textarea><br>
                    <br><button type="submit" id="submitBtn" class="btn btn-outline-info" onclick="parsingContent()">등록</button><br>
                </form>
            </div>
        </div>
    </section>
    <br>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.41.0/addon/display/autorefresh.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.41.0/addon/selection/active-line.js"></script>
    <script src="resources/js/answerRegisterJs.js"></script>
</body>

</html>