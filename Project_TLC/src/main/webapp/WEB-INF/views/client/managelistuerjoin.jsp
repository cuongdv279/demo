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
    <%--<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">--%>
    
    <!-- let's add tag srping:url -->
    <spring:url value="/resources/assets/css/bootstrap.min.css" var="boostrapcss"></spring:url>
    <spring:url value="/resources/assets/css/admin-style.css" var="admincss"></spring:url>
    <spring:url value="/resources/assets/js/" var="js"></spring:url>
    <spring:url value="/resources/images/" var="images"></spring:url>
    <spring:url value="/resources/upload/" var="upload"></spring:url>
    <!--[if lte IE 8]><!--<script src="assets/js/ie/respond.min.js"></script>--><![endif]-->
    <!-- Finish adding tags -->
    <link href="${boostrapcss}" rel="stylesheet" />
    <link href="${admincss}" rel="stylesheet" />
    <link rel="shortcut icon" href="${images}/lg1.png" type="image/x-icon"/>
    <style type="text/css" media="screen">
        /*    --------------------------------------------------
    :: General
    -------------------------------------------------- */
        body {
            font-family: 'Open Sans', sans-serif;
            color: #353535;
        }
        .content h1 {
            text-align: center;
        }
        .content .content-footer p {
            color: #6d6d6d;
            font-size: 12px;
            text-align: center;
        }
        .content .content-footer p a {
            color: inherit;
            font-weight: bold;
        }

        /*	--------------------------------------------------
            :: Table Filter
            -------------------------------------------------- */
        .panel {
            border: 1px solid #ddd;
            background-color: #fcfcfc;
        }
        .panel .btn-group {
            margin: 15px 0 30px;
        }
        .panel .btn-group .btn {
            transition: background-color .3s ease;
        }
        .table-filter {
            background-color: #fff;
            border-bottom: 1px solid #eee;
        }
        .table-filter tbody tr:hover {
            cursor: pointer;
            background-color: #eee;
        }
        .table-filter tbody tr td {
            padding: 10px;
            vertical-align: middle;
            border-top-color: #eee;
        }
        .table-filter tbody tr.selected td {
            background-color: #eee;
        }
        .table-filter tr td:first-child {
            width: 38px;
        }
        .table-filter tr td:nth-child(2) {
            width: 35px;
        }
        .ckbox {
            position: relative;
        }
        .ckbox input[type="checkbox"] {
            opacity: 0;
        }
        .ckbox label {
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }
        .ckbox label:before {
            content: '';
            top: 1px;
            left: 0;
            width: 18px;
            height: 18px;
            display: block;
            position: absolute;
            border-radius: 2px;
            border: 1px solid #bbb;
            background-color: #fff;
        }
        .ckbox input[type="checkbox"]:checked + label:before {
            border-color: #2BBCDE;
            background-color: #2BBCDE;
        }
        .ckbox input[type="checkbox"]:checked + label:after {
            top: 3px;
            left: 3.5px;
            content: '\e013';
            color: #fff;
            font-size: 11px;
            font-family: 'Glyphicons Halflings';
            position: absolute;
        }
        .table-filter .star {
            color: #ccc;
            text-align: center;
            display: block;
        }
        .table-filter .star.star-checked {
            color: #F0AD4E;
        }
        .table-filter .star:hover {
            color: #ccc;
        }
        .table-filter .star.star-checked:hover {
            color: #F0AD4E;
        }
        .table-filter .media-photo {
            width: 35px;
        }
        .table-filter .media-body {
            /*display: block;*/
            /* Had to use this style to force the div to expand (wasn't necessary with my bootstrap version 3.3.6) */
        }
        .table-filter .media-meta {
            font-size: 11px;
            color: #999;
        }
        .table-filter .media .title {
            color: #2BBCDE;
            font-size: 14px;
            font-weight: bold;
            line-height: normal;
            margin: 0;
        }
        .table-filter .media .title span {
            font-size: .8em;
            margin-right: 20px;
        }
        .table-filter .media .title span.accept {
            color: #5cb85c;
        }
        .table-filter .media .title span.pending {
            color: #f0ad4e;
        }
        .table-filter .media .title span.disable {
            color: #d9534f;
        }
        .table-filter .media .summary {
            font-size: 14px;
        }
        .disable {
            pointer-events: none;
            cursor: default;
            color: #1F1F1F;
        }
    </style>
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
                    <input type="text" name="q" class="form-control" placeholder="Tìm kiếm">
                </div>
                <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <!-- <li><a href="http://www.pingpong-labs.com" target="_blank">Visit Site</a></li> -->
                <li class="dropdown ">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        ${user.first_Name}
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li class="dropdown-header">Thiết lập</li>
                        <spring:url value="/manage-user/edit-profile/${sessionUser.user_ID}" var="manageusereditprofile"/>
                        <li class=""><a href="${manageusereditprofile}">Chính sửa hồ sơ</a></li>
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
    <div class="col-md-2 sidebar_user">
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
                            <li class="active"><a href="${manageuser}"><span class="glyphicon glyphicon-dashboard"></span> Thông báo</a></li>
                            <spring:url value="/manage-user/profile/${sessionUser.user_ID}" var="manageuser"/>
                            <li class="active"><a href="${manageuser}"><span class="glyphicon glyphicon-user"></span> Hồ sơ</a></li>
                            <spring:url value="/manage-user/manage-post-topic/${sessionUser.user_ID}/page/0" var="manageuserListTopic"/>
                            <li><a href="${manageuserListTopic}"><span class="glyphicon glyphicon-plane"></span> Danh sách nhóm</a></li>
                            <li><a href="${manageuserchangepassword}"><span class="glyphicon glyphicon-user"></span> Đổi mật khẩu</a></li>
                            <spring:url value="/manage-user/list-topic/${sessionUser.user_ID}" var="listtopicuserjoin"/>
                            <li><a href="${listtopicuserjoin}"><span class="glyphicon glyphicon-signal"></span> Danh sách nhóm có người tham gia</a></li>
                            <spring:url value="/manage-user/list-message/${sessionUser.user_ID}" var="listmessage"/>
                            <li><a href="${listmessage}"><span class="glyphicon glyphicon-signal"></span>Dánh sách tin nhắn</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </nav>

            </div>
        </div>
    </div>
    <div class="col-md-10 content">
        <div class="row">
            <section class="content">
                <h1>Nhóm</h1>
                <div class="col-md-8 col-md-offset-2">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="pull-left">
                                <c:set var="posts" value="${posts}"/>
                                <div class="btn-group">
                                    <h4><b>${posts.post_Name}</b></h4>
                                </div>
                            </div>
                            <div class="pull-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-success btn-filter" data-target="accept">Chấp nhận</button>
                                    <button type="button" class="btn btn-warning btn-filter" data-target="pending">Chờ duyệt</button>
                                    <button type="button" class="btn btn-danger btn-filter" data-target="disable">Hủy</button>
                                    <button type="button" class="btn btn-default btn-filter" data-target="all">Tất cả</button>
                                </div>
                            </div>
                            <div class="table-container">
                                <table class="table table-filter">
                                    <tbody>
                                    <c:forEach var="topicUserList" items="${topicUserList }" varStatus="status">
                                        <c:if test="${topicUserList.status == 1}" >
                                            <tr data-status="accept">
                                                <td>
                                                    <div class="ckbox">
                                                        <input type="checkbox" id="checkbox${status.index + 1 }">
                                                        <label for="checkbox${status.index + 1 }"></label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <a href="javascript:;" class="star">
                                                        <i class="glyphicon glyphicon-star"></i>
                                                    </a>
                                                </td>
                                                <td>
                                                    <div class="media">
                                                        <a href="#" class="pull-left" role="button" data-toggle="modal" data-target="#login-modal${status.index + 1 }">
                                                            <img src="${upload}/avatar/${topicUserList.user_ID.avatar}" class="media-photo">
                                                        </a>
                                                        <div class="media-body">
                                                            <span class="media-meta pull-right">${topicUserList.date_Join}</span>
                                                            <h4 class="title">
                                                                ${topicUserList.user_ID.first_Name}.${topicUserList.user_ID.last_Name}
                                                                <span class="pull-right accept">(Accept)</span>
                                                            </h4>
                                                            <p class="summary">
                                                                <a style="color: #5cb85c;" href="<c:url value="/manage-user/list-user-join-topic/${posts.post_ID}/${topicUserList.user_ID.user_ID}/accept"/>">Chấp nhận</a>|
                                                                <a style="color: #f0ad4e;" href="<c:url value="/manage-user/list-user-join-topic/${posts.post_ID}/${topicUserList.user_ID.user_ID}/pending"/>">Chờ duyệt</a>|
                                                                <a style="color: #d9534f;" href="<c:url value="/manage-user/list-user-join-topic/${posts.post_ID}/${topicUserList.user_ID.user_ID}/disable"/>">Hủy</a>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:if>
                                        <c:if test="${topicUserList.status == 0}" >
                                            <tr data-status="pending">
                                                <td>
                                                    <div class="ckbox">
                                                        <input type="checkbox" id="checkbox${status.index + 1 }">
                                                        <label for="checkbox${status.index + 1 }"></label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <a href="javascript:;" class="star">
                                                        <i class="glyphicon glyphicon-star"></i>
                                                    </a>
                                                </td>
                                                <td>
                                                    <div class="media">
                                                        <a href="#" class="pull-left" role="button" data-toggle="modal" data-target="#login-modal${status.index + 1 }">
                                                            <img src="${upload}/avatar/${topicUserList.user_ID.avatar}" class="media-photo">
                                                        </a>
                                                        <div class="media-body">
                                                            <span class="media-meta pull-right">${topicUserList.date_Join}</span>
                                                            <h4 class="title">
                                                                ${topicUserList.user_ID.first_Name}.${topicUserList.user_ID.last_Name}
                                                                <span class="pull-right pending">(Pending)</span>
                                                            </h4>
                                                            <p class="summary">
                                                                <a style="color: #5cb85c;" href="<c:url value="/manage-user/list-user-join-topic/${posts.post_ID}/${topicUserList.user_ID.user_ID}/accept"/>">Chấp nhận</a>|
                                                                <a style="color: #f0ad4e;" href="<c:url value="/manage-user/list-user-join-topic/${posts.post_ID}/${topicUserList.user_ID.user_ID}/pending"/>">Chờ duyệt</a>|
                                                                <a style="color: #d9534f;" href="<c:url value="/manage-user/list-user-join-topic/${posts.post_ID}/${topicUserList.user_ID.user_ID}/disable"/>">Hủy</a>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:if>
                                        <c:if test="${topicUserList.status == 3}" >
                                            <tr data-status="disable">
                                                <td>
                                                    <div class="ckbox">
                                                        <input type="checkbox" id="checkbox${status.index + 1 }">
                                                        <label for="checkbox${status.index + 1 }"></label>
                                                    </div>
                                                </td>
                                                <td>
                                                    <a href="javascript:;" class="star">
                                                        <i class="glyphicon glyphicon-star"></i>
                                                    </a>
                                                </td>
                                                <td>
                                                    <div class="media">
                                                        <a href="#" class="pull-left" role="button" data-toggle="modal" data-target="#login-modal${status.index + 1 }">
                                                            <img src="${upload}/avatar/${topicUserList.user_ID.avatar}" class="media-photo">
                                                        </a>
                                                        <div class="media-body">
                                                            <span class="media-meta pull-right">${topicUserList.date_Join}</span>
                                                            <h4 class="title">
                                                                ${topicUserList.user_ID.first_Name}.${topicUserList.user_ID.last_Name}
                                                                <span class="pull-right disable">(Disable)</span>
                                                            </h4>
                                                            <p class="summary">
                                                                <a style="color: #5cb85c;" href="<c:url value="/manage-user/list-user-join-topic/${posts.post_ID}/${topicUserList.user_ID.user_ID}/accept"/>">Chấp nhận</a>|
                                                                <a style="color: #f0ad4e;" href="<c:url value="/manage-user/list-user-join-topic/${posts.post_ID}/${topicUserList.user_ID.user_ID}/pending"/>">Chờ duyệt</a>|
                                                                <a style="color: #d9534f;" href="<c:url value="/manage-user/list-user-join-topic/${posts.post_ID}/${topicUserList.user_ID.user_ID}/disable"/>">Hủy</a>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <footer class="pull-left footer">
        <p class="col-md-12">
            <hr class="divider">
            Copyright &COPY; 2016 <a href="#">CuongDV</a>
    </footer>
    <%--JS--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>
    <%--<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>--%>
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {

            $('.star').on('click', function () {
                $(this).toggleClass('star-checked');
            });

            $('.ckbox label').on('click', function () {
                $(this).parents('tr').toggleClass('selected');
            });

            $('.btn-filter').on('click', function () {
                var $target = $(this).data('target');
                if ($target != 'all') {
                    $('.table tr').css('display', 'none');
                    $('.table tr[data-status="' + $target + '"]').fadeIn('slow');
                } else {
                    $('.table tr').css('display', 'none').fadeIn('slow');
                }
            });

        });
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
    </script>
