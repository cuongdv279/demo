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
                <h1 class="page-header">Information Post</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Message
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <div class="panel-body">
                                <div style="padding-right: 15px;padding-left: 15px;margin-right: auto;margin-left: auto;">
                                    <div style="">
                                        <a href="#" style="width: 250px;margin: 0;padding: 0;float: left !important;color: #428bca;
                                    text-decoration: none;background-color: transparent;">
                                            <img src="${upload}avatar/${message.toUserID.avatar}"
                                                 style="float: left !important;height: 40px;margin-top: 5px;margin:0;padding:0;" alt="image" title="${message.toUserID.first_Name}" />
                                        </a>
                                        <b>${message.subject}</b>
                                    </div>
                                    <div style="margin-right: -15px; margin-left: -15px;">
                                        <div style="width: 100%;float: left;position: relative; min-height: 1px; padding-right: 15px; padding-left: 15px;box-sizing: border-box;">
                                            <div style="border-radius: 3px; box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
                            padding: 15px 25px; text-align: left; display: block; margin-top: 15px;margin-bottom: 10px;box-sizing: border-box;">
                                                ${message.content}
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
                                            <a href="#" id="createMessage"><span class="glyphicon glyphicon-comment"></span> Create Message </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>

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
                    <input type="email" class="input" id="email" placeholder="" name="toUserEmail" value="${message.toUserID.email}" />

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
<spring:url value="/resources/assets/ckeditor/ckeditor.js" var="ckeditor"></spring:url>
<script src="${bowercomponents}/jquery/dist/jquery.min.js"></script>
<script src="${bowercomponents}/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${bowercomponents}/metisMenu/dist/metisMenu.min.js"></script>
<script src="${bowercomponents}/datatables/media/js/jquery.dataTables.min.js"></script>
<script src="${bowercomponents}/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
<script src="${dist}/js/sb-admin-2.js"></script>
<script src="${ckeditor}"></script>
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

