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
                Chỉnh sửa hồ sơ cá nhân
            </div>
            <div class="panel-body">
                <div class="col-md-12">
                    <spring:url value="/manage-user/edit-profile/edit" var="editUser"/>
                    <form action="${editUser}" method="post" class="form-horizontal" enctype="multipart/form-data">
                        <fieldset>
                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Tên(<span style="color: #FF0000">*</span>)</label>
                                <div class="col-md-4">
                                    <input id="textinput" name="firstName" type="text" placeholder="Tên" value="${userEdit.first_Name}" required="true" class="form-control input-md">
                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput1">Họ và tên lót(<span style="color: #FF0000">*</span>)</label>
                                <div class="col-md-4">
                                    <input id="textinput1" name="lastName" type="text" placeholder="Họ và tên lót" value="${userEdit.last_Name}" required="true" class="form-control input-md">
                                </div>
                            </div>

                            <!-- File Button -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="filebutton">Photo(<span style="color: #FF0000">Bạn nên có</span>)</label>
                                <div class="col-md-4">
                                    <input id="filebutton" name="file" class="input-file" type="file">
                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput2">Ngày sinh(<span style="color: #FF0000">*</span>)</label>
                                <div class="col-md-4">
                                    <input id="textinput2" name="birthday" type="date" placeholder="dd/MM/YYYY" value="${userEdit.birthday}" required="true" class="form-control input-md">
                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput3">Nghề nghiệp(<span style="color: #FF0000">*</span>)</label>
                                <div class="col-md-4">
                                    <input id="textinput3" name="job" type="text" placeholder="Nghề nghiệp" value="${userEdit.job}" required="true" class="form-control input-md">
                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput4">Số điên thoại</label>
                                <div class="col-md-4">
                                    <input id="textinput4" name="numberPhone" type="text" placeholder="Số điện thoại" value="${userEdit.phone_Number}" required="true" class="form-control input-md">
                                </div>
                            </div>

                            <!-- Select Basic -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="country">Quốc gia</label>
                                <div class="col-md-4">
                                    <select id="country" name="country" class="form-control">

                                    </select>
                                    <%--<input id="textinput" name="country" type="text" placeholder="Country" value="${userEdit.country}" required="true" class="form-control input-md">--%>
                                </div>
                            </div>

                            <!-- Select Basic -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="selectbasic">GIới tính</label>
                                <div class="col-md-4">
                                    <select id="selectbasic" name="gender" class="form-control">
                                        <c:choose>
                                            <c:when test="${userEdit.gender == 1}">
                                                <option name="gender" value="${userEdit.gender}" selected = "selected">Nam</option>
                                                <option name="gender" value="1">Female</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option name="gender" value="${userEdit.gender}" selected = "selected">Nữ</option>
                                                <option name="gender" value="0">Male</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </select>
                                </div>
                            </div>

                            <!-- Textarea -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput5">Đia chỉ</label>
                                <div class="col-md-4">
                                    <input id="textinput5" name="address" type="text" placeholder="Địa chỉ" value="${userEdit.address}" required="true" class="form-control input-md">
                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput6">Website</label>
                                <div class="col-md-4">
                                    <input id="textinput6" name="website" type="text" placeholder="Website" value="${userEdit.website}" class="form-control input-md">
                                </div>
                            </div>

                            <div class="form-group">
                                <%--<label class="col-md-4 control-label" for="textinput">Website</label>--%>
                                <div class="col-md-4">
                                    <input  name="userID" type="hidden" value="${userEdit.user_ID}"  class="form-control input-md">
                                </div>
                            </div>

                            <!-- Button -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="singlebutton"></label>
                                <div class="col-md-4">
                                    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Lưu</button>
                                </div>
                            </div>
                        </fieldset>
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
    <spring:url value="/resources/assets/data.json" var="countries"></spring:url>
    <spring:url value="/resources/assets/ckeditor/ckeditor.js" var="jsckeditor"></spring:url>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>
    <%--<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>--%>
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script src="${jsckeditor}"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $.ajax({
                url: "${countries}", // path to file
                dataType: 'json', // type of file (text, json, xml, etc)
                type : 'GET',
                success: function(data) { // callback for successful completion
                    // var jsonString = JSON.stringify(data);
                    var output = "";
                    $.each(data, function(index, element) {
                        output += '<option name="country" value='+element.code+'>'+element.name+'</option>';
                    });
                    // console.log(output);
                    $("#country").html(output);

                },
                error: function() { // callback if there's an error
                    alert("bug");
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
</body>
</html>