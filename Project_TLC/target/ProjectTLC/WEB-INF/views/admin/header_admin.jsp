<%--
  Created by IntelliJ IDEA.
  User: CHIP_IT_DVC
  Date: 22/02/2016
  Time: 9:59 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="author" content="">
    <%--<meta http-equiv="refresh" content="60" />--%>

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <spring:url value="/resources/bower_components/" var="bowercomponents"></spring:url>
    <spring:url value="/resources/dist/" var="dist"></spring:url>
    <spring:url value="/resources/images/" var="images"></spring:url>
    <spring:url value="/resources/upload/" var="upload"></spring:url>
    <spring:url value="/resources/assets/css/messageCss.css" var="messagecss"></spring:url>
    <spring:url value="/resources/assets/js/" var="messagejs"></spring:url>
    <!-- Finish adding tags -->
    <link href="${bowercomponents}/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${bowercomponents}/metisMenu/dist/metisMenu.min.css" rel="stylesheet" />
    <link href="${bowercomponents}/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet" />
    <link href="${bowercomponents}/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet" />
    <link href="${dist}/css/sb-admin-2.css" rel="stylesheet" />
    <link href="${bowercomponents}/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="${messagecss}" rel="stylesheet" />

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
            <a class="navbar-brand" href="<c:url value="/"/>">WELCOME ${sessionUser.first_Name}</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="<c:url value="/admin/profile/user/${sessionUser.user_ID}"/>"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="<c:url value="/logout" />"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                        <a href="<c:url value="/"/>"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-users fa-fw"></i> Manage User<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<c:url value="/admin/all/user"/>"><i class="fa fa-users fa-fw"></i> All User</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/all/user/enable"/>"><i class="fa fa-user fa-fw"></i> User Enable</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/all/user/disable"/>"><i class="fa fa-user-times fa-fw"></i> User Disable</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/all/user/createuser"/>"><i class="fa fa-user-plus fa-fw"></i> Create User</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-table fa-fw"></i> Manage User's Post<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<c:url value="/admin/all/topicuser"/>"><i class="fa fa-file-text-o fa-fw"></i> All Post</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/publicTopic/topicuser"/>"><i class="fa fa-file-text-o fa-fw"></i> Post Enable</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/binTopic/topicuser"/>"><i class="fa fa-file-text-o fa-fw"></i> Post Disable</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-table fa-fw"></i> Manage Admin's Post<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<c:url value="/admin/all/allpost"/>"><i class="fa fa-file-text-o fa-fw"></i> All Post</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/all/allpost/enable"/>"> <i class="fa fa-file-text-o fa-fw"></i> Post Enable</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/all/allpost/disable"/>"><i class="fa fa-file-text-o fa-fw"></i> Post Disable</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/all/allpost/createpost"/>"><i class="fa fa-pencil-square-o fa-fw"></i> Create Post</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-wrench fa-fw"></i> Manage Elements<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#"><i class="fa fa-bicycle fa-fw"></i> Categories<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="<c:url value="/admin/listCate"/>"><i class="fa fa-file-text-o fa-fw"></i> All Categories</a>
                                    </li>
                                    <li>
                                        <a href="<c:url value="/admin/cate/create"/>"><i class="fa fa-pencil-square-o fa-fw"></i> Create Categories</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-picture-o fa-fw"></i> Images</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-envelope fa-fw"></i> Messages<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#"><i class="fa fa-envelope fa-fw"></i> List Messages<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="<c:url value="/admin/all/new-messages/${sessionUser.user_ID}"/>"><i class="glyphicon glyphicon-message-in"></i>New Messages </a>
                                        <%--<i class="fa fa-envelope fa-fw"></i><i class="fa fa-arrow-left"></i>--%>
                                    </li>
                                    <li>
                                        <a href="<c:url value="/admin/all/seen-messages/${sessionUser.user_ID}"/>"><i class="glyphicon glyphicon-message-full"></i>Read Messages</a>
                                        <%--<i class="fa fa-envelope fa-fw"></i>--%>
                                    </li>
                                    <li>
                                        <a href="<c:url value="/admin/all/sent-messages/${sessionUser.user_ID}"/>"><i class="glyphicon glyphicon-message-out"></i> Messages Sent </a>
                                        <%--<i class="fa fa-envelope fa-fw"></i><i class="fa fa-arrow-right"></i>--%>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#" id="addClass"><i class="glyphicon glyphicon-message-plus"></i> Create Messages</a>
                                <%--<i class="fa fa-pencil-square-o fa-fw"></i>--%>
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

    <%--MESSAGE FORM HIDDEN--%>
    <div style="z-index: 99999;" class="popup-box chat-popup" id="qnimate">
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
                <button data-widget="remove" id="removeClass" class="chat-header-button pull-right" type="button">
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
                        <input type="email" class="input" id="email" placeholder="" name="toUserEmail" />

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