<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="LoginServlet" method="get">
    用户名：<input type="text" name="username" value="${cookie.username.value}">
    <br>
    密码：<input type="text" name="psd">
    <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
