<%--
  Created by IntelliJ IDEA.
  User: 14823
  Date: 2020/10/20
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style type="text/css">
    table{
        width: 650px;text-align: center;
    }
</style>
<body>
<%--练习输出99乘法表--%>
<table>
<%for (int i=1;i<=9;i++){%>
    <tr>
        <% for (int j=1;j<=i;j++){%>
        <td><%=i+"x"+j+"="+(i*j)%> </td>
        <%}%>
     </tr>
    <%}%>
</table>
</body>
</html>
