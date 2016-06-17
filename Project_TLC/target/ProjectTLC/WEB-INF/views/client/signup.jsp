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
    <title>Wnw</title>

    <!-- Bootstrap CSS -->
    <!--        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"> -->

    <!-- let's add tag srping:url -->
    <spring:url value="/resources/assets/css/main.css" var="main"></spring:url>
    <spring:url value="/resources/assets/css/bootstrap.min.css" var="bootstrap"></spring:url>
    <spring:url value="/resources/assets/css/custom-bootstrap.css" var="custombootstrap"></spring:url>
    <spring:url value="/resources/assets/js/" var="js"></spring:url>
    <spring:url value="/resources/images/" var="images"></spring:url>
    <spring:url value="/resources/img/" var="img"></spring:url>
    <spring:url value="/resources/upload/" var="upload"></spring:url>
    <!--[if lte IE 8]><!--<script src="assets/js/ie/respond.min.js"></script>--><![endif]-->
    <!-- Finish adding tags -->
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${main}" rel="stylesheet" />
    <link href="${custombootstrap}" rel="stylesheet" />
    <link href='https://fonts.googleapis.com/css?family=Alice' rel='stylesheet' type='text/css'>
    <link rel="shortcut icon" href="${images}/lg1.png" type="image/x-icon"/>
    <style>
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
</head>
<body style="font-family: 'Alice', serif;background-color: #EAEAEA;">
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
            <h1 id="logo"><a class="navbar-brand page-scroll" href="/"><img style="height: 45px;margin-top: -7px;" src="${images}/lg1.png"></a></h1>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right ">
                <li class="hidden">
                    <a href="#page-top"></a>
                </li>
                <li>
                    <a class="page-scroll" href="#"data-toggle="modal" data-target="#introModal">Giới thiêụ</a>
                </li>
                <li>
                    <a class="page-scroll" href="/login">Đăng nhập</a>
                </li>
                <li>
                    <a class="page-scroll" href="/signup">Đăng xuất</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
    <br>
    <br>
    <div class="container">
        <div class="col-md-3"></div>
        <div class="col-md-6">
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
             <div class="row myborder">
                <h4 style="color: #7EB59E; margin: initial; margin-bottom: 10px;">Đăng ký ngay</h4>
                <form action="<c:url value="/signup/add" /> " method="POST" enctype="multipart/form-data">
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope mycolor"></i>(<span style="color: #FF0000">*</span>)</span>
                        <input size="60" maxlength="255" class="form-control" placeholder="Email" name="signupemail"  type="email" required="true">
                    </div>
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock mycolor"></i>(<span style="color: #FF0000">*</span>)</span>
                        <input size="60" maxlength="255" class="form-control" placeholder="Mật khẩu" name="signuppasswork"  type="password" required="true">
                    </div>
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock mycolor"></i>(<span style="color: #FF0000">*</span>)</span>
                        <input size="60" maxlength="255" class="form-control" placeholder="Nhập lại mật khẩu" name="signuprepasswork" type="password" required="true">
                    </div>
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user mycolor"></i>(<span style="color: #FF0000">*</span>)</span>
                        <input size="60" maxlength="255" class="form-control" placeholder="Tên" name="signupfirstname" type="text" required="true">
                    </div>
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user mycolor"></i>(<span style="color: #FF0000">*</span>)</span>
                        <input size="60" maxlength="255" class="form-control" placeholder="Họ và tên lót" name="signuplastname"  type="text" required="true">
                    </div>
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-home mycolor"></i>(<span style="color: #FF0000">*</span>)</span>
                        <input size="60" maxlength="255" class="form-control" placeholder="Địa chỉ" name="signupaddress"  type="text" required="true">
                    </div>
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-phone mycolor"></i>(<span style="color: #FF0000">*</span>)</span>
                        <input size="60" maxlength="11" class="form-control" placeholder="Số điện thoại" name="signupcontactnumber" type="number" required="true">
                    </div>
                    <div class="input-group margin-bottom-20">
                        Giới tính :
                        <input type="radio" name="gender" value="1" id=male />Nam
                        <input type="radio" name="gender" value="0" id=female />Nữ
                    </div>
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-gift mycolor"></i>(<span style="color: #FF0000">*</span>)</span>
                        <input size="60" maxlength="255" class="form-control" placeholder="Ngày sinh (dd/MM/YYYY)" name="signupbirthday"  type="date" required="true">
                    </div>
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-book mycolor"></i>(<span style="color: #FF0000">*</span>)</span>
                        <input size="60" maxlength="255" class="form-control" placeholder="Nghề nghiệp" name="signupjob"  type="text" required="true">
                    </div>
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-home mycolor"></i>(<span style="color: #FF0000">*</span>)</span>
                        <select id="country" name="signupcountry" class="form-control" required="true">
                            <option name="country" value="">--- Quốc gia ---</option>
                        </select>
                        <%--<input size="60" maxlength="255" class="form-control" placeholder="Country" name="signupcountry"  type="text" required="true">--%>
                    </div>
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-globe mycolor"></i></span>
                        <input size="60" maxlength="255" class="form-control" placeholder="Website" name="signupwebsite"  type="text">
                    </div>
                    <div class="input-group margin-bottom-20">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-picture mycolor"></i></span>
                        <input id="filebutton" name="avatar"  class="form-control" type="file">
                    </div>
                    <div class="input-group margin-bottom-20">
                        <c:if test="${not empty msgerror}">
                            <div class="alert alert-danger">
                                <strong>Danger!</strong> ${msgerror}
                            </div>
                        </c:if>
                    </div>
                    <br />
                    <div class="row">
                        <div class="col-md-12">
                            <button class="btn small" type="submit">Đăng ký</button>
                        </div>
                    </div>
                </form>
                
            </div>
            <div class="col-md-2"></div>
        </div>
    </div>
    <br>
    <br>
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
    <footer id="footer">

        <!-- Icons -->
            <ul class="actions">
                <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
                <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
                <li><a href="#" class="icon fa-google-plus"><span class="label">Google+</span></a></li>
                <li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
                <li><a href="#" class="icon fa-pinterest"><span class="label">Pinterest</span></a></li>
                <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
            </ul>

        <!-- Menu -->
            <ul class="menu">
                <li>&copy; Untitled</li><li>Design: <a href="#">CuongDV</a></li>
            </ul>

    </footer>
    <spring:url value="/resources/assets/data.json" var="countries"></spring:url>
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/jquery.poptrox.min.js"></script>
    <script src="${js}/jquery.scrolly.min.js"></script>
    <script src="${js}/jquery.scrollex.min.js"></script>
    <script src="${js}/skel.min.js"></script>
    <script src="${js}/util.js"></script>
    <script src="${js}/main.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script src="${js}/howitwork.js"></script>
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
            output += '<option name="signupcountry" value='+element.code+'>'+element.name+'</option>';
            });
            // console.log(output);
            $("#country").html(output);

            },
            error: function() { // callback if there's an error
            alert("bug");
            }
            });
        });
    </script>
</body>
</html>