<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="ko">

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <style>
        .active {
            background: lightgrey;
            color: #000;
        }

        .nav-link {
            color: black;
        }

        article {
            padding: 15px 20px;
            text-align: left;
            border-radius: 3px;
        }

        div {
            line-height: 200%;
        }

        img {
            float: left;
            margin: 0px 11px 0px 5px;
        }

        .main {
            line-height: 260%;
            padding: 0px 30px;
            color: #000;
        }


        .bord1 {
            border: 1.5px solid #289AFF;
            padding: 20px;
        }
    </style>
</head>

<body>
    <center>
        <nav>
            <ul class="nav justify-content-center" style="font-size: 20px; margin: 10px 10px 10px 27px;">
                <li class="nav-item">
                    <a class="nav-link" href="#">MAIN</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Q&A</a>
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
                    <a href="#" class="nav active" style=" padding: 10px 100px">review</a>
                <li class="nav-item" style="font-size: 50px; position: relative; left: 20%;">
                    <a class=" main " href="#" style=" padding: 10px 100px">댓글</a>
                </li>
            </ul>

            <section>
                <article>

                </article>
            </section>
        </div>
    </center>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>