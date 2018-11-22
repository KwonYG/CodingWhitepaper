<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
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

	<c:forEach items="${codes}" var="code" varStatus="status">
		<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal${status.count}" style="margin:10px;">
			CODE ${status.count}
		</button><br>
	</c:forEach>

	<c:forEach items="${codes}" var="code" varStatus="status">
		<div class="modal fade" id="myModal${status.count}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		 aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Modal title</h4>
					</div>
					<div class="modal-body">

						<textarea class="codeMirrorTargetEditor">${code.content}</textarea><br>
						<textarea name="editor" class="commentEditor" rows="10" cols="100"></textarea><br>
						<div id="commentBtn" style="background:white;width:150px;padding:8px;cursor:pointer">Add comment</div><br><br>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save changes</button>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<form method="post" action="writeanswer?id=${param.id}">
		name : <input type="text" name="userName"><br>
		email : <input type="text" name="userEmail"><br>
		<br> <input type="submit" value="등록" id="submitBtn" onclick="parsingContent()"><br>
		<textarea name="content" rows="8" cols="80" id="postTextArea" style="display:none;"></textarea>
	</form>

	<br>

	<!-- js -->
	<script src="resources/js/vendor/jquery.min.js"></script>
	<script src="resources/js/transition.js"></script>
	<script src="resources/js/modal.js"></script>
	<script src="resources/js/tooltip.js"></script>
	<script src="resources/js/popover.js"></script>
	<script src="resources/js/collapse.js"></script>


	<script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.40.2/codemirror.js"></script>
	<script>
		var cm = {};
		var editors = document.getElementsByClassName("codeMirrorTargetEditor");
		for (var i = 0; i < editors.length; i++) {
			cm[i] = CodeMirror.fromTextArea(editors.item(i), {
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

			for (var i = 0; i < commentTextArea.length; i++) {
				if (commentTextArea[i].value != "") {
					var contentText = document.createTextNode(commentTextArea[i].value); // Create a text node
					console.log(contentText)
					widget.appendChild(contentText); // Append the text to <p>
					commentTextArea[i].value = "";
				}
			}

			for (var i = 0; i < editors.length; i++) {
				if (cm[i].getCursor().line !== 0) {
					cm[i].addLineWidget(cm[i].getCursor().line, widget); // 에디터 파싱 해결...
					cm[i].focus()
					cm[i].setCursor(0, 0);
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
	<script>
		var firefoxTestDone = false

		function reportFirefoxTestResult(result) {
			if (!firefoxTestDone) {
				$('#ff-bug-test-result')
					.addClass(result ? 'text-success' : 'text-danger')
					.text(result ? 'PASS' : 'FAIL')
			}
			firefoxTestDone = true
		}

		$(function () {
			$('.js-popover').popover()
			$('.js-tooltip').tooltip()
			$('#tall-toggle').click(function () {
				$('#tall').toggle()
			})
			$('#ff-bug-input').one('focus', function () {
				$('#myModal2').on('focus', function () {
					reportFirefoxTestResult(false)
				})
				$('#ff-bug-input').on('focus', function () {
					reportFirefoxTestResult(true)
				})
			})
		})
	</script>
</body>

</html>