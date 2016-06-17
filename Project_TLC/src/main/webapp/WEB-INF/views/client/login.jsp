<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng Nhập </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- <meta name="keywords" content="Ribbon Login Form Responsive Templates, Iphone Compatible Templates, Smartphone Compatible Templates, Ipad Compatible Templates, Flat Responsive Templates"/> -->
    <spring:url value="/resources/assets/css/" var="css"></spring:url>
    <spring:url value="/resources/assets/js/" var="js"></spring:url>
    <spring:url value="/resources/images/" var="images"></spring:url>
    <!-- <link href="${css}/bootstrap.min.css" rel="stylesheet" /> -->
    <link href="${css}/style_login.css" rel='stylesheet' type='text/css' />
    <!--webfonts-->
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
    <!--/webfonts-->
</head>
<body>
<!--start-main-->
<c:if test="${not empty msgsuccess}">
    <div style="margin-top: 100px;" class="alert alert-success">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
        <p style="color: #1DE418">${msgsuccess}</p>

    </div>
</c:if>
<c:if test="${not empty msgerror}">
    <div style="margin-top: 100px;" class="alert alert-danger">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
        <p style="color: #E91D1D">${msgerror}</p>
    </div>
</c:if>
<c:if test="${not empty msginfo}">
    <div style="margin-top: 100px;" class="alert alert-info">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
        <p style="color: #28C3BE">${msginfo}</p>
    </div>
</c:if>
<%
    if (request.getParameter("msgerror") != null) { %>
<div style="margin-top: 100px;color: #E91D1D" class="alert alert-danger">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <%= request.getParameter("msgerror").toString().replaceAll("\\<.*?>","") %>
</div>
<%
    }
%>
<h1>Welcome!<span>Please login...</span></h1>
<div class="login-box">
    <form action="/checklogin" method="POST" class="login">
        <input type="email" class="text" name="email" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" >
        <input type="password" name="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
        <div class="clear"> </div>
        <div class="btn">
            <input type="submit" value="LOG IN" >
        </div>
        <div class="clear"> </div>
    </form>
    <div class="remember">
        <a href="#"><p>Remember me</p></a>
        <h4>Forgot your password?<a href="#">Click here.</a></h4>
    </div>
</div>
<!--//End-login-form-->
<!--start-copyright-->
<div class="copy-right">
    <p>Template by <a href="http://w3layouts.com">w3layouts</a></p>
</div>
<!--//end-copyright-->



<script src="${js}/jquery.min.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<script>
    // tooltip demo
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    })

    // popover demo
    $("[data-toggle=popover]")
            .popover()
</script>
</body>
</html>