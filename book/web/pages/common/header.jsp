
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--动态获取:http://localhost:80/--%>
<%
    String basePath=request.getScheme()
            +"://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/"
            ;
%>
<%--<%=basePath %>--%>
<!--<base href="basePath">-->
<%--css样式和jquery引入--%>

<link type="text/css" rel="stylesheet" href="../../static/css/style.css">
<script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>
