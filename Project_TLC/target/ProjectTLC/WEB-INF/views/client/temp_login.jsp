<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>WnW</title>
    
    <!-- Bootstrap CSS -->
    <!--        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"> -->
    
    <!-- let's add tag srping:url -->
    <spring:url value="/resources/assets/css/" var="css"></spring:url>
    <spring:url value="/resources/assets/js/" var="js"></spring:url>
    <spring:url value="/resources/images/" var="images"></spring:url>
    <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
    <!-- Finish adding tags -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet" />
    <link href="${css}/main.css" rel="stylesheet" />
    <link href="${css}/custom-bootstrap.css" rel="stylesheet" />
    <link rel="shortcut icon" href="${images}/lg1.png" type="image/x-icon"/>
    <link href='https://fonts.googleapis.com/css?family=Alice' rel='stylesheet' type='text/css'>
    <style type="text/css">
            /*@import url(http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css);*/
            body {
              background: url('${images}/bglogin.jpg') fixed;
              background-size: cover;
              padding: 0;
              margin: 0;
            }

            .wrap {
              width: 100%;
              height: 100%;
              min-height: 100%;
              position: absolute;
              top: 105px;
              left: 0;
              /*z-index: 99;*/
              margin: 0 auto;
            }

            p.form-title {
              font-family: 'Open Sans' , sans-serif;
              font-size: 20px;
              font-weight: 600;
              text-align: center;
              color: #FFFFFF;
              margin-top: 10%;
              text-transform: uppercase;
              letter-spacing: 4px;
            }

            form {
              width: 250px;
              margin: 0 auto;
              /*margin-top: 10%;*/
            }

            form.login input[type="email"], form.login input[type="password"] {
              width: 100%;
              margin: 0;
              padding: 5px 10px;
              background: 0;
              border: 0;
              border-bottom: 1px solid #FFFFFF;
              outline: 0;
              font-style: italic;
              font-size: 12px;
              font-weight: 400;
              letter-spacing: 1px;
              margin-bottom: 5px;
              color: #FFFFFF;
              outline: 0;
            }

            form.login input[type="submit"] {
              width: 100%;
              font-size: 14px;
              text-transform: uppercase;
              font-weight: 500;
              margin-top: 16px;
              outline: 0;
              cursor: pointer;
              letter-spacing: 1px;
            }

            form.login input[type="submit"]:hover {
              transition: background-color 0.5s ease;
            }

            form.login .remember-forgot {
              float: left;
              width: 100%;
              margin: 10px 0 0 0;
            }

            form.login .forgot-pass-content {
              min-height: 20px;
              margin-top: 10px;
              margin-bottom: 10px;
            }

            form.login label, form.login a {
              font-size: 12px;
              font-weight: 400;
              color: #FFFFFF;
            }

            form.login a {
              transition: color 0.5s ease;
            }

            form.login a:hover {
              color: #2ecc71;
            }

            .pr-wrap {
              width: 100%;
              height: 100%;
              min-height: 100%;
              position: absolute;
              top: 0;
              left: 0;
              z-index: 999;
              display: none;
            }

            .show-pass-reset {
              display: block !important;
            }

            .pass-reset {
              margin: 0 auto;
              width: 250px;
              position: relative;
              margin-top: 30%;
              z-index: 999;
              background: #FFFFFF;
              padding: 20px 15px;
            }

            .pass-reset label {
              font-size: 12px;
              font-weight: 400;
              margin-bottom: 15px;
            }

            /*.pass-reset input[type="email"] {*/
              /*width: 100%;*/
              /*margin: 5px 0 0 0;*/
              /*padding: 5px 10px;*/
              /*background: 0;*/
              /*border: 0;*/
              /*border-bottom: 1px solid #000000;*/
              /*outline: 0;*/
              /*font-style: italic;*/
              /*font-size: 12px;*/
              /*font-weight: 400;*/
              /*letter-spacing: 1px;*/
              /*margin-bottom: 5px;*/
              /*color: #000000;*/
              /*outline: 0;*/
            /*}*/

            .pass-reset input[type="submit"] {
              width: 100%;
              border: 0;
              font-size: 14px;
              text-transform: uppercase;
              font-weight: 500;
              margin-top: 10px;
              outline: 0;
              cursor: pointer;
              letter-spacing: 1px;
            }

            .pass-reset input[type="submit"]:hover {
              transition: background-color 0.5s ease;
            }

            .posted-by {
              position: absolute;
              bottom: 26px;
              margin: 0 auto;
              color: #FFF;
              background-color: rgba(0, 0, 0, 0.66);
              padding: 10px;
              left: 45%;
            }
            /*CSS FOR INTRO HOW IT WORK*/

            /*@import url(http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700);*/
            /* written by riliwan balogun http://www.facebook.com/riliwan.rabo*/
            .board{
                width: 100%;
                margin: 0px auto;
                height: 500px;
                background: #fff;
                /*box-shadow: 10px 10px #ccc,-10px 20px #ddd;*/
            }
            .board .nav-tabs {
                position: relative;
                /* border-bottom: 0; */
                /* width: 80%; */
                margin: 40px auto;
                margin-bottom: 0;
                box-sizing: border-box;

            }

            .board > div.board-inner{
                background: #fafafa url(http://subtlepatterns.com/patterns/geometry2.png);
                background-size: 30%;
            }

            p.narrow{
                width: 60%;
                margin: 10px auto;
            }

            .liner{
                height: 2px;
                background: #ddd;
                position: absolute;
                width: 80%;
                margin: 0 auto;
                left: 0;
                right: 0;
                top: 50%;
                z-index: 1;
            }

            .nav-tabs > li.active > a, .nav-tabs > li.active > a:hover, .nav-tabs > li.active > a:focus {
                color: #555555;
                cursor: default;
                /* background-color: #ffffff; */
                border: 0;
                border-bottom-color: transparent;
            }

            span.round-tabs{
                width: 70px;
                height: 70px;
                line-height: 70px;
                display: inline-block;
                border-radius: 100px;
                background: white;
                z-index: 2;
                position: absolute;
                left: 0;
                text-align: center;
                font-size: 25px;
            }

            span.round-tabs.one{
                color: rgb(34, 194, 34);border: 2px solid rgb(34, 194, 34);
            }

            li.active span.round-tabs.one{
                background: #fff !important;
                border: 2px solid #ddd;
                color: rgb(34, 194, 34);
            }

            span.round-tabs.two{
                color: #febe29;border: 2px solid #febe29;
            }

            li.active span.round-tabs.two{
                background: #fff !important;
                border: 2px solid #ddd;
                color: #febe29;
            }

            span.round-tabs.three{
                color: #3e5e9a;border: 2px solid #3e5e9a;
            }

            li.active span.round-tabs.three{
                background: #fff !important;
                border: 2px solid #ddd;
                color: #3e5e9a;
            }

            span.round-tabs.four{
                color: #f1685e;border: 2px solid #f1685e;
            }

            li.active span.round-tabs.four{
                background: #fff !important;
                border: 2px solid #ddd;
                color: #f1685e;
            }

            span.round-tabs.five{
                color: #999;border: 2px solid #999;
            }

            li.active span.round-tabs.five{
                background: #fff !important;
                border: 2px solid #ddd;
                color: #999;
            }

            .nav-tabs > li.active > a span.round-tabs{
                background: #fafafa;
            }
            .nav-tabs > li {
                width: 20%;
            }
            /*li.active:before {
                content: " ";
                position: absolute;
                left: 45%;
                opacity:0;
                margin: 0 auto;
                bottom: -2px;
                border: 10px solid transparent;
                border-bottom-color: #fff;
                z-index: 1;
                transition:0.2s ease-in-out;
            }*/
            li:after {
                content: " ";
                position: absolute;
                left: 45%;
                opacity:0;
                margin: 0 auto;
                bottom: 0px;
                border: 5px solid transparent;
                border-bottom-color: #ddd;
                transition:0.1s ease-in-out;

            }
            li.active:after {
                content: " ";
                position: absolute;
                left: 45%;
                opacity:1;
                margin: 0 auto;
                bottom: 0px;
                border: 10px solid transparent;
                border-bottom-color: #ddd;

            }
            .nav-tabs > li a{
                width: 70px;
                height: 70px;
                margin: 20px auto;
                border-radius: 100%;
                padding: 0;
            }

            .nav-tabs > li a:hover{
                background: transparent;
            }

            .tab-content{
            }
            .tab-pane{
                position: relative;
                padding-top: 50px;
            }
            .tab-content .head{
                font-family: 'Roboto Condensed', sans-serif;
                font-size: 25px;
                text-transform: uppercase;
                padding-bottom: 10px;
            }
            .btn-outline-rounded{
                padding: 10px 40px;
                margin: 5px 0;
                border: 2px solid transparent;
                border-radius: 25px;
            }

            .btn.green{
                background-color:#5cb85c;
                /*border: 2px solid #5cb85c;*/
                color: #ffffff;
            }


            @media( max-width : 585px ){
            {
            .board
            width: 90%;
                height:auto !important;
            }
                span.round-tabs {
                    font-size:16px;
                    width: 50px;
                    height: 50px;
                    line-height: 50px;
                }
                .tab-content .head{
                    font-size:20px;
                }
                .nav-tabs > li a {
                    width: 50px;
                    height: 50px;
                    line-height:50px;
                }

                li.active:after {
                    content: " ";
                    position: absolute;
                    left: 35%;
                }

                .btn-outline-rounded {
                    padding:12px 20px;
                }
            }
        </style> 
        <%--<script type="text/javascript">--%>
            <%--$(document).ready(function () {--%>
                <%--$('.forgot-pass').click(function(event) {--%>
                  <%--$(".pr-wrap").toggleClass("show-pass-reset");--%>
                <%--}); --%>
                <%--$('.pass-reset-submit').click(function(event) {--%>
                  <%--$(".pr-wrap").removeClass("show-pass-reset");--%>
                <%--}); --%>
            <%--});--%>
        <%--</script>   --%>
