<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List Vendor Resources</title>
    
    <!-- Bootstrap CSS -->
    <!--        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"> -->
    
    <!-- let's add tag srping:url -->
    <spring:url value="/resources/assets/css/main.css" var="main"></spring:url>
    <spring:url value="/resources/assets/js/" var="js"></spring:url>
<%--     <spring:url value="/resources/assets/js/jquery.min.js" var="jquery-min"></spring:url> --%>
<%--     <spring:url value="/resources/assets/js/jquery.poptrox.min.js" var="jquery-poptrox"></spring:url> --%>
<%--     <spring:url value="/resources/assets/js/jquery.scrolly.min.js" var="jquery-scrolly"></spring:url> --%>
<%--     <spring:url value="/resources/assets/js/jquery.scrollex.min.js" var="jquery-scrollex"></spring:url> --%>
<%--     <spring:url value="/resources/assets/js/skel.min.js" var="skel"></spring:url> --%>
<%--     <spring:url value="/resources/assets/js/util.js" var="util"></spring:url> --%>
<%--     <spring:url value="/resources/assets/js/main.js" var="main_js"></spring:url> --%>
    <spring:url value="/resources/images/" var="images"></spring:url>
    <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
    <!-- Finish adding tags -->
    <link href="${main }" rel="stylesheet" />
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/jquery.poptrox.min.js"></script>
    <script src="${js}/jquery.scrolly.min.js"></script>
    <script src="${js}/jquery.scrollex.min.js"></script>
    <script src="${js}/skel.min.js"></script>
    <script src="${js}/util.js"></script>
    <script src="${js}/main.js"></script>
</head>
<body>
    <!-- Header -->
            <header id="header">

                <!-- Logo -->
                    <h1 id="logo"><a href="index.html">TLC Travel</a></h1>

                <!-- Nav -->
                    <nav id="nav">
                        <ul class="">
                            <li><a href="#">INTRO</a></li>
                            <li><a href="login.html">SIGN IN</a></li>
                            <li><a class="button" href="signup.html">SIGN UP</a></li>
                            <!-- <li><a href="#">My Work</a></li>
                            <li><a href="#">Contact</a></li> -->
                        </ul>
                    </nav>

            </header>

        <!-- Intro -->
            <section id="intro" class="main style1 dark fullscreen">
                <div class="content container 75%">
                    <header>
                        <h2>Experience everything with new friends</h2>
                    </header>
                    <p>Save more money, more interesting, more refreshing</p>
                    <footer>
                        <a href="#one" class="button style2 down">More</a>
                    </footer>
                </div>
            </section>
<!-- Contact -->
            <!-- <section id="contact" class="main style3 secondary">
                <div class="content container">
                        <h2>How it works</h2>

                    <div class="box container 75%">
                        <p>
                            You will experience the interesting things where you want to not only alone but also with many other new friends.<br />
                            People with similar interests, passions, and more importantly, save you the cost and time.<br />
                            It will help you add new friends.
                        </p>
                        <br />
                        <br />
                    </div>
                </div>
                <a href="#one" class="button style2 down anchored">Next</a>
            </section> -->
        <!-- One -->
            <section id="one" class="main style2 right dark fullscreen">
                <div class="content box style2">
                    <form action="service.html" method="POST">
                        <!-- <header> -->
                        <h2>Create and<br />
                        Join the group travel you like.</h2>
                        <!-- </header> -->
                        <p>You can create groups travel for all to participate and you can also participate in the tour group you like.</p>
                        <button>Join Now</button>
                    </form>
                </div>
                <a href="#two" class="button style2 down anchored">Next</a>
            </section>

        <!-- Two -->
            <section id="two" class="main style2 left dark fullscreen">
                <div class="content box style2">
                    <form action="listpost.html" method="POST">
                        <!-- <header> -->
                        <h2>Find people who share something together to save costs.<br />
                        Or have anything for rent.</h2>
                        <!-- </header> -->
                        <p>Let's create groups together to share something, and to feel it the way you like.</p>
                        <button>Join Now</button>
                    </form>
                </div>
                <a href="#work" class="button style2 down anchored">Next</a>
            </section>

        <!-- Work -->
            <section id="work" class="main style3 primary">
                <div class="content container">
                    <!-- <header> -->
                        <h2>EXPLORE THE WORLD</h2>
                    <p>Where you can discover something interesting<br />
                    with your new friends.</p>
                    <!-- </header> -->

                    <!-- Lightbox Gallery  -->
                        <div class="container 75% gallery">
                            <div class="row 0% images">
                                <div class="6u 12u(mobile)"><a href="${images }fulls/01.jpg" class="image fit from-left"><img src="${images }thumbs/01.jpg" title="The Anonymous Red" alt="" /></a></div>
                                <div class="6u 12u(mobile)"><a href="${images }fulls/02.jpg" class="image fit from-right"><img src="${images }thumbs/02.jpg" title="Airchitecture II" alt="" /></a></div>
                            </div>
                            <div class="row 0% images">
                                <div class="6u 12u(mobile)"><a href="${images }fulls/03.jpg" class="image fit from-left"><img src="${images }thumbs/03.jpg" title="Air Lounge" alt="" /></a></div>
                                <div class="6u 12u(mobile)"><a href="${images }fulls/04.jpg" class="image fit from-right"><img src="${images }thumbs/04.jpg" title="Carry on" alt="" /></a></div>
                            </div>
                            <div class="row 0% images">
                                <div class="6u 12u(mobile)"><a href="${images }fulls/05.jpg" class="image fit from-left"><img src="${images }thumbs/05.jpg" title="The sparkling shell" alt="" /></a></div>
                                <div class="6u 12u(mobile)"><a href="${images }fulls/06.jpg" class="image fit from-right"><img src="${images }thumbs/06.jpg" title="Bent IX" alt="" /></a></div>
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

        <!-- Scripts -->
            
<!--     jQuery -->
<!--     <script src="//code.jquery.com/jquery.js"></script> -->
<!--     Bootstrap JavaScript -->
<!--     <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
</body>
</html>