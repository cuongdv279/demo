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
        <div class="panel panel-default">
            <div class="panel-heading">
                Chính sửa bài viết
            </div>
            <div class="panel-body">
                <div class="col-md-12">
                    <spring:url value="/manage-user/edit-post-topic/${sessionUser.user_ID}/edit" var="editPostTopic"/>
                    <form action="${editPostTopic}" method="post" role="form" id="contact-form" class="contact-form" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-md-12">
                                <label>Title topic<span style="color: red"> *</span></label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="titleTopic" autocomplete="off"  placeholder="Tiêu đề" value="${postEdit.post_Name}">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <label>Địa điểm<span style="color: red"> *</span></label>
                                <!-- <div class="form-group"> -->
                                <select class="form-control" id="" name="categories">
                                    <c:forEach var="categoriesList" items="${categoriesList }" varStatus="status">
                                        <c:choose>
                                            <c:when test="${postEdit.cate_ID.cateId == categoriesList.cateId}">
                                                <option id="categories" name="categories" value="${categoriesList.cateId}" selected = "selected">${categoriesList.cateName }</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option id="categories" name="categories" value="${categoriesList.cateId}">${categoriesList.cateName }</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                                <!-- </div> -->
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <label>Ngày đi :<span style="color: red"> *</span></label>
                                <div class="form-group">
                                    <input type="date" class="form-control" name="checkIn" autocomplete="off"  placeholder="dd/MM/YYYY" value="${postEdit.date_Start}">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <label>Ngày về :<span style="color: red"> *</span></label>
                                <div class="form-group">
                                    <input type="date" class="form-control" name="checkOut" autocomplete="off" id="Name" placeholder="dd/MM/YYYY" value="${postEdit.date_End}">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-dm-12">
                                <label>Upload Image<span style="color: red"> *</span></label>
                                <div class="form-group">
                                    <input id="filebutton" name="file"  class="input-file" type="file" value="${postEdit.image}">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <label>Nội dung<span style="color: red"> *</span></label>
                                <div class="form-group">
                                    <textarea class="form-control textarea ckeditor" rows="3" name="description"  placeholder="Nội dung mô tả về bài viết">${postEdit.post_Content}</textarea>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <label>Yêu cầu<span style="color: red"> *</span></label>
                                <div class="form-group">
                                    <textarea class="form-control textarea ckeditor" rows="3" name="rules"  placeholder="Yêu cầu của nhóm">${postEdit.rule}</textarea>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <input class="form-control" name="post_ID" type="hidden" value="${postEdit.post_ID}"  >
                        </div>
                        <div class="form-group">
                            <input class="form-control" name="user_ID" type="hidden" value="${postEdit.user_ID.user_ID}"  >
                        </div>
                        <div class="form-group">
                            <input class="form-control" name="postLocal_ID" type="hidden" value="${postEdit.postLocal.post_ID}"  >
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn main-btn pull-right">Lưu</button>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- </div> -->
            </div>
            </div>
        </div>
    </div>
    <footer class="pull-left footer">
        <p class="col-md-12">
            <hr class="divider">
            Copyright &COPY; 2016 <a href="#">CuongDV</a>
    </footer>
    <%--JS--%>
    <spring:url value="/resources/assets/ckeditor/ckeditor.js" var="jsckeditor"></spring:url>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>
    <%--<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>--%>
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script src="${jsckeditor}"></script>
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
    </script>
</div>
</body>
</html>