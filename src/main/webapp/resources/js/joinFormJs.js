// 아이디 중복 확인
$(".idCheck").click(function () {
    var query = $("#idInput").val();

    $.ajax({
        url: "idCheck?serviceid=" + query,
        type: "post",
        data: query,
        success: function (data) {

            if (data == 1) {
                $(".result .msg").text("이미 존재하는 아이디입니다.");
                $(".result .msg").attr("style", "color:#f00");
                $("#joinBtn").attr("disabled", "disabled");
            } else {
                $(".result .msg").text("사용 할 수 있는 아이디입니다.");
                $(".result .msg").attr("style", "color:#00f");
                $("#joinBtn").removeAttr("disabled");
            }
        }
    });
});

$("#idInput").keyup(function () {
    $(".result .msg").text("아이디 중복확인 해주세요.");
    $(".result .msg").attr("style", "color:#000");

    $("#joinBtn").attr("disabled", "disabled");

});


// 유효성 검사 결과 메세지
var check = function (standard, what, message) {
    if (standard.test(what.value)) {
        return true;
    }
    alert(message);
    what.value = "";
    what.focus();
    //return false;
}

// 유효성 검사
var validate = function () {
    var idPwStandard = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드 검사 정규식
    var emailStandard = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; // 이메일 검사 정규식

    var id = document.getElementById("idInput");
    var pw = document.getElementById("pwInput");
    var email = document.getElementById("emailInput");

    if (!check(idPwStandard, id, "아이디는 4~12자의 영문 대소문자와 숫자로만 입력")) {
        return false;
    }

    if (!check(idPwStandard, pw, "패스워드는 4~12자의 영문 대소문자와 숫자로만 입력")) {
        return false;
    }

    if (join.pwInput.value != join.pwCheckInput.value) {
        alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
        return false;
    }

    if (!check(emailStandard, email, "적합하지 않은 이메일 형식입니다.")) {
        return false;
    }

    alert("회원가입이 완료되었습니다.");
}