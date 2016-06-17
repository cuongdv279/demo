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
    <spring:url value="/resources/assets/css/bootstrap.min.css" var="boostrapcss"></spring:url>
    <spring:url value="/resources/assets/css/admin-style.css" var="admincss"></spring:url>
    <spring:url value="/resources/assets/css/messageCss.css" var="messagecss"></spring:url>
    <spring:url value="/resources/assets/js/" var="js"></spring:url>
    <spring:url value="/resources/images/" var="images"></spring:url>
    <spring:url value="/resources/upload/" var="upload"></spring:url>
    <!--[if lte IE 8]><!--<script src="assets/js/ie/respond.min.js"></script>--><![endif]-->
    <!-- Finish adding tags -->
    <link href="${boostrapcss}" rel="stylesheet" />
    <link href="${admincss}" rel="stylesheet" />
    <link href="${messagecss}" rel="stylesheet" />
    <link rel="shortcut icon" href="${images}/lg1.png" type="image/x-icon"/>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle navbar-toggle-sidebar collapsed">
            MENU
            </button>
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">
                WnW
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">      
            <form class="navbar-form navbar-left" method="GET" role="search">
                <div class="form-group">
                    <input type="text" name="q" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <!-- <li><a href="http://www.pingpong-labs.com" target="_blank">Visit Site</a></li> -->
                <li class="dropdown ">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                    ${sessionUser.first_Name}
                    <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li class="dropdown-header">Thiết lập</li>
                        <spring:url value="/manage-user/edit-profile/${sessionUser.user_ID}" var="manageusereditprofile"/>
                        <li class=""><a href="${manageusereditprofile}">Chỉnh sửa thống tin</a></li>
                        <spring:url value="/manage-user/change-password/${sessionUser.user_ID}" var="manageuserchangepassword"/>
                        <li class="${manageuserchangepassword}"><a href="">Đổi mật khẩu</a></li>
                        <li class="divider"></li>
                        <spring:url value="/logout" var="logout"/>
                        <li><a href="${logout}">Đăng xuất</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>      
