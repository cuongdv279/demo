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
                <h1 class="page-header">Information User's Post Draft</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Post Draft Details
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <div class="row">
                                <div class="col-md-4">
                                    <h5><b>Description</b></h5>
                                </div>
                                <div class="col-md-8">
                                    ${post.post_Content}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-md-4">
                                    <h5><b>Time</b></h5>
                                </div>
                                <div class="col-md-8">
                                    <p>Check In : ${post.date_Start}</p>
                                    <p>Check Out: ${post.date_End}</p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-md-4">
                                    <h5><b>Rules</b></h5>
                                </div>
                                <div class="col-md-8">
                                    ${post.rule}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-md-4">
                                    <h5><b>Some Photos</b></h5>
                                </div>
                                <div class="col-md-8">
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
                                        <div class="project-wrapper">
                                            <div class="project">
                                                <div class="photo-wrapper">
                                                    <div class="photo">
                                                        <a class="fancybox" href="${upload}/imgPostTopic/${post.image}"><img class="img-responsive" src="${upload}/imgPostTopic/${post.image}" alt=""></a>
                                                    </div>
                                                    <div class="overlay"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div><!-- col-lg-4 -->
                                </div>
                            </div>
                            <div class="row">
                                <form action="<c:url value="/admin/binTopic/topicuser/${post.post_ID}/edit"/>" method="POST" role="form">
                                    <div class="form-group">
                                        <input class="form-control" type="hidden" name="post_ID" value="1">
                                    </div>
                                    <div class="form-group">
                                        <!-- <div class="row"> -->
                                        <div class="col-md-4">
                                            <label>Status</label>
                                        </div>
                                        <div class="col-md-8">
                                            <select name="status" class="form-control">
                                                <option name="status" value="0">Pending</option>
                                                <option name="status" value="1">Enable</option>
                                                <option name="status" value="3">Disable</option>
                                            </select>
                                        </div>
                                        <!-- </div> -->
                                    </div>
                                    <div class="form-group">
                                        <!-- <div class="row"> -->
                                        <div class="col-md-4">
                                        </div>
                                        <div class="col-md-8">
                                            <br/>
                                            <button type="submit" class="btn btn-default">SAVE</button>
                                        </div>
                                    </div>
                                </form>

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




