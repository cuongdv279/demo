<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<c:set var="user" value="${user}"/>--%>
<c:choose>
    <c:when test="${not empty sessionUser}">
        <%@include file="header-user.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="header-guest-home.jsp" %>
    </c:otherwise>
</c:choose>
<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->
<header class="intro-header" style="background-image: url('${img}/home-bg.jpg')">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="site-heading">
                    <h1>Thông tin chi tiết</h1>
                    <hr class="small">
                    <span class="subheading">Thông tin chi tiết về nhóm  và những hoạt động của nhóm</span>
                </div>
            </div>
        </div>
    </div>
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
</header>

<!-- Main Content -->
<div class="container">
    <div class="row">
        <div class="col-md-12 col-xs-12" style="background-color: #FFFFFF">
            <div class="col-md-3 col-xs-3">
                <c:set var="postsTopic" value="${postsTopic}"/>
                <a href="#" class="btn btn-primary btn-lg" role="button" data-toggle="modal" data-target="#login-modal">
                    <img src="${upload}/avatar/${postsTopic.user_ID.avatar}" style="height: 100px; width: 100px;" class="img-responsive img-circle" alt="">
                    <p><b>${postsTopic.user_ID.first_Name}</b></p>
                </a>

            </div>
            <div style="border-right: 1px black solid; height: 100px;" class="col-md-5 col-xs-5">
                <h3>${postsTopic.post_Name}</h3>
            </div>
            <div class="col-md-4 col-xs-4">
                <p><span style="font-size: 3em">${postsTopic.num_View}</span></p>
                <p>VIEW</p>
            </div>
        </div>
        <section>
            <div class="row">
                <div class="col-lg-9 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Thông tin
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <div class="row">
                                    <div class="col-md-4">
                                        <h5><b>Mô tả về nhóm</b></h5>
                                    </div>
                                    <div class="col-md-8">
                                        ${postsTopic.post_Content}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-md-4">
                                        <h5><b>Thời gian dự kiến</b></h5>
                                    </div>
                                    <div class="col-md-8">
                                        <p>Ngày đi : ${postsTopic.date_Start}</p>
                                        <p>Ngày về : ${postsTopic.date_End}</p>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-md-4">
                                        <h5><b>Yêu cầu của nhóm</b></h5>
                                    </div>
                                    <div class="col-md-8">
                                        ${postsTopic.rule}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-md-4">
                                        <h5><b>Vài bức ảnh</b></h5>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
                                            <div class="project-wrapper">
                                                <div class="project">
                                                    <div class="photo-wrapper">
                                                        <div class="photo">
                                                            <a class="fancybox" href="${upload}imgPostTopic/${postsTopic.image}">
                                                                <img class="img-responsive" src="${upload}imgPostTopic/${postsTopic.image}" alt="">
                                                            </a>
                                                        </div>
                                                        <div class="overlay"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div><!-- col-lg-4 -->
                                        <!-- col-lg-4 -->
                                    </div>
                                </div>
                                <div class="row">
                                    <spring:url value="http://wnwapp-wnw.rhcloud.com${requestScope['javax.servlet.forward.request_uri']}" var="url"/>
                                    <c:if test="${not empty sessionUser}">
                                        <form action="<c:url value="/post-user/add-topic-join/${postsTopic.post_ID}/${sessionUser.user_ID}"/>" method="POST">
                                            <button type="submit" class="btn btn-default">Join Now</button>
                                        </form>
                                        <div class="fb-like" data-href="${url}" data-layout="box_count" data-action="like" data-show-faces="true" data-share="true"></div>
                                    </c:if>
                                    <c:if test="${empty sessionUser}">
                                        <form action="<c:url value="/post-user/add-topic-join/${postsTopic.post_ID}/none"/>" method="POST">
                                            <button type="submit" class="btn btn-default">Tham gia ngay</button>
                                        </form>
                                        <div class="fb-like" data-href="${url}" data-layout="box_count" data-action="like" data-show-faces="true" data-share="true"></div>
                                    </c:if>

                                </div>
                                <%--Comment facebook--%>
                                <div class="fb-comments" data-href="${url}" data-width="100%" data-numposts="5"></div>
                                <%--//--%>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-9 -->
                <div class="col-lg-3 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Thành viên đã tham gia
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body" style="background: #fff none repeat scroll 0 0;height: 275px;overflow: auto;">
                            <c:forEach var="listUserJoined" items="${listUserJoined }" varStatus="status">
                                <div class="col-sm-4 col-xs-3">
                                    <a href="" data-original-title="${listUserJoined.user_ID.first_Name}" data-placement="top" title="">
                                        <img src="${upload}avatar/${listUserJoined.user_ID.avatar}" width="50px" height="50px" alt="image">
                                    </a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>
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
<!-- BEGIN # MODAL PROFILE -->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" align="center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </button>
            </div>
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">${postsTopic.user_ID.first_Name} ${postsTopic.user_ID.last_Name}</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center">
                            <img style="height: 111px;" alt="User Pic" src="${upload}/avatar/${postsTopic.user_ID.avatar}" class="img-circle img-responsive">
                        </div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Nghề nghiệp:</td>
                                    <td>${postsTopic.user_ID.job}</td>
                                </tr>
                                <tr>
                                    <td>Ngày sinh :</td>
                                    <td>${postsTopic.user_ID.birthday}</td>
                                </tr>
                                <tr>
                                <tr>
                                    <td>Giới tính :</td>
                                    <c:choose>
                                        <c:when test="${postsTopic.user_ID.gender == 1}">
                                            <td>Nam</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>Nữ</td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>
                                <tr>
                                    <td>Địa chỉ :</td>
                                    <td>${postsTopic.user_ID.address}</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td><a href="${postsTopic.user_ID.email}">${postsTopic.user_ID.email}</a></td>
                                </tr>
                                <td>Số điện thoại</td>
                                <td>${postsTopic.user_ID.phone_Number}<br></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <a data-original-title="Broadcast Message" data-toggle="modal" data-target="#message-modal" type="button"
                       class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                    <span class="pull-right">
                        <%--<a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>--%>
                    </span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- END # MODAL LOGIN -->
