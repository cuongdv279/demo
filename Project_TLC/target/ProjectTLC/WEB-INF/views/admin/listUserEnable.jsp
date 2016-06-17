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
                <h1 class="page-header">List User</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        DataTables User Enable
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>NO.</th>
                                    <th>User ID</th>
                                    <th>Email</th>
                                    <th>Status</th>
                                    <th>Date active</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="allUser" items="${allUser }" varStatus="status">
                                    <tr class="odd gradeX">
                                        <td>${status.index + 1 }</td>
                                        <td><a href="<c:url value="/admin/profile/user/${allUser.user_ID}"/>">${allUser.user_ID}</a></td>
                                        <td>${allUser.email}</td>
                                        <c:if test="${allUser.status == 0}">
                                            <td>Draft</td>
                                        </c:if>
                                        <c:if test="${allUser.status == 1}">
                                            <td>Enable</td>
                                        </c:if>
                                        <c:if test="${allUser.status == 3}">
                                            <td>Disable</td>
                                        </c:if>
                                        <td>${allUser.activation_Date}</td>
                                        <td>
                                            <a class="btn" href="<c:url value="/admin/all/user/${allUser.user_ID}"/>" >Edit</a>
                                            <span>|</span>
                                            <a class="btn" href="#" >Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
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
<!-- /#wrapper -->

<!-- jQuery -->
<script src="${bowercomponents}/jquery/dist/jquery.min.js"></script>
<script src="${bowercomponents}/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${bowercomponents}/metisMenu/dist/metisMenu.min.js"></script>
<script src="${bowercomponents}/datatables/media/js/jquery.dataTables.min.js"></script>
<script src="${bowercomponents}/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
<script src="${dist}/js/sb-admin-2.js"></script>

<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
</script>

</body>

</html>

