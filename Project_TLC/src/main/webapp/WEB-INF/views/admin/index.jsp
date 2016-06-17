<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="header_admin.jsp" %>
    <div id="page-wrapper">

        <div class="row">
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
            <div class="col-lg-12">
                <h1 class="page-header">Dashboard</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-3 col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-files-o fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge">${countPostTopicDraft}</div>
                                <div>The post  of user waiting for approval.</div>
                            </div>
                        </div>
                    </div>
                    <a href="<c:url value="/admin/listtopic/draft" />">
                        <div class="panel-footer">
                            <span class="pull-left">View Details</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="panel panel-green">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-users fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge">${countNewMember}</div>
                                <div>New member</div>
                            </div>
                        </div>
                    </div>
                    <a href="<c:url value="/admin/all/user"/>">
                        <div class="panel-footer">
                            <span class="pull-left">View Details</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="panel panel-yellow">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-files-o fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge">${countPostLocal}</div>
                                <div>The post  of admin waiting for approval.</div>
                            </div>
                        </div>
                    </div>
                    <a href="<c:url value="admin/all/allpost/draft"/>">
                        <div class="panel-footer">
                            <span class="pull-left">View Details</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="panel panel-red">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <%--<i class="fa fa-comments-o fa-5x"></i>--%>
                                <%--<i class="fa fa-bell-o fa-5x"></i>--%>
                                <i class="fa fa-envelope fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge">${countNewMessages}</div>
                                <div>Messages</div>
                            </div>
                        </div>
                    </div>
                    <a href="<c:url value="admin/all/new-messages/${sessionUser.user_ID}"/>">
                        <div class="panel-footer">
                            <span class="pull-left">View Details</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

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
</script>

</body>

</html>
