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
					<textarea id="CodeMirrorEditor">${code.content}
					</textarea>
				</c:forEach>
				<br> <input type="submit" value="등록" id="submitBtn" onclick="parsingContent()"><br>
				<textarea name="content" rows="8" cols="80" id="postTextArea" style="display:none;"></textarea>
			</form>
				<br>
				<textarea name="editor" id="commentEditor" rows="10" cols="100"></textarea>
				<br>
				<button id="commentBtn">Add comment</button><br>
				
			

			<script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.js"></script>
			<script>
				var editor = CodeMirror.fromTextArea(document.getElementById("CodeMirrorEditor"), {
					mode: "text/x-java",
					lineNumbers: true,
					readOnly: true
				});

				var btn = document.getElementById('commentBtn');
				btn.addEventListener('click', function() {
					var textArea = document.getElementById('commentEditor');
					
					var widget = document.createElement("DIV"); // Create a <p> element
					widget.setAttribute("style", "margin: 4px 8px;height:30px; background-color: rgb(0, 255, 179);");
					
					var t = document.createTextNode(textArea.value); // Create a text node
					console.log(t)
					widget.appendChild(t); // Append the text to <p>
					editor.addLineWidget(editor.getCursor().line, widget);
				});
				
				var parsingContent = function(){
					var el = document.createElement("div");
					
					var content = document.getElementsByClassName('cm-s-default');
					
					el.appendChild(content[0]);
					
					document.getElementById("postTextArea").value = el.innerHTML;
					console.log(content[0]);
					debugger;
					console.log(document.getElementById("postTextArea").value);
					debugger;
				};
				
				/* var submitBtn = document.getElementById('submitBtn');
				submitBtn.addEventListener('click', function() {
					parsingContent();
				}); */
				
				
			</script>
		</body>

		</html>
