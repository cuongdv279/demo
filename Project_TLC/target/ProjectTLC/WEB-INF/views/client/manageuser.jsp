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
        <c:if test="${not empty msgerror}">
            <div class="alert alert-danger">
                    ${msgerror}
            </div>
        </c:if>
        <c:if test="${not empty msginfo}">
            <div class="alert alert-info">
                    ${msginfo}
            </div>
        </c:if>
        <c:if test="${not empty msgsuccess}">
            <div class="alert alert-success">
                    ${msgsuccess}
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
        <div class="panel panel-default">
            <div class="panel-heading">
                Hồ sơ cá nhân
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
                    <a href="${manageusereditprofile}" >Chỉnh sửa hồ sơ</a>
                    <a href="${logout}" >Đăng xuất</a>
                    <br>
                        <p class=" text-info">February 16,2016,03:00 pm </p>
                  </div>
                  <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
                    <div class="panel panel-info">
                      <div class="panel-heading">
                        <h3 class="panel-title">${user.first_Name} ${user.last_Name}</h3>
                      </div>
                      <div class="panel-body">
                        <div class="row">
                          <div class="col-md-3 col-lg-3 " align="center">
                              <img style="height: 111px;" alt="User Pic" src="${upload}/avatar/${user.avatar}" class="img-circle img-responsive">
                          </div>
                          <div class=" col-md-9 col-lg-9 "> 
                            <table class="table table-user-information">
                              <tbody>

                                <tr>
                                  <td>Nghề nghiệp :</td>
                                  <td>${user.job}</td>
                                </tr>
                                <tr>
                                  <td>Ngày sinh :</td>
                                  <td>${user.birthday}</td>
                                </tr>
                             
                                   <tr>
                                <tr>
                                  <td>Giới tính :</td>
                                    <c:choose>
                                        <c:when test="${user.gender == 1}">
                                            <td>Nam</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>Nữ</td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>
                                <tr>
                                  <td>Địa chỉ :</td>
                                  <td>${user.address}</td>
                                </tr>
                                <tr>
                                  <td>Email</td>
                                  <td><a href="<c:url value="${user.email}"/>">${user.email}</a></td>
                                </tr>
                                <tr>
                                <td>Số điện thoại :</td>
                                <td>${user.phone_Number}</td>
                                </tr>
                               
                              </tbody>
                            </table>
                          </div>
                          </div>
                        </div>
                        <div class="panel-footer">
                            <%--<a data-original-title="" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>--%>
                            <span class="pull-right">
                                <a href="${manageusereditprofile}" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning" data-toggle="tooltip" data-placement="left" title="Chỉnh sửa hồ sơ">
                                    <i class="glyphicon glyphicon-edit"></i>
                                </a>
                                <%--<a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>--%>
                            </span>
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
            Copyright &COPY; 2016 <a href="#">CuongDV</a>
    </footer>
    <%--JS--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>
    <%--<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>--%>
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();
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