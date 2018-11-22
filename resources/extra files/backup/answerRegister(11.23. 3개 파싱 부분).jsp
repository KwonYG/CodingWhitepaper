<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.css">
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
    <form method="post" action="writeanswer?id=${param.id}">
        name : <input type="text" name="userName"><br>
        email : <input type="text" name="userEmail"><br>

        <c:forEach items="${codes}" var="code">
            <textarea class="codeMirrorTargetEditor">${code.content}</textarea><br>
            <textarea name="editor" class="commentEditor" rows="10" cols="100"></textarea><br>
            <div id="commentBtn" style="background:white;width:150px;padding:8px;cursor:pointer">Add comment</div><br>
            <br>
        </c:forEach>
        <textarea name="content" rows="8" cols="80" id="postTextArea" style="display:none;"></textarea><br>

        <br> <input type="submit" value="등록" id="submitBtn" onclick="parsingContent()"><br>
    </form>
    <br>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.js"></script>
    <script>
    	var cm = {};
    	var editors = document.getElementsByClassName("codeMirrorTargetEditor");
        for(var i = 0; i < editors.length; i++){
        	cm[i] = CodeMirror.fromTextArea(editors.item(i),{
        		mode: "text/x-java",
                lineNumbers: true,
                lineWrapping: true,
                readOnly: true
        	});
        }

        
        // add코멘트 버튼 이벤트 , 이벤트 위임 고려
        var btn = document.getElementById('commentBtn');
        btn.addEventListener('click', function () {
            var commentTextArea = document.getElementsByClassName('commentEditor');

            var widget = document.createElement("DIV"); // Create a <p> element
            widget.setAttribute("style", "margin: 4px 8px;height:30px; background-color: rgb(0, 255, 179);");
            
            for(var i = 0; i < commentTextArea.length; i++){
            	if(commentTextArea[i].value != ""){
            		var contentText = document.createTextNode(commentTextArea[i].value); // Create a text node
                    console.log(contentText)
                    widget.appendChild(contentText); // Append the text to <p>
                    commentTextArea[i].value="";
            	}
            }            
            
            for(var i = 0; i < editors.length; i++){
            	if(cm[i].getCursor().line !== 0){
            		cm[i].addLineWidget(cm[i].getCursor().line, widget); // 에디터 파싱 해결...
            		cm[i].focus()
            		cm[i].setCursor(0,0);
            	}
            }
        });
        
        // Answer 내용 파싱
        var parsingContent = function () {
            var el = document.createElement("div");
            var content = document.getElementsByClassName('cm-s-default');
            
            el.appendChild(content[0]);
            document.getElementById("postTextArea").value = el.innerHTML;
        };

    </script>
</body>

</html>