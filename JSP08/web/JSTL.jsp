<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 14823
  Date: 2020/11/9
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

  <%--  <c:if test=""/>   获取get请求参数：param.参数名称
    if 标 签 用 来 做 if判 断 。
    test属 性 表 示 判 断 的 条 件 （ 使 用 EL表 达 式 输 出 ）
    --%>
    <c:if test=" ${  12 == 12 }">
    <h1>（12==12）条件成立</h1>
    </c:if>
  <c:if test=" ${  12 == 12 }">
      <h1>（12!=12）条件不成立</h1>
  </c:if>
<%--
<c:choose> <c:when> <c:otherwise> 标签
1 、 标 签 里 不 能 使 用 html注 释 ， 要 使 用 jsp注 释
2 、 when标 签 的 父 标 签 一 定 要 是choose标 签
3.choose标 签 开 始 选 择 判 断
4.when标 签 表 示 每 一 种 判 断 情 况
5.test 属 性 表 示 当 前 这 种 判 断 情 况 的 值
6.otherwise 标 签 表 示 剩 下 的 情 况

--%>
  <%
      request.setAttribute("height", 192);
      request.setAttribute("number", 3);
  %>
  <c:choose> <%--开始判断标签  相当于if else default--%>

    <c:when test="${ requestScope.height > 190 }">  <%--每一项判断--%>
    <h2>小巨人</h2>
    </c:when>

    <c:when test="${ requestScope.height > 180 }"> <%--每一项判断--%>
        <h2>很高</h2>
    </c:when>

    <c:when test="${ requestScope.height > 170 }"> <%--每一项判断--%>
        <h2>还可以</h2>
    </c:when>
      <c:otherwise>      <%--当以上条件都不成立时候执行此处--%>
          <h2>这也太低了吧</h2>
      </c:otherwise>

  </c:choose>  <%--结束判断标签--%>

  <c:choose> <%--开始判断标签 相当于switch--%>

      <c:when test="${ requestScope.number == 1 }">  <%--每一项判断--%>
          <h2>星期一</h2>
      </c:when>

      <c:when test="${ requestScope.number == 2 }"> <%--每一项判断--%>
          <h2>星期二</h2>
      </c:when>

      <c:when test="${ requestScope.number == 3 }"> <%--每一项判断--%>
          <h2>星期三</h2>
      </c:when>
      <c:otherwise>      <%--当以上条件都不成立时候执行此处--%>
          <h2>未能找到对应值</h2>
      </c:otherwise>

  </c:choose>  <%--结束判断标签--%>

 <%--1. 遍 历 1到 10 ， 输 出  <c:forEach/>
  begin：属 性 设 置 开 始 的 索 引
  end属：性 设 置 结 束 的 索 引
  var：  属 性 表 示 循 环 的 变 量 ( 也 是 当 前 正 在 遍 历 到 的 数 据 )
  step: 循环的步长
   --%>
  <table border="1"   cellspacing="0" >
      <caption><b>标题</b></caption>
      <c:forEach begin="1" end="10" var="i" step="1">

        <tr>
            <c:forEach begin="1" end="10" var="i" step="1">
              <td>第${i}次</td>
            </c:forEach>
       </tr>

      </c:forEach>
  </table>

  <%--< forEach  items：方式遍历>
  items：需要遍历的对象
  var： 遍历的每一次值
  --%>
 <%
     List students = new ArrayList();
     students.add("小明");
     students.add("小花");
     students.add("小白");
     students.add("小华");
    request.setAttribute("students",students);
 %>
  <c:forEach items="${requestScope.students}" var="item" varStatus="s" >
        ${item}    ${"索引:"}${s.index}     ${"次数:"}${  s.count}
 </c:forEach>
</body>
</html>
