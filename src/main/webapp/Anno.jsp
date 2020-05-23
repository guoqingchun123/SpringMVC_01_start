<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/20
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="anno/requestParamTest?name=haha">requestParam</a>

    <form action="anno/requestBodyTest" method="post" >

        用户姓名: <input type="text" name="uname"><br>
        用户年龄: <input type="text" name="age"><br>

        <input type="submit" value="提交"><br>
    </form>

    <a href="anno/pathVariableTest/10">pathVariable</a><br>

    <a href="anno/testRequestHeader">requestHeader</a><br>

    <a href="anno/testCookieValue">testCookieValue</a><br>

    <form action="anno/testModelAttribute" method="post" >

        用户姓名: <input type="text" name="uname"><br>
        用户年龄: <input type="text" name="age"><br>

        <input type="submit" value="提交"><br>
    </form>

    <a href="anno/testSessionAttribute">testSessionAttribute</a><br>
    <a href="anno/getSessionAttribute">getSessionAttribute</a><br>
    <a href="anno/deleteSessionAttribute">deleteSessionAttribute</a><br>

</body>
</html>
