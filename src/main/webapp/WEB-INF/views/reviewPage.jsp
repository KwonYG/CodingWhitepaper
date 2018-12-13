<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="ko">

<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    
    <link rel="stylesheet" type="text/css" href="resources/css/qnaStyle.css">
    <link rel="stylesheet" href="resources/css/reviewPage/reviewPageCss.css">
</head>

<body>
    <center>
        <nav>
            <ul class="nav justify-content-center" style="font-size: 20px; margin: 10px 10px 10px 27px;">
                <li class="nav-item">
                    <a class="nav-link" href="list">MAIN</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="list">Q&A</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">OTHER</a>
                </li>
            </ul>
        </nav>
        <hr>

        <div class="jumbotron" style="background-color: white; width: 1000px; position:center;  border: solid 2px;">
            <ul class="nav nav-tabs">
                <li class="nav-item" style="font-size: 50px; position: relative; left: 10%;">
                    <a class="nav active" style=" padding: 10px 100px">리뷰</a>
                <li class="nav-item" style="font-size: 50px; position: relative; left: 20%;">
                    <a class="nav" style=" padding: 10px 100px">댓글</a>
                </li>
            </ul>

            <section>
                <article>
                    <div class="content_box">

                    </div>
                </article>
            </section>
        </div>
    </center>


    <script type="teplate" id="review-template">
        <div class="code_box">
			{{#if reviewCodes}} 
				{{#each reviewCodes}}
					<h3 style="text-align: left;">code 1 :</h3>
					{{{content}}}
				{{/each}}	
			{{/if}}
			<br>
			<div class="sub_content_box">
			<h5>추가 설명 :</h5>
			<div style="border : dotted 1px black; padding:20px;">
				{{answer.subContent}}
			</div>
		</div>
	</script>

    <script type="template" id="reply-template">
<div class="reply_box">
	<c:choose>
   		<c:when test="${sessionScope.isUser == 'true'}">
		<div class="reply_editor_box">
			<form class="reply-write" method="post" action="api/answer/writeReply?id={{answerId}}">
				<textarea name="content" class="form-control" rows="5" placeholder="댓글을 입력하세요"></textarea>
				<input type="submit" class="btn btn-outline-primary" style="margin:10px;" value="등록">
        	</form>
    		</div>
		</c:when>
    </c:choose>

	<div class="reply_wrap">
        {{#if answerReplies}} {{#each answerReplies}} 
            <div class="bord1 review_reply">
                    <div style="font-size: 14px">
                        <img src="resources/img/person1.png">
                        {{userName}}<br>
                        {{createDate}}
                    </div>
                    <hr>
                    <div>{{content}}</div>
                </div>
                <br>
        {{/each}} {{/if}}
	</div>
</div>
      </script>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="resources/js/reviewPageJs.js"></script>
</body>
</html>