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
                            <form action="<c:url value="/admin/all/user/createuser/add"/>" method="post"  role="form" enctype="multipart/form-data">
                                <div class="form-group">
                                    <c:if test="${not empty msg}">
                                        <span style="color: #9f191f">${msg}</span>
                                    </c:if>
                                </div>
                                <div class="form-group">
                                    <label>First Name<span style="color: red"> *</span></label>
                                    <input class="form-control" name="firsName" type="text" required="true" >
                                </div>
                                <div class="form-group">
                                    <label>Last Name<span style="color: red"> *</span></label>
                                    <input class="form-control" name="lastName" type="text" required="true"  >
                                </div>
                                <div class="form-group">
                                    <label>Gender<span style="color: red"> *</span></label>
                                    <select name="gender" class="form-control" required="true">
                                        <option name="gender" value="0">Male</option>
                                        <option name="gender" value="1">Felmale</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>User Role<span style="color: red"> *</span></label>
                                    <select name="role" class="form-control" required="true">
                                        <option name="role" value="ROLE_ADMIN">ROLE_ADMIN</option>
                                        <option name="role" value="ROLE_USER">ROLE_USER</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Email<span style="color: red"> *</span></label>
                                    <input class="form-control" name="email" type="text" required="true">
                                </div>
                                <div class="form-group">
                                    <label>Password<span style="color: red"> *</span></label>
                                    <input class="form-control" name="password" type="password" required="true">
                                </div>
                                <div class="form-group">
                                    <label>Re-Password<span style="color: red"> *</span></label>
                                    <input class="form-control" name="repassword" type="password" required="true">
                                </div>
                                <div class="form-group">
                                    <label>Avatar</label>
                                    <input name="avatar" type="file">
                                </div>
                                <div class="form-group">
                                    <label>Address<span style="color: red"> *</span></label>
                                    <input class="form-control" name="address" type="text" required="true" >
                                </div>
                                <div class="form-group">
                                    <label>Phone Number<span style="color: red"> *</span></label>
                                    <input class="form-control" name="phonenumber" type="text" >
                                </div>
                                <div class="form-group">
                                    <label>Birthday<span style="color: red"> *</span></label>
                                    <input class="form-control" name="birthday" placeholder="dd/MM/YYYY" type="date" required="true" >
                                </div>
                                <div class="form-group">
                                    <label>Job</label>
                                    <input class="form-control" name="job" type="text" >
                                </div>
                                <div class="form-group">
                                    <label>Country<span style="color: red"> *</span></label>
                                    <input class="form-control" name="country" type="text" required="true" >
                                </div>
                                <div class="form-group">
                                    <label>Website</label>
                                    <input class="form-control" name="website" type="text" >
                                </div>
                                <div class="form-group">
                                    <label>Status<span style="color: red"> *</span></label>
                                    <select class="form-control" name="status" required="true">
                                        <option name="status" value="0">Pending</option>
                                        <option name="status" value="1">Enable</option>
                                        <option name="status" value="3">Disable</option>
                                    </select>
                                </div>

                                <button type="submit" class="btn btn-default">SAVE</button>
                                <button type="reset" class="btn btn-default">RESET</button>
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