</div>
<!-- BEGIN # MODAL LOGIN -->
<c:forEach var="topicUserList" items="${topicUserList }" varStatus="status">
<div class="modal fade" id="login-modal${status.index + 1 }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" align="center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </button>
            </div>
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">${topicUserList.user_ID.first_Name} ${topicUserList.user_ID.last_Name}</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center">
                            <img alt="User Pic" src="${upload}/avatar/${topicUserList.user_ID.avatar}" class="img-circle img-responsive">
                        </div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Nghề nghiệp :</td>
                                    <td>${topicUserList.user_ID.job}</td>
                                </tr>
                                <tr>
                                    <td>Ngày sinh :</td>
                                    <td>${topicUserList.user_ID.birthday}</td>
                                </tr>
                                <tr>
                                <tr>
                                    <td>Giới tính :</td>
                                    <c:choose>
                                        <c:when test="${topicUserList.user_ID.gender == 1}">
                                            <td>Nam</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>Nữ</td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>
                                <tr>
                                    <td>Địa chỉ :</td>
                                    <td>${topicUserList.user_ID.address}</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td><a href="${topicUserList.user_ID.email}">${topicUserList.user_ID.email}</a></td>
                                </tr>
                                <td>Số điện thoại :</td>
                                <td>${topicUserList.user_ID.phone_Number}<br></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                        <span class="pull-right">
                            <a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                        </span>
                </div>
            </div>
        </div>
    </div>
</div>
</c:forEach>
<!-- END # MODAL LOGIN -->
</body>
</html>