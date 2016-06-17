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
        .checkbox {
            margin-left: 15px;
        }
        .panel.with-nav-tabs .panel-heading{
            padding: 5px 5px 0 5px;
        }
        .panel.with-nav-tabs .nav-tabs{
            border-bottom: none;
        }
        .panel.with-nav-tabs .nav-justified{
            margin-bottom: -1px;
        }
        /********************************************************************/
        /*** PANEL DEFAULT ***/
        .with-nav-tabs.panel-default .nav-tabs > li > a,
        .with-nav-tabs.panel-default .nav-tabs > li > a:hover,
        .with-nav-tabs.panel-default .nav-tabs > li > a:focus {
            color: #777;
        }
        .with-nav-tabs.panel-default .nav-tabs > .open > a,
        .with-nav-tabs.panel-default .nav-tabs > .open > a:hover,
        .with-nav-tabs.panel-default .nav-tabs > .open > a:focus,
        .with-nav-tabs.panel-default .nav-tabs > li > a:hover,
        .with-nav-tabs.panel-default .nav-tabs > li > a:focus {
            color: #777;
            background-color: #ddd;
            border-color: transparent;
        }
        .with-nav-tabs.panel-default .nav-tabs > li.active > a,
        .with-nav-tabs.panel-default .nav-tabs > li.active > a:hover,
        .with-nav-tabs.panel-default .nav-tabs > li.active > a:focus {
            color: #555;
            background-color: #fff;
            border-color: #ddd;
            border-bottom-color: transparent;
        }
        .with-nav-tabs.panel-default .nav-tabs > li.dropdown .dropdown-menu {
            background-color: #f5f5f5;
            border-color: #ddd;
        }
        .with-nav-tabs.panel-default .nav-tabs > li.dropdown .dropdown-menu > li > a {
            color: #777;
        }
        .with-nav-tabs.panel-default .nav-tabs > li.dropdown .dropdown-menu > li > a:hover,
        .with-nav-tabs.panel-default .nav-tabs > li.dropdown .dropdown-menu > li > a:focus {
            background-color: #ddd;
        }
        .with-nav-tabs.panel-default .nav-tabs > li.dropdown .dropdown-menu > .active > a,
        .with-nav-tabs.panel-default .nav-tabs > li.dropdown .dropdown-menu > .active > a:hover,
        .with-nav-tabs.panel-default .nav-tabs > li.dropdown .dropdown-menu > .active > a:focus {
            color: #fff;
            background-color: #555;
        }
        .popup-box {
            background-color: #ffffff;
        }
        .popup-box .popup-messages {
            background: none repeat scroll 0 0;
            height: 275px;
            overflow: auto;
        }
        .label {
            display: inline;
            padding: .2em .6em .3em;
            font-size: 75%;
            font-weight: 700;
            line-height: 1;
            color: #100F0F;
            text-align: center;
            white-space: nowrap;
            vertical-align: baseline;
            border-radius: .25em;
            background-color: #FEFF16;
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
                        ${sessionUser.first_Name}
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
        <%
            if (request.getParameter("msgerror") != null) { %>
        <div style="margin-top: 100px;" class="alert alert-danger">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <%= request.getParameter("msgerror").toString().replaceAll("\\<.*?>","") %>
        </div>
        <%
            }
        %>
        <%
            if (request.getParameter("msginfo") != null) { %>
        <div style="margin-top: 100px;" class="alert alert-info">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <%= request.getParameter("msginfo").toString().replaceAll("\\<.*?>","") %>
        </div>
        <%
            }
        %>
        <%
            if (request.getParameter("msgsuccess") != null) { %>
        <div style="margin-top: 100px;" class="alert alert-success">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <%= request.getParameter("msgsuccess").toString().replaceAll("\\<.*?>","") %>
        </div>
        <%
            }
        %>
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
                <div class="col-md-12">
                    <div class="panel with-nav-tabs panel-default ">
                        <div class="panel-heading">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#tab1default" data-toggle="tab">Tin nhắn mới</a></li>
                                <li><a href="#tab2default" data-toggle="tab">Tin nhắn đã đọc</a></li>
                                <li><a href="#tab3default" data-toggle="tab">Tin nhắn đã gửi</a></li>
                                <li class="dropdown">
                                    <a href="#" data-toggle="dropdown">Tạo tin nhắn<span class="caret"></span></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#tab4default" data-toggle="tab">Tạo mới</a></li>
                                        <%--<li><a href="#tab5default" data-toggle="tab">Default 5</a></li>--%>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <div class="panel-body popup-box">
                            <div class="tab-content popup-messages">
                                <div class="tab-pane fade in active" id="tab1default">
                                    <div class="panel-body">
                                        <ul class="list-group">
                                            <table class="table table-condensed table-hover">
                                                <thead>
                                                <tr>
                                                    <th class="span1"></th>
                                                    <th class="span2"></th>
                                                    <th class="span2"></th>
                                                    <th class="span9"></th>
                                                    <th class="span2"></th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="messageRecevierListRecevie" items="${messageRecevierListRecevie }" varStatus="status">
                                                    <tr>
                                                        <td><input type="checkbox"> <a href="#"><i class="icon-star-empty"></i></a></td>
                                                        <td>
                                                            <a href="<c:url value="/detail-message-recevice/msg/${messageRecevierListRecevie.message_ID.messageID}"/> ">
                                                                <strong>${messageRecevierListRecevie.message_ID.fromUserID.first_Name}</strong>
                                                            </a>
                                                        </td>
                                                        <td><span class="label pull-right">Thông báo</span></td>
                                                        <td>
                                                            <a href="<c:url value="/detail-message-recevice/msg/${messageRecevierListRecevie.message_ID.messageID}"/> ">
                                                                <strong>${messageRecevierListRecevie.message_ID.subject}</strong>
                                                            </a>
                                                        </td>
                                                        <td><strong>${messageRecevierListRecevie.message_ID.dateSend}</strong></td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </ul>
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="tab2default">
                                    <div class="panel-body">
                                        <ul class="list-group">
                                            <table class="table table-condensed table-hover">
                                                <thead>
                                                <tr>
                                                    <th class="span1"></th>
                                                    <th class="span2"></th>
                                                    <th class="span2"></th>
                                                    <th class="span9"></th>
                                                    <th class="span2"></th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="messageRecevierListSeen" items="${messageRecevierListSeen }" varStatus="status">
                                                    <tr>
                                                        <td><input type="checkbox"> <a href="#"><i class="icon-star-empty"></i></a></td>
                                                        <td>
                                                            <a href="<c:url value="/detail-message-recevice/msg/${messageRecevierListSeen.message_ID.messageID}"/> ">
                                                                <strong>${messageRecevierListSeen.message_ID.fromUserID.first_Name}</strong>
                                                            </a>
                                                        </td>
                                                        <td><span class="label pull-right">Thông báo</span></td>
                                                        <td>
                                                            <a href="<c:url value="/detail-message-recevice/msg/${messageRecevierListSeen.message_ID.messageID}"/> ">
                                                                <strong>${messageRecevierListSeen.message_ID.subject}</strong>
                                                            </a>
                                                        </td>
                                                        <td>
                                                            <strong>${messageRecevierListSeen.message_ID.dateSend}</strong>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </ul>
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="tab3default">
                                    <div class="panel-body">
                                        <ul class="list-group">
                                            <table class="table table-condensed table-hover">
                                                <thead>
                                                <tr>
                                                    <th class="span1"></th>
                                                    <th class="span2"></th>
                                                    <th class="span2"></th>
                                                    <th class="span9"></th>
                                                    <th class="span2"></th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="messageListSend" items="${messageListSend }" varStatus="status">
                                                    <tr>
                                                        <td><input type="checkbox"> <a href="#"><i class="icon-star-empty"></i></a></td>
                                                        <td>
                                                            <a href="<c:url value="/detail-message-sent/msg/${messageListSend.messageID}"/> ">
                                                                <strong>${messageListSend.toUserID.first_Name}</strong>
                                                            </a>
                                                        </td>
                                                        <td><span class="label pull-right"><a href="<c:url value="/detail-message-sent/msg/${messageListSend.messageID}"/> "></a>Thông báo</span></td>
                                                        <td>
                                                            <a href="<c:url value="/detail-message-sent/msg/${messageListSend.messageID}"/> ">
                                                                <strong>${messageListSend.subject}</strong>
                                                            </a>
                                                        </td>
                                                        <td><strong>${messageListSend.dateSend}</strong></td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </ul>
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="tab4default">
                                    <div class="panel panel-info">
                                        <div class="panel-heading">
                                            <h3 style="margin-bottom: 25px; text-align: center;">Form tin nhắn</h3>
                                        </div>
                                        <div class="panel-body">
                                            <div class="form-area">
                                                <form action="/createmsg/${sessionUser.user_ID}" method="post">
                                                    <br style="clear:both">
                                                    <div class="form-group">
                                                        <lable>Người gửi :</lable>
                                                        <input type="text" class="form-control" id="name" value="${sessionUser.email}" name="fromUserEmail" placeholder="Email của người gửi" required >
                                                    </div>
                                                    <div class="form-group">
                                                        <lable>Người nhận :</lable>
                                                        <input type="text" class="form-control" id="email" name="toUserEmail" placeholder="Email của người nhận" required >
                                                    </div>
                                                    <%--<div class="form-group">--%>
                                                        <%--<input type="hidden" class="form-control" id="mobile" name="mobile" placeholder="Mobile Number" required>--%>
                                                    <%--</div>--%>
                                                    <div class="form-group">
                                                        <lable>Tiêu đề :</lable>
                                                        <input type="text" class="form-control" id="subject" name="subject" placeholder="Tiêu đề" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <textarea class="form-control" name="message" type="textarea" id="message" placeholder="Nội dung" maxlength="950" rows="7"></textarea>
                                                        <span class="help-block"><p id="characterLeft" class="help-block ">You have reached the limit</p></span>
                                                    </div>

                                                    <button type="submit" class="btn btn-default">Gửi tin nhắn</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%--<div class="tab-pane fade" id="tab5default">Default 5</div>--%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel-footer">
                <div class="row">
                    <div class="col-md-6">
                        <h6>
                            <%--Total Count <span class="label label-info">25</span></h6>--%>
                    </div>
                    <%--<div class="col-md-6">--%>
                        <%--<div class="col-lg-12 text-center jPager">--%>
                            <%--<div class="col-md-12">--%>
                                <%--<ul id="pagination" class="">--%>
                                    <%--<c:set var="total" value="${num_page}"/>--%>
                                    <%--<c:set var="page" value="${page}"/>--%>
                                    <%--<spring:url value="/manageuser/manageposttopic/${sessionUser.user_ID}/page/0" var="first" />--%>
                                    <%--<spring:url value="/manageuser/manageposttopic/${sessionUser.user_ID}/page/${pre}" var="page_pre" />--%>
                                    <%--<spring:url value="/manageuser/manageposttopic/${sessionUser.user_ID}/page/${next}" var="page_next" />--%>
                                    <%--<spring:url value="/manageuser/manageposttopic/${sessionUser.user_ID}/page/${last}" var="last" />--%>
                                    <%--<li id = "first" class="">--%>
                                        <%--<a href="${first }" onclick="this.disabled = true">First</a>--%>
                                    <%--</li>--%>
                                    <%--<li id = "previous" class="">--%>
                                        <%--<a href="${page_pre }"><</a>--%>
                                    <%--</li>--%>
                                    <%--<li><span id="current_page"><c:out value="${page}"/></span>/<span id="total_page"><c:out value="${total}"/></span></li>--%>
                                    <%--<li id="next" class="">--%>
                                        <%--<a href="${page_next }">></a>--%>
                                    <%--</li>--%>
                                    <%--<li id = "last" class="">--%>
                                        <%--<a href="${last }" onclick="this.disabled = true">Last</a>--%>
                                    <%--</li>--%>
                                <%--</ul>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                </div>
            </div>
        </div>
    </div>

    <footer class="pull-left footer">
        <p class="col-md-12">
            <hr class="divider">
            Copyright &COPY; 2015 <a href="#">CuongDV</a>
    </footer>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>
    <%--<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>--%>
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
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