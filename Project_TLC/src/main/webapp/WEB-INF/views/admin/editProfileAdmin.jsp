<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
                <h1 class="page-header">Information User</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        User Details
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <form action="<c:url value="/admin/profile/admin/edit"/>"  method="POST" role="form" enctype="multipart/form-data">
                                <div class="form-group">
                                    <%--<label>User ID</label>--%>
                                    <input class="form-control"  name="userID" type="hidden"   value="${user.user_ID}">
                                </div>
                                <div class="form-group">
                                    <label>First Name</label>
                                    <input class="form-control" name="firstName" type="text"  value="${user.first_Name}">
                                </div>
                                <div class="form-group">
                                    <label>Last Name</label>
                                    <input class="form-control" name="lastName" type="text"  value="${user.last_Name}">
                                </div>
                                <div class="form-group">
                                    <label>Gender</label>
                                    <select name="gender" class="form-control">
                                        <%--<option value="0">Male</option>--%>
                                        <%--<option value="1">Felmale</option>--%>
                                        <c:choose>
                                            <c:when test="${user.gender == 0}">
                                                <option name="gender" value="${user.gender}" selected = "selected">Male</option>
                                                <option name="gender" value="1">Female</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option name="gender" value="${user.gender}" selected = "selected">Female</option>
                                                <option name="gender" value="0">Male</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>User Role </label>
                                    <select name="role" class="form-control">
                                        <%--<option value="ROLE_ADMIN">ROLE_ADMIN</option>--%>
                                        <%--<option value="ROLE_USER">ROLE_USER</option>--%>
                                        <c:choose>
                                            <c:when test="${user.user_Role == 'ROLE_ADMIN'}">
                                                <option name="role" value="${user.user_Role}" selected = "selected">ROLE_ADMIN</option>
                                                <option name="role" value="ROLE_USER">ROLE_USER</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option name="role" value="${user.user_Role}" selected = "selected">ROLE_USER</option>
                                                <option name="role" value="ROLE_ADMIN">ROLE_ADMIN</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input class="form-control" type="text" disabled="true" value="${user.email}">
                                </div>
                                <div class="form-group">
                                    <label>Activation Date </label>
                                    <input class="form-control" type="text" disabled="true" value="${user.activation_Date}">
                                </div>
                                <div class="form-group">
                                    <label>Avatar</label>
                                    <input name="file" type="file">
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <input class="form-control" type="text" name="address"  value="${user.address}">
                                </div>
                                <div class="form-group">
                                    <label>Phone Number</label>
                                    <input class="form-control" type="text" name="numberPhone"  value="${user.phone_Number}">
                                </div>
                                <div class="form-group">
                                    <label>Birthday (Format: dd/MM/YYYY or YYYY-MM-dd)</label>
                                    <input class="form-control" name="birthday" type="date"  value="${user.birthday}">
                                </div>
                                <div class="form-group">
                                    <label>Job</label>
                                    <input class="form-control" name="job" type="text"  value="${user.job}">
                                </div>
                                <div class="form-group">
                                    <label>Country </label>
                                    <input class="form-control" name="country" type="text"  value="${user.country}">
                                </div>
                                <div class="form-group">
                                    <label>Website </label>
                                    <input class="form-control" name="website" type="text"  value="${user.website}">
                                </div>
                                <div class="form-group">
                                    <label>Status</label>
                                    <select name="status" class="form-control">
                                        <%--<option value="Pending">Pending</option>--%>
                                        <%--<option value="Enable">Enable</option>--%>
                                        <%--<option value="Disable">Disable</option>--%>
                                        <c:if test="${user.status == 0}" >
                                            <option name="status" value="0" selected="selected">Pending</option>
                                            <option name="status" value="1">Enable</option>
                                            <option name="status" value="3">Disable</option>
                                        </c:if>
                                        <c:if test="${user.status == 1}" >
                                            <option name="status" value="0">Pending</option>
                                            <option name="status" value="1" selected="selected">Enable</option>
                                            <option name="status" value="3">Disable</option>
                                        </c:if>
                                        <c:if test="${user.status == 3}" >
                                            <option name="status" value="0">Pending</option>
                                            <option name="status" value="1">Enable</option>
                                            <option name="status" value="3" selected="selected">Disable</option>
                                        </c:if>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-default">SAVE</button>
                            </form>
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




