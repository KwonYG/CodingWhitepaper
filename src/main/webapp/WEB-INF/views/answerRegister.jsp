<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        body {
					background-color: #eee;
				}
				
		.CodeMirror {
					  border: 1px solid #eee;
					  height: auto;
				}
		
	</style>
</head>

<body>
    <h1>AnswerRegister TEST </h1>

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
                <div id="collapse${status.count}" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading${status.count}">
                    <div class="panel-body">
                        <textarea class="codeMirrorTargetEditor">${code.content}</textarea><br>
                        <textarea name="editor" class="commentEditor" rows="10" cols="100"></textarea><br>
                        <div id="commentBtn" style="background:white;width:150px;padding:8px;cursor:pointer">Add
                            comment</div><br>
                        <br>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <form method="post" action="writeanswer?id=${param.id}">
        <textarea name="content" rows="8" cols="80" id="postTextArea" style="display:none;"></textarea><br>

        <br> <input type="submit" value="등록" id="submitBtn" onclick="parsingContent()"><br>
    </form>

    <form method="post" action="">
        <br>


        <script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.41.0/addon/display/autorefresh.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.41.0/addon/selection/active-line.js"></script>

        <script>
            var cm = {};
            var editors = document.getElementsByClassName("codeMirrorTargetEditor");
            for (var i = 0; i < editors.length; i++) {
                cm[i] = CodeMirror.fromTextArea(editors.item(i), {
                    mode: "text/x-java",
                    styleActiveLine: true,
                    lineNumbers: true,
                    lineWrapping: true,
                    readOnly: true,
                    autoRefresh: true,
                    lineWrapping: true,
                    styleActiveLine: true,
                    styleActiveSelected: true
                });
            }

            // add코멘트 버튼 이벤트 , 이벤트 위임
            var el = document.querySelector(".panel-group");
            el.addEventListener('click', function (evt) {
                if (evt.target.id === "commentBtn") {
                    commentEvent();
                }
            }, false);

            //node를 문자열로 변환
            var nodeToString = function (node) {
                var tmpNode = document.createElement("div");
                tmpNode.appendChild(node.cloneNode(true));
                var str = tmpNode.innerHTML;
                tmpNode = node = null;
                return str;
            }


            // 댓글 등록 이벤트
            var commentEvent = function () {
                var commentTextArea = document.getElementsByClassName('commentEditor');

                // 댓글 위젯 생성
                var widget = document.createElement("DIV"); // Create a <p> element
                widget.setAttribute("style", "margin: 4px 8px;height:30px; background-color: rgb(0, 255, 179);");

                //댓글 위젯 생성
                for (var i = 0; i < commentTextArea.length; i++) {
                    if (commentTextArea[i].value != "") {
                        var contentText = document.createTextNode(commentTextArea[i].value); // Create a text node
                        console.log(contentText)
                        widget.appendChild(contentText); // Append the text to <p>
                        commentTextArea[i].value = "";
                    }
                }

                // 댓글 부착
                for (var i = 0; i < editors.length; i++) {
                    if (cm[i].getCursor().line !== 0) {
                        cm[i].addLineWidget(cm[i].getCursor().line, widget); // 에디터 파싱 해결...
                        cm[i].focus()
                        cm[i].setCursor(0, 0);
                    }
                }
            }

            // Answer 내용 파싱
            var parsingContent = function () {
                var temp = document.createElement("div");
                var postContent = document.createElement("div");

                var codes = document.getElementsByClassName('cm-s-default');
                console.log(codes.length);

                var codesLength = codes.length;
                for (var i = 0; i < codesLength; i++) {
                    document.getElementById("postTextArea").value += nodeToString(codes[i]);
                }
                console.log(document.getElementById("postTextArea").value); // 반드시 클릭해야 파싱이됨. 어떻게 해결할지 고민
                debugger;
                //document.getElementById("postTextArea").value = temp.innerHTML.trim();
            };

        </script>
</body>

</html>