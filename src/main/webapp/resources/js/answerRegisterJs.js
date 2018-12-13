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
    var widget = document.createElement("DIV");
    widget.setAttribute("style", "margin: 4px 8px;height:30px; background-color: rgb(0, 255, 179);");

    //댓글 위젯 생성
    for (var i = 0; i < commentTextArea.length; i++) {
        if (commentTextArea[i].value != "") {
            var contentText = document.createTextNode(commentTextArea[i].value);
            widget.appendChild(contentText);
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

    var deactivateSelectedLine = document.getElementsByClassName('CodeMirror-activeline');
    for (var i = 0; i < deactivateSelectedLine.length; i++) {
        deactivateSelectedLine[i].removeChild(deactivateSelectedLine[i].childNodes[0]);
    }

    var codes = document.getElementsByClassName('cm-s-default');
    var codesLength = codes.length;
    for (var i = 0; i < codesLength; i++) {
        document.getElementById("postTextArea").value += nodeToString(codes[i]);
    }
};
