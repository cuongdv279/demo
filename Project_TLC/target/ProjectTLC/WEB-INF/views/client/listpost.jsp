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
                <c:forEach var="postLocal" items="${listPostLocal }" varStatus="status">
                <div class="panel">
                    <div class="panel-heading">
                        <div class="text-center">
                            <div class="row">
                                <div class="col-sm-9">
                                    <h3 class="pull-left">${postLocal.post_Name}</h3>
                                </div>
                                <div class="col-sm-3">
                                    <h4 class="pull-right">
                                        <small><em>${postLocal.public_Date}</em></small>
                                    </h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <spring:url value="/post-event/info-post/${postLocal.post_ID}" var="inforpost"/>
                        <a href="${inforpost}" class="thumbnail">
                            <img alt="Image" src="${upload}imgPostLocal/${postLocal.image }">
                        </a>
                        <div class="row">
                            <p>${fn:substring(postLocal.post_Content,0,250)}... <a href="${inforpost}"> Xem thêm </a></p>
                        </div>

                    </div>
                    <div>
                        <span class="label"><i style="color: #3796a9" class="fa fa-eye">${postLocal.num_View}</i></span>
                        <span class="label"><i style="color: #3796a9" class="fa fa-comment"></i></span>
                    </div>
                </div>
                </c:forEach>
            <%--</div>--%>

            <div class="col-lg-12 text-center jPager">
                <div class="col-md-6">
                    <ul id="pagination" class="">
                        <c:set var="total" value="${num_page}"/>
                        <c:set var="page" value="${page}"/>
                        <spring:url value="/post-event/post/0" var="first" />
                        <spring:url value="/post-event/post/${pre}" var="page_pre" />
                        <spring:url value="/post-event/post/${next}" var="page_next" />
                        <spring:url value="/post-event/post/${last}" var="last" />
                        <li id = "first" class="">
                                <a href="${first }" onclick="this.disabled = true">Đầu</a>
                        </li>
                        <li id = "previous" class="">
                            <a href="${page_pre }"><</a>
                        </li>
                        <c:choose>
                            <c:when test="${total == 0}">
                                <li><span id="current_page">0</span>/<span id="total_page">0</span></li>
                            </c:when>
                            <c:otherwise>
                                <li><span id="current_page"><c:out value="${page}"/></span>/<span id="total_page"><c:out value="${total}"/></span></li>
                            </c:otherwise>
                        </c:choose>
                        <li id="next" class="">
                            <a href="${page_next }">></a>
                        </li>
                        <li id = "last" class="">
                            <a href="${last }" onclick="this.disabled = true">Cuối</a>
                        </li>
                    </ul>
                </div>
            </div>
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