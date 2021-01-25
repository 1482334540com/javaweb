<%--
  Created by IntelliJ IDEA.
  User: 14823
  Date: 2020/10/23
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--登录成功页面--%>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临故事书城</span>
    <a href="../order/order.jsp">我的订单</a>
    <a href="/userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="../../index.jsp">返回</a>
</div>
