<%--
  Created by IntelliJ IDEA.
  User: CHIP_IT_DVC
  Date: 22/02/2016
  Time: 11:01 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <spring:url value="/resources/bower_components/" var="bowercomponents"></spring:url>
    <spring:url value="/resources/dist/" var="dist"></spring:url>
    <spring:url value="/resources/images/" var="images"></spring:url>
    <!-- Finish adding tags -->
    <link href="${bowercomponents}/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${bowercomponents}/metisMenu/dist/metisMenu.min.css" rel="stylesheet" />
    <link href="${bowercomponents}/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet" />
    <link href="${bowercomponents}/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet" />
    <link href="${dist}/css/sb-admin-2.css" rel="stylesheet" />
    <link href="${bowercomponents}/font-awesome/css/font-awesome.min.css" rel="stylesheet" />


</head>

<body>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">SB Admin v2.0</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                        <!-- /input-group -->
                    </li>
                    <li>
                        <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Manage User<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="listUser.html">All User</a>
                            </li>
                            <li>
                                <a href="listUserEnable.html">User Enable</a>
                            </li>
                            <li>
                                <a href="listUserDisable.html">User Disable</a>
                            </li>
                            <li>
                                <a href="addUser.html">Create User</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-table fa-fw"></i> Manage User's Post<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="allPostUser.html">All Post</a>
                            </li>
                            <li>
                                <a href="allPostUserEnable.html">Post Enable</a>
                            </li>
                            <li>
                                <a href="allPostUserDisable.html">Post Disable</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i> Manage Admin's Post<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="allPostAdmin.html">All Post</a>
                            </li>
                            <li>
                                <a href="allPostAdminEnable.html">Post Enable</a>
                            </li>
                            <li>
                                <a href="allPostAdminDisable.html">Post Disable</a>
                            </li>
                            <li>
                                <a href="createPostAdmin.html">Create Post</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-wrench fa-fw"></i> Manage Elements<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Categories</a>
                            </li>
                            <li>
                                <a href="#">Images</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>
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
                <h1 class="page-header">List Admin's Post</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        DataTables Admin's Post Disable
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>NO.</th>
                                    <th>Post ID</th>
                                    <th>Post Name</th>
                                    <th>User ID</th>
                                    <th>Status</th>
                                    <th>Last Edit</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="odd gradeX">
                                    <td>1</td>
                                    <td>1</td>
                                    <td><a href="editPostAdmin.html">Travel Hoi An</a></td>
                                    <td><a href="editUser.html">1</a></td>
                                    <td>Enable</td>
                                    <td>11/01/2016</td>
                                    <td>
                                        <a class="btn" href="editPostAdmin.html" >Edit</a>
                                        <span>|</span>
                                        <a class="btn" href="#" >Delete</a>
                                    </td>
                                </tr>
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

