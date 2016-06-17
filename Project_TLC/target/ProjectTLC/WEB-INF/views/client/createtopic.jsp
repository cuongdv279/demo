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
    <!-- Content -->
    <div class="container margin-top-25" >
        <form action="/post-user/add-post-topic" method="POST" class="form-horizontal" enctype="multipart/form-data">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Nội dung nhóm
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <%--<form action="addPostTopic" method="POST" role="form" enctype="multipart/form-data">--%>
                                <div class="form-group">
                                    <label>Tiêu đề :<span style="color: red"> *</span></label>
                                    <input name="titleTopic" class="form-control" type="text" required="true" >
                                </div>
                                <div class="form-group">
                                    <label>Địa điểm :<span style="color: red"> *</span></label>
                                    <select name="categories" class="form-control" required="true">
                                        <c:choose>
                                            <c:when test="${empty posts_local}">
                                                <c:forEach var="categoriesList" items="${categoriesList }" varStatus="status">
                                                    <option name="categories" value="${categoriesList.cateId}">${categoriesList.cateName}</option>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                <option name="categories" value="${posts_local.cate_ID.cateId}">${posts_local.cate_ID.cateName}</option>
                                            </c:otherwise>
                                        </c:choose>

                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Ngày đi :<span style="color: red"> *</span></label>
                                    <input name="checkIn" class="form-control" type="date" placeholder="dd/MM/YYYY" required="true" >
                                </div>
                                <div class="form-group">
                                    <label>Ngày về :<span style="color: red"> *</span></label>
                                    <input name="checkOut" class="form-control" type="date" placeholder="dd/MM/YYYY" required="true" >
                                </div>
                                <div class="form-group">
                                    <label>Upload ảnh :<span style="color: red"> *</span></label>
                                    <input id="filebutton" name="file"  class="input-file" type="file">
                                </div>
                                <div class="form-group">
                                    <label data-toggle="tooltip" title="Your content about topic">Nội dung chi tiết :<span style="color: red"> *</span></label>
                                    <%--<textarea placeholder= "Your content about topic" class="form-control textarea ckeditor" rows="3" name="description" placeholder="Content"></textarea>--%>
                                    <textarea placeholder= "Your content about topic" class="form-control textarea ckeditor" cols="80" id="editor1" name="editor1" rows="10"></textarea>

                                </div>
                                <div class="form-group">
                                    <label data-toggle="tooltip" title="Your rules about topic" >Yêu cầu của nhóm :<span style="color: red"> *</span></label>
                                    <textarea  placeholder="Your rules about topic" class="form-control textarea ckeditor"cols="80" id="editor2" rows="10" name="rules"></textarea>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" name="user_ID" type="hidden" value="${sessionUser.user_ID}"  >
                                </div>
                                <div class="form-group">
                                    <c:choose>
                                        <c:when test="${ empty posts_local}">
                                            <input class="form-control" name="postLocal_ID" type="hidden" value="null" >
                                        </c:when>
                                        <c:otherwise>
                                            <input class="form-control" name="postLocal_ID" type="hidden" value="${posts_local.post_ID}" >
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <button type="submit" class="btn btn-default">Tạo </button>
                                <button type="reset" class="btn btn-default">Làm mới</button>
                            <%--</form>--%>
                        </div>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>

        </form>
    </div>
    <!-- End Content -->
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
<spring:url value="/resources/assets/filemanager_in_ckeditor/js/ckeditor/ckeditor.js" var="jsckeditor"></spring:url>
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/jquery.poptrox.min.js"></script>
    <script src="${js}/jquery.scrolly.min.js"></script>
    <script src="${js}/jquery.scrollex.min.js"></script>
    <script src="${js}/skel.min.js"></script>
    <script src="${js}/util.js"></script>
    <script src="${js}/main.js"></script>
    <script src="${jsckeditor}"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script src="${js}/howitwork.js"></script>
    <script>
        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();
            });
    </script>
<script type="text/javascript">
    CKEDITOR.replace( 'editor1',
            {
                filebrowserBrowseUrl :'js/ckeditor/filemanager/browser/default/browser.html?Connector=http://wnwapp-wnw.rhcloud.com/filemanager_in_ckeditor/js/ckeditor/filemanager/connectors/php/connector.php',
                filebrowserImageBrowseUrl : 'js/ckeditor/filemanager/browser/default/browser.html?Type=Image&Connector=http://wnwapp-wnw.rhcloud.com/filemanager_in_ckeditor/js/ckeditor/filemanager/connectors/php/connector.php',
                filebrowserFlashBrowseUrl :'js/ckeditor/filemanager/browser/default/browser.html?Type=Flash&Connector=http://wnwapp-wnw.rhcloud.com/filemanager_in_ckeditor/js/ckeditor/filemanager/connectors/php/connector.php',
                filebrowserUploadUrl  :'http://wnwapp-wnw.rhcloud.com/filemanager_in_ckeditor/js/ckeditor/filemanager/connectors/php/upload.php?Type=File',
                filebrowserImageUploadUrl : 'http://wnwapp-wnw.rhcloud.com/filemanager_in_ckeditor/js/ckeditor/filemanager/connectors/php/upload.php?Type=Image',
                filebrowserFlashUploadUrl : 'http://wnwapp-wnw.rhcloud.com/filemanager_in_ckeditor/js/ckeditor/filemanager/connectors/php/upload.php?Type=Flash'
            });
    CKEDITOR.replace( 'editor2',
            {
                filebrowserBrowseUrl :'js/ckeditor/filemanager/browser/default/browser.html?Connector=http://wnwapp-wnw.rhcloud.com/filemanager_in_ckeditor/js/ckeditor/filemanager/connectors/php/connector.php',
                filebrowserImageBrowseUrl : 'js/ckeditor/filemanager/browser/default/browser.html?Type=Image&Connector=http://wnwapp-wnw.rhcloud.com/filemanager_in_ckeditor/js/ckeditor/filemanager/connectors/php/connector.php',
                filebrowserFlashBrowseUrl :'js/ckeditor/filemanager/browser/default/browser.html?Type=Flash&Connector=http://wnwapp-wnw.rhcloud.com/filemanager_in_ckeditor/js/ckeditor/filemanager/connectors/php/connector.php',
                filebrowserUploadUrl  :'http://wnwapp-wnw.rhcloud.com/filemanager_in_ckeditor/js/ckeditor/filemanager/connectors/php/upload.php?Type=File',
                filebrowserImageUploadUrl : 'http://wnwapp-wnw.rhcloud.com/filemanager_in_ckeditor/js/ckeditor/filemanager/connectors/php/upload.php?Type=Image',
                filebrowserFlashUploadUrl : 'http://wnwapp-wnw.rhcloud.com/filemanager_in_ckeditor/js/ckeditor/filemanager/connectors/php/upload.php?Type=Flash'
            });
</script>

</body>
</html>