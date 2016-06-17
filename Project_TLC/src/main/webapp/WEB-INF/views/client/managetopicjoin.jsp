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
        <div class="panel panel-primary">
            <div class="panel-heading">
                <span class="glyphicon glyphicon-list"></span>Danh sách nhóm tham gia
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
                <ul class="list-group">
                    <c:forEach var="topicUserList" items="${topicUserList }" varStatus="status">
                        <li class="list-group-item">
                            <div class="checkbox">
                                <input type="checkbox" id="checkbox${status.index + 1 }" />
                                <label for="checkbox${status.index + 1 }">
                                    ${topicUserList.post_ID.post_Name}
                                </label>
                                <label for="checkbox${status.index + 1 }">
                                    <b>Date join :</b> ${topicUserList.date_Join}
                                </label>
                                <label for="checkbox${status.index + 1 }">
                                    <b>Status :</b>
                                    <c:if test="${topicUserList.status == 0}">
                                        <span style="color: #a99d25">Pending</span>
                                    </c:if>
                                    <c:if test="${topicUserList.status == 1}">
                                        <span style="color: #00a905">Accept</span>
                                    </c:if>
                                    <c:if test="${topicUserList.status == 3}">
                                        <span style="color: #a90004">Disable</span>
                                    </c:if>
                                </label>
                            </div>
                            <div class="pull-right action-buttons">
                                <%--<spring:url value="/manageuser/editposttopic/${listPost.post_ID}" var="manageUserEditPost"/>--%>
                                <%--<a href="${manageUserEditPost}"><span class="glyphicon glyphicon-pencil"></span></a>--%>
                                <spring:url value="/manage-user/list-topic-join/${topicUserList.post_ID.post_ID}/delete/${sessionUser.user_ID}" var="deleteTopicJoin"/>
                                <a href="${deleteTopicJoin}" class="trash" onclick=""data-toggle="tooltip" data-placement="left" title="Cancel">
                                    <span class="glyphicon glyphicon-remove"></span>
                                </a>
                                <%--<spring:url value="/manageuser/list-user-join-topic/${listPost.post_ID}" var="manageUserListJoin"/>--%>
                                <%--<a href="${manageUserListJoin}" class="flag"><span class="glyphicon glyphicon-user"></span></a>--%>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="panel-footer">
                <div class="row">
                    <div class="col-md-6">
                        <h6>
                            Total Count <span class="label label-info"></span></h6>
                    </div>
                    <div class="col-md-6">
                        <div class="col-lg-12 text-center jPager">
                            <div class="col-md-12">
                                <ul id="pagination" class="">
                                    <c:set var="total" value="${num_page}"/>
                                    <c:set var="page" value="${page}"/>
                                    <spring:url value="/manage-user/list-topic/${sessionUser.user_ID}/page/0" var="first" />
                                    <spring:url value="/manage-user/list-topic/${sessionUser.user_ID}/page/${pre}" var="page_pre" />
                                    <spring:url value="/manage-user/list-topic/${sessionUser.user_ID}/page/${next}" var="page_next" />
                                    <spring:url value="/manage-user/list-topic/${sessionUser.user_ID}/page/${last}" var="last" />
                                    <li id = "first" class="">
                                        <a href="${first }" onclick="this.disabled = true">Đầu</a>
                                    </li>
                                    <li id = "previous" class="">
                                        <a href="${page_pre }"><</a>
                                    </li>
                                    <c:choose>
                                        <c:when test="${total == 0}">
                                            <li><span id="current_page">0</span>/<span id="total_page">0</span></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><span id="current_page"><c:out value="${page}"/></span>/<span id="total_page"><c:out value="${total}"/></span></li>
                                        </c:otherwise>
                                    </c:choose>
                                    <li id="next" class="">
                                        <a href="${page_next }">></a>
                                    </li>
                                    <li id = "last" class="">
                                        <a href="${last }" onclick="this.disabled = true">Cuối</a>
                                    </li>
                                </ul>
                            </div>
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
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>
    <%--<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>--%>
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();
            var current_page = $('#current_page').text();
            var total_page = $('#total_page').text();
            $(function() {
                if( (current_page == total_page && total_page == 0)||(current_page == total_page && total_page == 1)){
                    $('#previous').attr({"class" : "disable"});
                    $('#first').attr({"class" : "disable"});
                    $('#next').attr({"class" : "disable"});
                    $('#last').attr({"class" : "disable"});
                } else if(current_page == 1 && current_page < total_page){
                    $('#previous').attr({"class" : "disable"});
                    $('#first').attr({"class" : "disable"});
                } else if(current_page == total_page && current_page > 1){
                    $('#next').attr({"class" : "disable"});
                    $('#last').attr({"class" : "disable"});
                }
            });
            $(".add").on('click',function(){
                $(location).attr('href', 'AddVendorResources');
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
</body>
</html>