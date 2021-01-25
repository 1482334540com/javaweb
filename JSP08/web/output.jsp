<%--
  Created by IntelliJ IDEA.
  User: 14823
  Date: 2020/10/19
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    out.write("out输出1<br>");
    out.write("out输出2<br>");

    response.getWriter().write("response输出1<br>");
    response.getWriter().write("response输出2<br>");
     out.write(49);


%>


</body>
</html>
