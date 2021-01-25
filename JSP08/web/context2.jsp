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
这是 context2 页面 <br/>
<%=pageContext.getAttribute("key") %><br/>
<%=request.getAttribute("key") %><br/>
<%=session.getAttribute("key") %><br/>
<%=application.getAttribute("key") %><br/>
</body>
</html>
