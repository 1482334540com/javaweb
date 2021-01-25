
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(request.getMethod().equals("POST")){
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //注意点：input输入框传递过来的值是字符串类型的
        if (username.equals("root") && password.equals("123")){

            session.setAttribute("username",username);
            response.sendRedirect("index.jsp");
        }
        else{
            out.write("用户名或者密码错误，2秒后返回登录页面");
            response.setHeader("Refresh","2,url=login.jsp");
        }
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    账户:<input type="text" name="username">
    密码: <input type="password" name="password">
    <input type="submit" value="登录">
</form>
</body>
</html>
