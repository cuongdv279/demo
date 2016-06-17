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
    <div class="container">
        <c:set var="posts_local" value="${posts_local}"/>
        <div class="row">
            <div class="col-md-8" style="border-right: 1px #9d9d9d dotted;padding-right: 25px;">
                <h2><a style="text-decoration: none" href="" class="ubuntu">${posts_local.post_Name}</a></h2>
                <div class="body-text">

                    <p class='text-muted ubuntu'>${posts_local.user_ID.first_Name} ${posts_local.user_ID.last_Name}| ${posts_local.public_Date}</p>
                    <p>
                        <span class="label"><i style="color: #3796a9" class="fa fa-eye">${posts_local.num_View}</i></span>
                        |
                        <span class="label"><i style="color: #3796a9" class="fa fa-comment"></i></span>
                    </p>
                    <br>
                    ${posts_local.post_Content}
                </div>
                <spring:url value="http://wnwapp-wnw.rhcloud.com${requestScope['javax.servlet.forward.request_uri']}" var="url"/>
                <c:choose>
                    <c:when test="${not empty sessionUser}">
                        <spring:url value="/post-user/create-topic-join/${posts_local.post_ID}/add-topic/${sessionUser.user_ID}" var="createTopic"/>
                        <div class="col-md-6">
                            <a style="margin-bottom: 20px;" class="button" href="${createTopic}">Tạo nhóm cho bài viết </a>
                        </div>
                        <div class="col-md-6">
                            <div class="fb-like" data-href="${url}" data-layout="box_count" data-action="like" data-show-faces="true" data-share="true"></div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <spring:url value="/post-user/create-topic-join/${posts_local.post_ID}/add-topic/none" var="createTopicsessionnone"/>
                        <div class="col-md-6">
                            <a style="margin-bottom: 20px; text-decoration: none" class="button" href="${createTopicsessionnone}">Tạo nhóm cho bài viết </a>
                        </div>
                        <div class="col-md-6">
                            <div class="fb-like" data-href="${url}" data-layout="box_count" data-action="like" data-show-faces="true" data-share="true"></div>
                        </div>
                    </c:otherwise>
                </c:choose>
                <%--Comment facebook--%>
                <div class="fb-comments" data-href="${url}" data-width="100%" data-numposts="5"></div>
                <%--//--%>
            </div>
            <div class="col-md-4 margin-top-25">
                <div class="panel panel-default">
                    <div class="panel-heading"><b>Nhóm liên quan</b></div>
                    <ul class="media-list main-list event-list">
                        <c:forEach var="listPostInPostLocal" items="${listPostInPostLocal }" varStatus="status">
                            <li class="media">
                                <time datetime="2014-07-20 0000">
                                    <span class="day">8</span>
                                    <span class="month">Jul</span>
                                    <span class="year">2014</span>
                                    <span class="time">12:00 AM</span>
                                </time>
                                <div class="info media-body">
                                    <spring:url value="/post-user/infor-post-topic/${listPostInPostLocal.post_ID}" var="inforpostrelated"/>
                                    <a href="${inforpostrelated}" alt="$listPostInPostLocal.post_Name}"><h4 class="title">${fn:substring(listPostInPostLocal.post_Name,0,25)}</h4></a>
                                    <p class="desc">${fn:substring(listPostInPostLocal.post_Content,0,20)}...</p>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="col-lg-12 text-center jPager">
                    <div class="col-md-12">
                        <ul id="pagination" class="">
                            <c:set var="total" value="${num_page}"/>
                            <c:set var="page" value="${page}"/>
                            <c:set var="page_pre" value="${pre}"/>
                            <c:set var="page_next" value="${next}"/>
                            <c:set var="last" value="${last}"/>
                            <li id = "first" class="">
                                <spring:url value="/post-event/info-post/${posts_local.post_ID}/page/0" var="inforpostfirst"/>
                                <a href="${inforpostfirst}">Đầu</a>
                            </li>
                            <li id = "previous" class="">
                                <spring:url value="/post-event/info-post/${posts_local.post_ID}/page/${page_pre }" var="inforpostpre"/>
                                <a href="${inforpostpre}"><</a>
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
                                <spring:url value="/post-event/info-post/${posts_local.post_ID}/page/${page_next }" var="inforpostnext"/>
                                <a href="${inforpostnext}">></a>
                            </li>
                            <li id = "last" class="">
                                <spring:url value="/post-event/info-post/${posts_local.post_ID}/page/${last }" var="inforpostlast"/>
                                <a href="${inforpostlast}">Cuối</a>
                            </li>
                        </ul>
                    </div>
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