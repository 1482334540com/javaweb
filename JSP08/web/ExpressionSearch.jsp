<%--
  Created by IntelliJ IDEA.
  User: 14823
  Date: 2020/10/21
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%-- 依次输出顺序(从范围的从小到大进行输出)：pageContext ->request ->session ->application--%>
<% //往四个域中都保存了相同key的数据
    pageContext.setAttribute("key","pageContext");
    request.setAttribute("key","request");
    session.setAttribute("key","session");
    application.setAttribute("key","application");

%>
  域中的数据：${key}
</body>
</html>
