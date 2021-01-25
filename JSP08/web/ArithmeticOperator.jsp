<%--
  Created by IntelliJ IDEA.
  User: 14823
  Date: 2020/10/21
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
算术运算符<br>
+:${5+5} <br>
-:${5-5}<br>
*:${5*5}<br>
/:${5/5}或${5 div 5}<br>
%:${8%3}${8 mod 3}<br>
关系运算符<br>

==:${5==5} 或 ${5 eq 5}<br>
!=:${5!=5} 或 ${5 ne 5}<br>
<: ${5<6}  或 ${5 lt 5}<br>
>: ${5>6}  或 ${5 gt 5}<br>
<=: ${5<=7} 或  ${5 le 5}<br>
>=:${5>=6}  或 ${5 ge 5}<br>
逻辑运算符<br>

&&:${12==12&&12<11} 或 ${12==12 and 12<11}<br>
||:${12==12||12<11} 或 ${12==12 or 12<11}<br>
!${!true} 或 ${not true}<br>

三元运算符：5>=7<br>
${5>=7?"表达式成立":"表达式不成立"}

</body>
</html>