</head>
<body style="font-family: 'Alice', serif;">
    <!-- Header -->
    <nav id="header" class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <h1 id="logo"><a class="navbar-brand page-scroll" href="/"><img style="height: 45px; margin-top: -7px;" src="${images}/lg1.png"></a></h1>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right ">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#"data-toggle="modal" data-target="#introModal">Giới thiệu</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="/login">Đăng nhập</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="/signup">Đăng ký</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="pr-wrap">
                    <%--<form action="/checklogin" method="POST">--%>
                        <%--<div class="pass-reset">--%>
                            <%--<label>Enter the email you signed up with</label>--%>
                            <%--<input type="email" placeholder="Email" />--%>
                            <%--<input type="submit" value="Submit" class="pass-reset-submit btn btn-success btn-sm" />--%>
                        <%--</div>--%>
                    <%--</form>--%>
                </div>
                
                <div class="wrap">
                    <p class="form-title">Đăng nhập</p>
                    <form action="/checklogin" method="POST" class="login">
                        <input type="email" name="email" placeholder="Email" required="true" />
                        <input type="password" name="password" placeholder="Mật khẩu" required="true" />
                        <input type="submit" value="Sign In" class="btn btn-default btn-sm" />
                        <div class="remember-forgot">
                            <div class="row">
                                <div class="col-xs-6">
                                    <%--<div class="checkbox">--%>
                                        <%--<label>--%>
                                            <%--<input type="checkbox" />--%>
                                            <%--Remember Me--%>
                                        <%--</label>--%>
                                    <%--</div>--%>
                                </div>
                                <div class="col-xs-6 forgot-pass-content">
                                    <a href="javascription:void(0)" class="forgot-pass">Quên mật khẩu</a>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <c:if test="${not empty msgsuccess}">
                    <div style="margin-top: 100px;" class="alert alert-success">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        ${msgsuccess}

                    </div>
                </c:if>
                <c:if test="${not empty msgerror}">
                    <div style="margin-top: 100px;" class="alert alert-danger">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        ${msgerror}
                    </div>
                </c:if>
                <c:if test="${not empty msginfo}">
                    <div style="margin-top: 100px;" class="alert alert-info">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        ${msginfo}
                    </div>
                </c:if>
                <%
                    if (request.getParameter("msgerror") != null) { %>
                        <div style="margin-top: 100px;" class="alert alert-danger">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <%= request.getParameter("msgerror").toString().replaceAll("\\<.*?>","") %>
                        </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>

    <%--HOW IT WORK--%>
    <div style="z-index: 99999" class="modal fade" id="introModal" role="dialog">
        <div class="modal-dialog modal-lg">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
                    <h4 class="modal-title">Hướng dẫn</h4>
                </div>
                <div style="padding: 0;" class="modal-body">
                    <%--<div class="row">--%>
                    <div class="board">
                        <!-- <h2>Welcome to IGHALO!<sup>™</sup></h2>-->
                        <div class="board-inner">
                            <ul class="nav nav-tabs" id="myTab">
                                <div class="liner"></div>
                                <li class="active">
                                    <a href="#home" data-toggle="tab" title="welcome">
                                        <span class="round-tabs one">
                                            <i class="glyphicon glyphicon-home"></i>
                                        </span>
                                    </a>
                                </li>

                                <li class="disabled">
                                    <a href="#profile" data-toggle="tab" title="find places and groups travel">
                                        <span class="round-tabs two">
                                          <i class="glyphicon glyphicon-search"></i>
                                        </span>
                                    </a>
                                </li>
                                <li class="disabled">
                                    <a href="#messages" data-toggle="tab" title="send messages about group travel">
                                        <span class="round-tabs three">
                                            <i class="glyphicon glyphicon-comment"></i>
                                        </span>
                                    </a>
                                </li>

                                <li class="disabled">
                                    <a href="#settings" data-toggle="tab" title="ask or accept to participarte gr travel">
                                        <span class="round-tabs four">
                                            <i class="glyphicon glyphicon-thumbs-up"></i>
                                        </span>
                                    </a>
                                </li>

                                <li class="disabled">
                                    <a href="#doner" data-toggle="tab" title="Ok ! Let's go with new friends explore the word !">
                                        <span class="round-tabs five">
                                            <i class="glyphicon glyphicon-plane"></i>
                                        </span>
                                    </a>
                                </li>

                            </ul>
                        </div>

                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="home">

                                <h3 class="head text-center">Welcome to WnW<sup>™</sup> <span style="color:#f48260;">♥</span></h3>
                                <%--<div class="row">--%>
                                <p>Bạn đang phân vân không biết đi đâu cùng với ai và vào khi nào ?</p>
                                <p>Chào mừng bạn đã đến với chúng tôi ! Mọi thứ sẽ trở nên đơn gian hơn.</p>
                                <p>Hãy cùng trải nghiệm những chuyến du lịch vui chơi với những người bạn mới nhé !</p>
                                <p>Hãy làm theo hướng dẫn của chúng tôi nhé. </p>
                                <%--</div>--%>

                                <form class="form-horizontal text-center" id="home_form" name="home_form" role="form">
                                    <fieldset>
                                        <button type="submit" href="#profile" name="home_form" class="btn-submit btn btn-success btn-outline-rounded green"> Next tab <span style="margin-left:10px;" class="glyphicon glyphicon-send"></span></button>
                                    </fieldset>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="profile">
                                <h3 class="head text-center">Tìm kiếm những địa điểm và topic </h3>
                                <div class="row">
                                    <div class="col-md-6">
                                        <img style="height: 210px; width: 300px;" src="${images}/events-and-activities.jpg" alt="">
                                    </div>
                                    <div class="col-md-6">
                                        <h6 class="text-left">
                                            <p>Bạn tìm kiếm 1 topic nào đó trong danh sách.</p>
                                            <p>Hoặc bạn có thể chọn nó trong danh sách địa điểm bạn muốn.</p>
                                        </h6>
                                    </div>
                                </div>

                                <form class="form-horizontal text-center" id="profile_form" name="profile_form" role="form">
                                    <fieldset>
                                        <button type="submit" href="#messages" name="profile_form" class="btn-submit btn btn-success btn-outline-rounded green"> Next tab <span style="margin-left:10px;" class="glyphicon glyphicon-send"></span></button>
                                    </fieldset>
                                </form>

                            </div>
                            <div class="tab-pane fade" id="messages">
                                <h3 class="head text-center">Liên hệ vào bình luận về nhóm</h3>
                                <div class="row">
                                    <div class="col-md-6">
                                        <img style="height: 210px; width: 300px;" src="${images}/conversation.jpeg" alt="">
                                    </div>
                                    <div class="col-md-6">
                                        <h6 class="text-left">
                                            <p>Cùng mọi người thảo luận về topic và liên lạc với chủ topic để biết thêm và yêu cầu tham gia nhé.</p>
                                            <p>Và hay click tham gia nếu bạn thích nhé !</p>
                                        </h6>
                                    </div>
                                </div>

                                <form class="form-horizontal text-center" id="messages_form" name="messages_form" role="form">
                                    <fieldset>
                                        <button type="submit" href="#settings" name="messages_form" class="btn-submit btn btn-success btn-outline-rounded green"> Next tab <span style="margin-left:10px;" class="glyphicon glyphicon-send"></span></button>
                                    </fieldset>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="settings">
                                <h3 class="head text-center">Chấp nhận !</h3>
                                <div class="row">
                                    <div class="col-md-6">
                                        <img style="height: 210px; width: 300px;" src="${images}/businessman-shake-hand-vector-1544967.jpg" alt="">
                                    </div>
                                    <div class="col-md-6">
                                        <h6 class="text-left">
                                            <p>Chấp nhận lời yêu cầu tham gia và nhóm của những thành viên khác vào topic của bạn.</p>
                                            <p>Hãy liên lạc với họ để cùng bàn về chuyến đi nhé !</p>
                                        </h6>
                                    </div>
                                </div>

                                <form class="form-horizontal text-center" id="settings_form" name="settings_form" role="form">
                                    <fieldset>
                                        <button type="submit" href="#doner" name="settings_form" class="btn-submit btn btn-success btn-outline-rounded green"> Next tab <span style="margin-left:10px;" class="glyphicon glyphicon-send"></span>
                                        </button>
                                    </fieldset>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="doner">
                                <div class="text-center">
                                    <i class="img-intro icon-checkmark-circle"></i>
                                </div>
                                <h3 class="head text-center">Let's go Now<span style="color:#f48260;">♥</span> </h3>
                                <div class="row">
                                    <div class="col-md-6">
                                        <img style="height: 210px; width: 300px;" src="${images}/rocket-space-travel-cartoon-illustration-art-57556431.jpg" alt="">
                                    </div>
                                    <div class="col-md-6">
                                        <h6 class="text-left">
                                            <p>Còn chờ gì nữa ngoài việc cùng nhau sách ba lô lên và đi !</p>
                                            <p>LET'S GOOOOOOOOOOOO....!</p>
                                        </h6>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <%--</div>--%>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/jquery.poptrox.min.js"></script>
    <script src="${js}/jquery.scrolly.min.js"></script>
    <script src="${js}/jquery.scrollex.min.js"></script>
    <script src="${js}/skel.min.js"></script>
    <script src="${js}/util.js"></script>
    <script src="${js}/main.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script src="${js}/howitwork.js"></script>
    <script>
        // tooltip demo
        $('.tooltip-demo').tooltip({
            selector: "[data-toggle=tooltip]",
            container: "body"
        })

        // popover demo
        $("[data-toggle=popover]")
                .popover()
    </script>
</body>
</html>