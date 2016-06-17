<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <!-- Intro -->
            <section id="intro" class="main style1 dark fullscreen">
                <div class="content container 75%">
                    <header>
                        <h2>Welcome to WnW</h2>
                        <h2>"Who - When - Where"</h2>
                        <h3>Khám phá những điều mới mẽ với những người bạn mới !</h3>
                    </header>
                    <p>Tiết kiệm hơn, vui vẻ hơn, sảng khoái hơn</p>
                    <footer>
                        <a href="#one" class="button style2 down">Xem thêm</a>
                    </footer>
                </div>
            </section>
<!-- One -->
            <section id="one" class="main style2 right dark fullscreen">
                <div class="content box style2">
                    <form action="<c:url value="/post-user/post-topic" />" method="POST">
                        <!-- <header> -->
                        <h2>Tạo và tham gia những nhóm du lịch mà bạn thích.</h2>
                        <!-- </header> -->
                        <p>Hãy tìm những nhóm di lịch làm bạn thích thú, đến nơi bạn muốn nào !</p>
                        <button>Xem thêm</button>
                    </form>
                </div>
                <a href="#two" class="button style2 down anchored">Tiếp</a>
            </section>

<!-- Two -->
            <section id="two" class="main style2 left dark fullscreen">
                <div class="content box style2">
                    <form action="<c:url value="/post-event/post" />" method="POST">
                        <!-- <header> -->
                        <h2>Tìm kiếm những địa điểm và những sự kiện thú vị.</h2>
                        <!-- </header> -->
                        <p>Hãy xem nhưng địa điểm và sự kiện đang và sắp xãy ra để vui chơi nhé !</p>
                        <button>Xem thêm</button>
                    </form>
                </div>
                <a href="#work" class="button style2 down anchored">Tiếp</a>
            </section>

        <!-- Work -->
            <section id="work" class="main style3 primary">
                <div class="content container">
                    <!-- <header> -->
                        <h2>Khám phá thế giới !</h2>
                    <p>Những nơi bạn có thể khám phá với những điều thú vị<br />
                    với những người bạn mới.</p>
                    <!-- </header> -->

                    <!-- Lightbox Gallery  -->
                        <div class="container 75% gallery">
                            <div class="row 0% images">
                                <div class="6u 12u(mobile)">
                                    <a href="${images }/fulls/01.jpg" class="image fit from-left">
                                        <img src="${images }/thumbs/01.jpg" title="Đia điểm 1" alt="Đia điểm 1" />
                                    </a>
                                </div>
                                <div class="6u 12u(mobile)">
                                    <a href="${images }fulls/02.jpg" class="image fit from-right">
                                        <img src="${images }/thumbs/02.jpg" title="Đia điểm 2" alt="Đia điểm 2" />
                                    </a>
                                </div>
                            </div>
                            <div class="row 0% images">
                                <div class="6u 12u(mobile)">
                                    <a href="${images }/fulls/03.jpg" class="image fit from-left">
                                        <img src="${images }/thumbs/03.jpg" title="Đia điểm 3" alt="Đia điểm 3" />
                                    </a>
                                </div>
                                <div class="6u 12u(mobile)"><a href="${images }/fulls/04.jpg" class="image fit from-right"><img src="${images }/thumbs/04.jpg" title="Đia điểm 4" alt="" /></a></div>
                            </div>
                            <div class="row 0% images">
                                <div class="6u 12u(mobile)"><a href="${images }/fulls/05.jpg" class="image fit from-left"><img src="${images }/thumbs/05.jpg" title="Đia điểm 5" alt="Đia điểm 4" /></a></div>
                                <div class="6u 12u(mobile)"><a href="${images }/fulls/06.jpg" class="image fit from-right"><img src="${images }/thumbs/06.jpg" title="Đia điểm 6" alt="Đia điểm 5" /></a></div>
                            </div>
                        </div>
                </div>
            </section>

        

<%@include file="footer.jsp" %>


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