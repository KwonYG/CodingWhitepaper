// 댓글 템플릿구조 파싱
var replyTemplate = document.querySelector("#reply-template").innerText;
var bindReplies = Handlebars.compile(replyTemplate); //bindReplies는 메서드다.

// 리뷰 템플릿구조 파싱
var reviewTemplate = document.querySelector("#review-template").innerText;
var bindReviews = Handlebars.compile(reviewTemplate);

// GET 리뷰 AJAX
var sendReviewAjax = function (url) {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function () {
        var data = JSON.parse(oReq.responseText);
        console.log(data);
        resultHTML = bindReviews(data);
        console.log(resultHTML);
        document.querySelector('.content_box').insertAdjacentHTML('beforeend', resultHTML);
    });
    oReq.open("GET", url);
    oReq.send();
}

// 리뷰 API 가져오기
var getReviews = function () {
    var urlParams = new URLSearchParams(window.location.search);
    var id = urlParams.get('id');
    console.log(id);
    sendReviewAjax("api/answer/reviewCodes/" + id);
}

// POST 댓글 AJAX
var postReplyAjax = function () {
    $(".reply-write input[type=submit]").click(addAnswer);

    function addAnswer(e) {
        e.preventDefault();
        console.log("clicked!!");

        var queryString = $(".reply-write").serialize();
        console.log("query : " + queryString);

        var replyUrl = $(".reply-write").attr("action");
        console.log("url : " + replyUrl)
        $.ajax({
            type: 'post',
            url: replyUrl,
            data: queryString,
            dataType: 'json',
            error: onError,
            success: onSuccess
        });
    }
    function onError() {

    }
    function onSuccess() {
        var item = document.getElementsByClassName("reply_box");
        item[0].parentNode.removeChild(item[0]);
        getReplies();
    }
}

// GET 댓글 AJAX
var sendReplyAjax = function (url) {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function () {
        var data = JSON.parse(oReq.responseText);
        console.log(data);
        resultHTML = bindReplies(data);
        document.querySelector('.content_box').insertAdjacentHTML('beforeend', resultHTML);

        postReplyAjax();
    });
    oReq.open("GET", url);
    oReq.send();
}

// 댓글 API 불러오기
var getReplies = function () {
    var urlParams = new URLSearchParams(window.location.search);
    var id = urlParams.get('id');
    console.log(id);
    sendReplyAjax("api/answer/replies/" + id);
}

// nav active 함수
var navActivate = function (clickedTarget) {
    var tap = clickedTarget;
    tap.parentNode.setAttribute("class", "nav active");
}

// nav 탭 메뉴 클릭 이벤트
var navTabButton = document.querySelector(".nav-tabs");

navTabButton.addEventListener("click", function (evt) {
    var target;
    document.getElementsByClassName("active")[0].setAttribute("class", "nav");

    if (evt.target.className == "nav-tabs") {
        target = evt.target.firstChild.firstChild;
    } else if (evt.target.className == "nav-item") {
        target = evt.target.firstChild;
    } else if (evt.target.className == "nav") {
        target = evt.target;
    }

    navActivate(target);

    if (target.innerText == "댓글") {
        var item = document.getElementsByClassName("code_box");
        item[0].parentNode.removeChild(item[0]);
        getReplies();
    } else if (target.innerText == "리뷰") {
        var item = document.getElementsByClassName("reply_box");
        item[0].parentNode.removeChild(item[0]);
        getReviews();
    }
});

//최초 실행 함수
getReviews();