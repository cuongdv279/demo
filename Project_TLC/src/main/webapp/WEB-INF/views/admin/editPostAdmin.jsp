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
                        Post Details
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <form action="<c:url value="/admin/all/allpost/edit"/>" method="POST" role="form" enctype="multipart/form-data">
                                <div class="form-group">
                                    <%--<label>Title Post<span style="color: red"> *</span></label>--%>
                                    <input class="form-control" name="postID" value="${postsLocal.post_ID}" type="hidden" required="true" >
                                </div>
                                <div class="form-group">
                                    <label>Title Post<span style="color: red"> *</span></label>
                                    <input class="form-control" name="postName" value="${postsLocal.post_Name}" type="text" required="true" >
                                </div>
                                <div class="form-group">
                                    <label>Categories<span style="color: red"> *</span></label>
                                    <select class="form-control" id="" name="categories">
                                        <c:forEach var="categoriesList" items="${categoriesList }" varStatus="status">
                                            <c:choose>
                                                <c:when test="${postsLocal.cate_ID.cateId == categoriesList.cateId}">
                                                    <option id="categories" name="categories" value="${categoriesList.cateId}" selected = "selected">${categoriesList.cateName }</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option id="categories" name="categories" value="${categoriesList.cateId}">${categoriesList.cateName }</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Description<span style="color: red"> *</span></label>
                                    <textarea class="form-control textarea ckeditor" rows="3" name="description" id="content" placeholder="Content">${postsLocal.post_Content}</textarea>
                                </div>
                                <div class="form-group">
                                    <label>Photo</label>
                                    <input type="file" name="file">
                                </div>
                                <div class="form-group">
                                    <label>Status</label>
                                    <select name="status" class="form-control">
                                        <option name="status" value="0">Pending</option>
                                        <option name="status" value="1">Enable</option>
                                        <option name="status" value="3">Disable</option>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-default">Save</button>
                                <button type="reset" class="btn btn-default">Reset</button>
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
<spring:url value="/resources/assets/ckeditor/ckeditor.js" var="ckeditor"></spring:url>
<script src="${bowercomponents}/jquery/dist/jquery.min.js"></script>
<script src="${bowercomponents}/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${bowercomponents}/metisMenu/dist/metisMenu.min.js"></script>
<script src="${bowercomponents}/datatables/media/js/jquery.dataTables.min.js"></script>
<script src="${bowercomponents}/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
<script src="${dist}/js/sb-admin-2.js"></script>
<script src="${ckeditor}"></script>

<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
</script>

</body>

</html>

