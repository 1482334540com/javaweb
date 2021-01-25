<%--
  Created by IntelliJ IDEA.
  User: 14823
  Date: 2020/10/21
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% request.setAttribute("key","value值");%>
表达式脚本输出的可以值是：<%=request.getAttribute("key")%>
<br>
EL表达式输出的key值是:${key}
</body>
</html>
