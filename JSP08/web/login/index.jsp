
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    Object username= session.getAttribute("username");
    if (username == null){
        response.sendRedirect("login.jsp");
    }

%>
<html>
  <head>
    <title>登录成功页面</title>
  </head>
  <body>

<h1> 登录成功页面</h1>

  </body>
</html>
