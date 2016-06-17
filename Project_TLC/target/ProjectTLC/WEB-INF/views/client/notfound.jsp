<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<c:set var="user" value="${user}"/>--%>
<c:choose>
    <c:when test="${not empty sessionUser}">
        <%@include file="header-user.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="header-guest-home.jsp" %>
    </c:otherwise>
</c:choose>
<!-- Services Section -->
<section  class="bg-light-gray">
    <div class="container" style="padding-top: 40px;">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading">Danh sách các nhóm !</h2>
                <h3 class="section-subheading text-muted">Hãy tìm kiếm nhóm và đến những nơi bạn thích !</h3>
            </div>
        </div>
        <div class="row text-center">
            <div class="col-md-4"></div>
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <form class="form-inline" role="form" action="/post-user/post-topic/search" method="POST">
                    <div class="form-group">
                        <select class="form-control" name="cateID">
                            <c:forEach var="allCategories" items="${allCategories }" varStatus="status">
                                <option name="cateID" value="${allCategories.cateId}">${allCategories.cateName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-search"></span> Tìm kiếm
                    </button>
                </form>
            </div>
        </div>
        <div class="row ">
            <div class="col-md-8">
                Không có bài viết !
            </div>
            <!-- Code list các topic -->
            <div class="col-md-4 fixed">
                <div class="panel panel-default">
                    <div class="panel-heading">Nhóm mới nhất</div>
                    <ul class="media-list main-list event-list">
                        <c:forEach var="listLatestPostTopic" items="${listLatestPostTopic }" varStatus="status">
                            <li class="media">
                                <time datetime="2014-07-20 0000">
                                    <span class="day">8</span>
                                    <span class="month">Jul</span>
                                    <span class="year">2014</span>
                                    <span class="time">12:00 AM</span>
                                </time>
                                <div class="info media-body">
                                    <a href="/post-user/infor-post-topic/${listLatestPostTopic.post_ID}"><h4 class="title">${listLatestPostTopic.post_Name}</h4></a>
                                    <p class="desc">${fn:substring(listLatestPostTopic.post_Content,0,20)}... </p>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Footer -->
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
<script src="${js}/jquery.js"></script>
<script src="${js}/jquery.min.js"></script>
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
    });
</script>
</body>
</html>