<div class="container-fluid main-container">
    <div class="col-md-2 sidebar">
        <div class="row">
            <!-- uncomment code for absolute positioning tweek see top comment in css -->
                <div class="absolute-wrapper"> </div>
            <!-- Menu -->
            <div class="side-menu">
                <nav class="navbar navbar-default" role="navigation">
                    <!-- Main Menu -->
                    <div class="side-menu-container">
                        <ul class="nav navbar-nav">
                            <spring:url value="/manage-user/${sessionUser.user_ID}" var="manageuser"/>
                            <li class="active"><a href="${manageuser}"><span class="glyphicon glyphicon-dashboard"></span> Thống báo</a></li>
                            <spring:url value="/manage-user/profile/${sessionUser.user_ID}" var="manageuser"/>
                            <li class="active"><a href="${manageuser}"><span class="glyphicon glyphicon-user"></span>Hồ sơ</a></li>
                            <spring:url value="/manage-user/manage-post-topic/${sessionUser.user_ID}/page/0" var="manageuserListTopic"/>
                            <li><a href="${manageuserListTopic}"><span class="glyphicon glyphicon-plane"></span>Danh sách nhóm của bạn</a></li>
                            <spring:url value="/manage-user/change-password/${sessionUser.user_ID}" var="manageuserchangepassword"/>
                            <li><a href="${manageuserchangepassword}"><span class="glyphicon glyphicon-user"></span>Đổi mật khẩu</a></li>
                            <spring:url value="/manage-user/list-topic/${sessionUser.user_ID}" var="listtopicuserjoin"/>
                            <li><a href="${listtopicuserjoin}"><span class="glyphicon glyphicon-signal"></span>Dánh sách nhóm có người đăng ký.</a></li>
                            <spring:url value="/manage-user/list-message/${sessionUser.user_ID}" var="listmessage"/>
                            <li><a href="${listmessage}"><span class="glyphicon glyphicon-signal"></span>Danh sách tin nhắn</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </nav>

            </div>
        </div>          
    </div>
    <div class="col-md-10 content">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <span class="glyphicon glyphicon-list"></span>Tin nhắn
                <div class="pull-right action-buttons">
                    <div class="btn-group pull-right">
                        <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-cog" style="margin-right: 0px;"></span>
                        </button>
                        <ul class="dropdown-menu slidedown">
                            <li><a href="#"><span class="glyphicon glyphicon-pencil"></span>Edit</a></li>
                            <li><a href="#"><span class="glyphicon glyphicon-trash"></span>Delete</a></li>
                            <li><a href="#"><span class="glyphicon glyphicon-flag"></span>Flag</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <div style="padding-right: 15px;padding-left: 15px;margin-right: auto;margin-left: auto;">
                    <div style="">
                        <a href="#" style="width: 250px;margin: 0;padding: 0;float: left !important;color: #428bca;
                                    text-decoration: none;background-color: transparent;">
                            <img src="${upload}avatar/${messageRecevier.message_ID.fromUserID.avatar}"
                                 style="float: left !important;height: 40px;margin-top: 5px;margin:0;padding:0;" alt="image" title="${messageRecevier.message_ID.fromUserID.first_Name}" />
                        </a>
                        <b>${messageRecevier.message_ID.subject}</b>
                    </div>
                    <div style="margin-right: -15px; margin-left: -15px;">
                        <div style="width: 100%;float: left;position: relative; min-height: 1px; padding-right: 15px; padding-left: 15px;box-sizing: border-box;">
                            <div style="border-radius: 3px; box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
                            padding: 15px 25px; text-align: left; display: block; margin-top: 15px;margin-bottom: 10px;box-sizing: border-box;">
                                ${messageRecevier.message_ID.content}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel-footer">
                <div class="row">
                    <div class="col-md-6">

                    </div>
                    <div class="col-md-6">
                        <div class="round hollow text-center">
                            <a href="#" id="addClass"><span class="glyphicon glyphicon-comment"></span>Trả lời</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer class="pull-left footer">
        <p class="col-md-12">
            <hr class="divider">
            Copyright &COPY; 2015 <a href="#">CuongDV</a>
    </footer>
    <%--MESSAGE FORM HIDDEN--%>
    <div class="popup-box chat-popup" id="qnimate">
        <div class="popup-head">
            <div class="popup-head-left pull-left"><img src="${upload}avatar/${messageRecevier.message_ID.fromUserID.avatar}" alt="">${messageRecevier.message_ID.fromUserID.first_Name}</div>
            <div class="popup-head-right pull-right">
                <div class="btn-group">
                    <button class="chat-header-button" data-toggle="dropdown" type="button" aria-expanded="false">
                        <i class="glyphicon glyphicon-cog"></i>
                    </button>
                    <ul role="menu" class="dropdown-menu pull-right">
                        <li><a href="#">Media</a></li>
                        <li><a href="#">Block</a></li>
                        <li><a href="#">Clear Chat</a></li>
                        <li><a href="#">Email Chat</a></li>
                    </ul>
                </div>
                <button data-widget="remove" id="removeClass" class="chat-header-button pull-right" type="button">
                    <i class="glyphicon glyphicon-off"></i>
                </button>
            </div>
        </div>
        <div class="popup-messages">
            <div id="form-wrapper">
                <form action="/createmsg/${sessionUser.user_ID}", method="post">
                    <div id="form-inner">
                        <input type="hidden" class="form-control" id="name" value="${sessionUser.email}" name="fromUserEmail" placeholder="From User's Email" required >
                        <label for="name">Tiêu đề :</label>
                        <input type="text" class="input" id="name" name="subject" placeholder="Subject">

                        <label for="email">Email:</label>
                        <input type="email" class="input" id="email" placeholder="" name="toUserEmail" value="${messageRecevier.message_ID.fromUserID.email}">

                        <label for="message">Nội dung :</label>
                        <textarea class="form-control" name="message" type="textarea" id="message" placeholder="Message" maxlength="950" rows="7"></textarea>
                        <span class="help-block"><p id="characterLeft" class="help-block ">Nội dung tin nhắn bị giới hạn</p></span>

                        <input type="submit" class="button" value="Gửi">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%----%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>
    <%--<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>--%>
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script src="${js}/howitwork.js"></script>
    <script type="text/javascript">
        $(function () {
            $('.navbar-toggle-sidebar').click(function () {
                $('.navbar-nav').toggleClass('slide-in');
                $('.side-body').toggleClass('body-slide-in');
                $('#search').removeClass('in').addClass('collapse').slideUp(200);
            });

            $('#search-trigger').click(function () {
                $('.navbar-nav').removeClass('slide-in');
                $('.side-body').removeClass('body-slide-in');
                $('.search-input').focus();
            });
        });
        $(function(){
            $("#addClass").click(function () {
                $('#qnimate').addClass('popup-box-on');
            });

            $("#removeClass").click(function () {
                $('#qnimate').removeClass('popup-box-on');
            });
        });
        $(document).ready(function()
        {
            //Message
            $('#characterLeft').text('950 characters left');
            $('#message').keydown(function () {
                var max = 950;
                var len = $(this).val().length;
                if (len >= max) {
                    $('#characterLeft').text('You have reached the limit');
                    $('#characterLeft').addClass('red');
                    $('#btnSubmit').addClass('disabled');
                }
                else {
                    var ch = max - len;
                    $('#characterLeft').text(ch + ' characters left');
                    $('#btnSubmit').removeClass('disabled');
                    $('#characterLeft').removeClass('red');
                }
            });
        });
    </script>
</div>
</body>
</html>