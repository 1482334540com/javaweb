<%--
  Created by IntelliJ IDEA.
  User: 14823
  Date: 2020/10/23
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/upload" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username" value="卡夫卡" /> <br>
    头像：<input type="file" name="photo" > <br> <input type="submit" value="上传">

</form>

</body>
</html>


