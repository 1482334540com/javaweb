<%--
  Created by IntelliJ IDEA.
  User: 14823
  Date: 2020/11/8
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    System.out.println("a.jsp页面被执行了");
Object object = session.getAttribute("user");
    /*如果object为空 说明还没有登录*/
if (object == null )
{
    request.getRequestDispatcher("/login.jsp").forward(request,response);
    return;
}
%>

我是a.jsp文件
</body>
</html>
