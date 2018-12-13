<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<body>
    <h1>회원가입</h1>
    <hr>
    <div class="container">
        <form name="join" method="post" onsubmit="return validate();" action="join" class="form-horizontal">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">ID</label>
                <div class="col-sm-10">
                    <input id="idInput" class="form-control" type="text" name="serviceId" placeholder="사용자 아이디"
                        required>
                    <input type="button" class="idCheck" value="중복 체크">
                    <p class="result">
                        <span class="msg">아이디를 확인하여 주십시오.</span>
                    </p>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <input id="pwInput" class="form-control" type="password" name="password" placeholder="사용자 비밀번호"
                        required>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Password 확인</label>
                <div class="col-sm-10">
                    <input id="pwCheckInput" class="form-control" type="password" placeholder="사용자 비밀번호 확인" required>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">name</label>
                <div class="col-sm-10">
                    <input id="nameInput" class="form-control" type="text" name="name" placeholder="사용자 이름" required>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">email</label>
                <div class="col-sm-10">
                    <input id="emailInput" class="form-control" type="text" name="email" placeholder="사용자 이메일" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button id="joinBtn" type="submit" class="btn btn-default" disabled="disabled">Join</button>
                </div>
            </div>
        </form>
    </div>
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script>
        $(".idCheck").click(function () {
            var query = $("#idInput").val();

            $.ajax({
                url: "idCheck?serviceid=" + query,
                type: "post",
                data: query,
                success: function (data) {

                    if (data == 1) {
                        $(".result .msg").text("사용 불가");
                        $(".result .msg").attr("style", "color:#f00");
                        $("#joinBtn").attr("disabled", "disabled");
                    } else {
                        $(".result .msg").text("사용 가능");
                        $(".result .msg").attr("style", "color:#00f");
                        $("#joinBtn").removeAttr("disabled");
                    }
                }
            });  // ajax 끝
        });

        $("#idInput").keyup(function () {
            $(".result .msg").text("아이디를 확인해주십시오.");
            $(".result .msg").attr("style", "color:#000");

            $("#joinBtn").attr("disabled", "disabled");

        });

        var check = function (standard, what, message) {
            if (standard.test(what.value)) {
                return true;
            }
            alert(message);
            what.value = "";
            what.focus();
            //return false;
        }

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
    </script>
</body>

</html>