<!-- BEGIN # MODAL MESSAGE -->
<div class="modal fade" id="message-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" align="center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </button>
            </div>
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 style="margin-bottom: 25px; text-align: center;">Form tin nhắn</h3>
                </div>
                <div class="panel-body">
                    <div class="form-area">
                        <form action="/sendmsg/send-message/s/${postsTopic.post_ID}" method="post">
                            <br style="clear:both">
                            <div class="form-group">
                                <%--<lable>From User :</lable>--%>
                                <input type="hidden" class="form-control" id="name"  value="${sessionUser.email}" name="fromUserEmail" placeholder="From User's Email" required >
                            </div>
                            <div class="form-group">
                                <%--<lable>To User :</lable>--%>
                                <input type="hidden" class="form-control" id="email" value="${postsTopic.user_ID.email}" name="toUserEmail" placeholder="To User's Email" required >
                            </div>
                            <div class="form-group">
                                <lable>Tiêu đề :</lable>
                                <input type="text" class="form-control" id="subject" name="subject" placeholder="Subject" required>
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
    </div>
</div>
<!-- END # MODAL LOGIN -->
<script src="${js}/jquery.min.js"></script>
<script src="${js}/jquery.poptrox.min.js"></script>
<script src="${js}/jquery.scrolly.min.js"></script>
<script src="${js}/jquery.scrollex.min.js"></script>
<script src="${js}/skel.min.js"></script>
<script src="${js}/util.js"></script>
<script src="${js}/main.js"></script>
<script src="${js}/jquery.js"></script>

<script src="${js}/bootstrap.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="${js}/classie.js"></script>
<script src="${js}/cbpAnimatedHeader.js"></script>
<script src="${js}/jqBootstrapValidation.js"></script>
<script src="${js}/howitwork.js"></script>
<%--<script src="${js}/contact_me.js"></script>--%>
<script type="text/javascript" >
    $(document).ready(function()
    {
        $("#notifylink").click(function()    // onclick function for notification
        {
            $("#notificationContainer").fadeToggle(300);   // show notification div
            $("#msg_count").fadeOut("slow");
            return false;
        });

        //Document Click
        $(document).click(function()
        {
            $("#notificationContainer").hide();     // hide notification div
        });
        //Popup Click
        $("#notificationContainer").click(function()
        {
            return false
        });
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
</body>
</html>