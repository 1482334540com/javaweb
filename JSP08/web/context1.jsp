<%--
  Created by IntelliJ IDEA.
  User: 14823
  Date: 2020/10/19
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
这是 context1 页面<br/>
<%
    //设置 page 域的数据
    pageContext.setAttribute("key", "pageContext-value");
    //设置 request 域的数据
    request.setAttribute("key", "request-value");
    //设置 session 域的数据
    session.setAttribute("key", "session-value");
    //设置 application 域的数据
    application.setAttribute("key", "application-value");
    application.setAttribute("applicationTest", "applicationTest-的值");
%>

<%-- 测试当前页面作用域 --%>

<%=pageContext.getAttribute("key") %><br/>
<%=request.getAttribute("key") %><br/>
<%=session.getAttribute("key") %><br/>
<%=application.getAttribute("key") %><br/>

<p>EL表达式方式获取</p>
${applicationTest}<br/>
${applicationScope.applicationTest}<br/>
<%--<%  request.getRequestDispatcher("/context2.jsp").forward(request, response);   %>--%>
</body>
</html>
