<%--
  Created by IntelliJ IDEA.
  User: 14823
  Date: 2020/10/19
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--声明脚本--%>
<%!
    //    定义变量
    int number=10;
    //    定义静态代码块
    static{

        System.out.println("这是静态代码块");
    }
    //    定义方法
    public  void doSome(){
        System.out.println("这是一个method");
    }
    //    定义一个内部类
    class Test {
        private  String str= "TestClass";
    }
%>
<%--java代码脚本--%>
<% out.write("java代码"); %>


<%--表达式脚本--%>
<%=1024 %>
<%="jsp表达式" %>




</body>
</html>
