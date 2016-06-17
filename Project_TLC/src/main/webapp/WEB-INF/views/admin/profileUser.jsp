<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="header_admin.jsp" %>
<%
    if (request.getParameter("msgerror") != null) { %>
<div style="margin-top: 100px;" class="alert alert-danger">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <%= request.getParameter("msgerror") %>
</div>
<%
    }
%>
<%
    if (request.getParameter("msginfo") != null) { %>
<div style="margin-top: 100px;" class="alert alert-info">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <%= request.getParameter("msginfo") %>
</div>
<%
    }
%>
<%
    if (request.getParameter("msgsuccess") != null) { %>
<div style="margin-top: 100px;" class="alert alert-success">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <%= request.getParameter("msgsuccess") %>
</div>
<%
    }
%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Pofile User</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
                        <A href="<c:url value="/admin/profile/user/${user.user_ID}/detail"/>" >Edit Profile</A>
                        <A href="<c:url value="/logout" />" >Logout</A>
                        <br>
                        <p class=" text-info">February 16,2016,03:00 pm </p>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">${user.first_Name}. ${user.last_Name}</h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="${upload}/avatar/${user.avatar}" class="img-circle img-responsive"> </div>
                                    <div class=" col-md-9 col-lg-9 ">
                                        <table class="table table-user-information">
                                            <tbody>

                                            <tr>
                                                <td>Department:</td>
                                                <td>${user.job}</td>
                                            </tr>
                                            <tr>
                                                <td>Date of Birth</td>
                                                <td>${user.birthday}</td>
                                            </tr>

                                            <tr>
                                            <tr>
                                                <td>Gender</td>
                                                <c:choose>
                                                    <c:when test="${user.gender == 1}">
                                                        <td>Male</td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td>Female</td>
                                                    </c:otherwise>
                                                </c:choose>
                                            </tr>
                                            <tr>
                                                <td>Home Address</td>
                                                <td>${user.address}</td>
                                            </tr>
                                            <tr>
                                                <td>Email</td>
                                                <td><a href="#">${user.email}</a></td>
                                            </tr>
                                            <tr>
                                                <td>Phone Number</td>
                                                <td>${user.phone_Number}</td>
                                            </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" id="createMessage" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                            <span class="pull-right">
                                <a href="<c:url value="/admin/profile/user/${user.user_ID}/detail"/> " data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                                <%--<a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>--%>
                            </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->
<%--MESSAGE FORM HIDDEN--%>
<div style="z-index: 99999;" class="popup-box chat-popup" id="createDetailMessg">
    <div class="popup-head">
        <div class="popup-head-left pull-left"></div>
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
            <button data-widget="remove" id="removeClass1" class="chat-header-button pull-right" type="button">
                <i class="glyphicon glyphicon-off"></i>
            </button>
        </div>
    </div>
    <div class="popup-messages">
        <div id="form-wrapper">
            <form action="/createmsg/${sessionUser.user_ID}", method="post">
                <div id="form-inner">
                    <input type="hidden" class="form-control" id="fromEmail" value="${sessionUser.email}" name="fromUserEmail" placeholder="From User's Email" required >
                    <label for="name">Subject :</label>
                    <input type="text" class="input" id="name" name="subject" placeholder="Subject">

                    <label for="email">To Email:</label>
                    <input type="email" class="input" id="email" placeholder="" name="toUserEmail" value="${user.email}" />

                    <label for="message">Message:</label>
                    <textarea class="form-control" name="message" type="textarea" id="message" placeholder="Message" maxlength="950" rows="7"></textarea>
                    <span class="help-block"><p id="characterLeft" class="help-block ">You have reached the limit</p></span>

                    <input type="submit" class="button" value="Send message">
                </div>
            </form>
        </div>
    </div>
</div>
<%----%>
<!-- jQuery -->
<script src="${bowercomponents}/jquery/dist/jquery.min.js"></script>
<script src="${bowercomponents}/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${bowercomponents}/metisMenu/dist/metisMenu.min.js"></script>
<script src="${bowercomponents}/datatables/media/js/jquery.dataTables.min.js"></script>
<script src="${bowercomponents}/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
<script src="${dist}/js/sb-admin-2.js"></script>
<script src="${messagejs}/message.js"></script>
<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    $(function(){
        $("#createMessage").click(function () {
            $('#createDetailMessg').addClass('popup-box-on');
        });

        $("#removeClass1").click(function () {
            $('#createDetailMessg').removeClass('popup-box-on');
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

</body>

</html>
