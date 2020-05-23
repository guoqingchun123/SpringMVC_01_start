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
    <script src="js/jquery-3.5.1.js"></script>
<%--    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>--%>
    <script>
        //页面加载绑定单机事件
        $(function () {
            $("#btn").click(function () {
                //alert("hello")
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"uname":"haha","age":24}',
                    dataType:"JSON",
                    type:"post",
                    success:function (data) {
                        //data服务器端相应的数据进行解析
                        alert(data);
                        alert(data.uname);
                        alert(data.age);
                        alert(data.password);
                    }

                })
            })
        });
    </script>
</head>
<body>

    <a href="user/testString">testString</a><br>
    <a href="user/testVoid">testVoid</a><br>
    <a href="user/testModelAndView">testModelAndView</a><br>
    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a><br>

    <button id="btn">发送ajax请求</button>
</body>
</html>
