<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>

<%@ page import="cn.jsp.Student" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%--jsp中输入一个表格，输出5个学生信息--%>

    <%
        List<Student> studentList = new ArrayList<Student>();

        for (int i = 1; i <= 5; i++) {
            studentList.add(new Student(i,"userName"+i ,18+i,"1518563690"+i,null) );
        }
        session.setAttribute("students", studentList);

        request.setAttribute("array_colors", new String[]{"bg-danger","bg-warning","bg-success","info","bg-primary"});
    %>



<table class="table">
    <caption class="text-center"><b>隔行变色表格</b></caption>
    <thead>
    <tr >
        <th>编号</th>
        <th>名字</th>
        <th>年龄</th>
        <th>电话</th>
        <th>颜色对应值</th>

    </tr>
    </thead>
    <tbody>


    <c:forEach  items="${sessionScope.students}" var="stu" varStatus="s">
        <tr class="${array_colors[s.index]}">
            <td>${stu.id}</td>
            <td>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.phone}</td>
            <td>${array_colors[s.index]}</td>
        </tr>

    </c:forEach>
    </tbody>
</table>



</body>
</html>
