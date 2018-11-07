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
			</style>
		</head>

		<body>
			<h1>AnswerRegister TEST </h1>
			<form method="post" action="writeanswer?id=${param.id}">
				name : <input type="text" name="userName"><br> 
				email : <input type="text" name="userEmail"><br>
				
				<c:forEach items="${codes}" var="code">
					<textarea name="content" rows="8" cols="80" id="CodeMirrorEditor">${code.content}
					</textarea>
				</c:forEach>
				<br> <input type="submit" value="등록">
			</form>
				<br>
				<textarea name="editor" id="commentEditor" rows="30" cols="100"></textarea>
				<br>
				<button id="commentBtn">Add comment</button>
			

			<script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.js"></script>
			<script>
				var editor = CodeMirror.fromTextArea(document.getElementById("CodeMirrorEditor"), {
					mode: "text/x-java",
					lineNumbers: true
				});


				var btn = document.getElementById('commentBtn');
				btn.addEventListener('click', function() {
					var textArea = document.getElementById('commentEditor');
					var para = document.createElement("DIV"); // Create a <p> element
					para.setAttribute("style", "margin: 4px 8px;height:30px; background-color: rgb(0, 255, 179);");
					var t = document.createTextNode(textArea.value); // Create a text node
					para.appendChild(t); // Append the text to <p>
					editor.addLineWidget(editor.getCursor().line, para);
					document.getElementById("CodeMirrorEditor").value = editor.getValue(); // 될까?
				});
			</script>
		</body>

		</html>
