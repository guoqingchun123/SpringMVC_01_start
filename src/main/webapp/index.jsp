<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/19
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%-- <h3>入门程序</h3>
    <a href="user/hello?name=haha">入门程序</a>--%>
<%--   封装对象的数据有引用类型
    <form action="user/saveAccount" method="post" >
        姓名: <input type="text" name="name"> <br>
        密码: <input type="text" name="password"><br>
        金额: <input type="text" name="money"><br>
        用户姓名: <input type="text" name="user.uname"><br>
        用户年龄: <input type="text" name="user.age"><br>
        <input type="submit" value="提交">
    </form>--%>

<%--   将数据封装在Account对象中,对象中有List与Map数据类型--%>
  <%-- <form action="user/saveAccount" method="post" >
       姓名: <input type="text" name="name"> <br>
       密码: <input type="text" name="password"><br>
       金额: <input type="text" name="money"><br>
       用户姓名: <input type="text" name="list[0].uname"><br>
       用户年龄: <input type="text" name="list[0].age"><br>

       用户姓名: <input type="text" name="map['one'].uname"><br>
       用户年龄: <input type="text" name="map['one'].age"><br>
       <input type="submit" value="提交">
   </form>--%>

   <%--   自定义类型转换器--%>
    <%--<form action="user/converte" method="post" >

        用户姓名: <input type="text" name="uname"><br>
        用户年龄: <input type="text" name="age"><br>
        用户生日: <input type="text" name="birthday">

        <input type="submit" value="提交">
    </form>
--%>

<%--   <a href="user/servlet">servletAPI</a>--%>

    <form action="user/testFileUpload" method="post" enctype="multipart/form-data">
        上传文件<input type="file" name="upload"/><br>
        <input type="submit" value="上传"/>
    </form>
   <form action="user/testSpringVMCFileUpload" method="post" enctype="multipart/form-data">
       上传文件<input type="file" name="upload"/><br>
       <input type="submit" value="上传"/>
   </form>
   <form action="user/testFileUpload3" method="post" enctype="multipart/form-data">
       上传文件<input type="file" name="upload"/><br>
       <input type="submit" value="上传"/>
   </form>
</body>
</html>
