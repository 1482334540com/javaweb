 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="cn.jsp.Student" %>

<%--
  Created by IntelliJ IDEA.
  User: 14823

Date: 2020/10/20
Time: 11:04
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--jsp中输入一个表格，输出5个学生信息--%>



<table border="1"   cellspacing="0">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>电话</td>
        <td>颜色</td>
        <td>操作</td>
    </tr>

    <%
        List<Student> studentList = new ArrayList<Student>();
        for (int i = 1; i <= 5; i++) {
            studentList.add(new Student(i,"userName"+i ,18+i,"1518563690"+i,"color"));
        }
        session.setAttribute("students", studentList);

    %>

    <c:forEach  items="${sessionScope.students}" var="stu" >
        <tr>
            <td>${stu.id}</td>
            <td>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.phone}</td>
            <td>${stu.color}</td>
            <td>修改|删除</td>
        </tr>

    </c:forEach>

  <%--    <%
          List<Student2> students = (List<Student2>) session.getAttribute("students");
          for (Student2 student : students) {
      %>
<tr>
    <td><%=student.getId()%></td>
    <td><%=student.getName()%></td>
    <td><%=student.getAge()%></td>
    <td><%=student.getPhone()%></td>
    <td>删除|修改</td>
<tr>

        <% }%>  --%>


</table>
</body>
</html>
