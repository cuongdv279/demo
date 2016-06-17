<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<c:set var="user" value="${user}"/>--%>
<c:choose>
    <c:when test="${not empty sessionUser}">
        <%@include file="header-user.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="header-guest-home.jsp" %>
    </c:otherwise>
</c:choose>
<div class="container margin-top-25">
    <div class="row">
        <div class="col-md-8">
            <%--<div class="panel">--%>
                <h4>Không có bài viết !</h4>
            <%--</div>--%>

        </div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">Danh sách địa điểm</div>
                <ul class="media-list main-list">
                    <c:forEach var="allCategories" items="${allCategories }" varStatus="status">
                        <li class="media">
                            <a class="pull-left" href="/post-event/post/fl/categories/${allCategories.cateId}/page/0">${allCategories.cateName}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Bài viết mới nhất</div>
                <ul class="media-list main-list">
                    <c:forEach var="listLatestPostLocal" items="${listLatestPostLocal }" varStatus="status">
                        <spring:url value="/post-event/info-post/${listLatestPostLocal.post_ID}" var="inforpostlast"/>
                        <li class="media">
                            <a class="pull-left" href="${inforpostlast}">
                                <img style="width: 150px; height: 90px;" class="media-object" src="${upload}imgPostLocal/${listLatestPostLocal.image }" alt="">
                            </a>
                            <div class="media-body">
                                <a href="${inforpostlast}">
                                    <h4 class="media-heading">${listLatestPostLocal.post_Name} </h4>
                                </a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
<footer id="footer">

    <!-- Icons -->
        <ul class="actions">
            <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
            <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
            <li><a href="#" class="icon fa-google-plus"><span class="label">Google+</span></a></li>
            <li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
            <li><a href="#" class="icon fa-pinterest"><span class="label">Pinterest</span></a></li>
            <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
        </ul>

    <!-- Menu -->
        <ul class="menu">
            <li>&copy; Untitled</li><li>Design: <a href="#">CuongDV</a></li>
        </ul>

</footer>
<script src="${js}/jquery.min.js"></script>
<script src="${js}/jquery.poptrox.min.js"></script>
<script src="${js}/jquery.scrolly.min.js"></script>
<script src="${js}/jquery.scrollex.min.js"></script>
<script src="${js}/skel.min.js"></script>
<script src="${js}/util.js"></script>
<script src="${js}/main.js"></script>

<script src="${js}/jquery.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="${js}/classie.js"></script>
<script src="${js}/cbpAnimatedHeader.js"></script>
<script src="${js}/jqBootstrapValidation.js"></script>
<%--<script src="${js}/contact_me.js"></script>--%>
<script src="${js}/howitwork.js"></script>
<script type="text/javascript" >
    $(document).ready(function()
    {
        $("#notifylink").click(function()    // onclick function for notification
        {
            $("#notificationContainer").fadeToggle(300);   // show notification div
            $("#msg_count").fadeOut("slow");
            return false;
        });

        //Document Click
        $(document).click(function()
        {
            $("#notificationContainer").hide();     // hide notification div
        });
        //Popup Click
        $("#notificationContainer").click(function()
        {
            return false
        });
        var current_page = $('#current_page').text();
        var total_page = $('#total_page').text();
        $(function() {
            if( (current_page == total_page && total_page == 0)||(current_page == total_page && total_page == 1)){
                $('#previous').attr({"class" : "disable"});
                $('#first').attr({"class" : "disable"});
                $('#next').attr({"class" : "disable"});
                $('#last').attr({"class" : "disable"});
            } else if(current_page == 1 && current_page < total_page){
                $('#previous').attr({"class" : "disable"});
                $('#first').attr({"class" : "disable"});
            } else if(current_page == total_page && current_page > 1){
                $('#next').attr({"class" : "disable"});
                $('#last').attr({"class" : "disable"});
            }
        });
    });
</script>
</body>
</html>