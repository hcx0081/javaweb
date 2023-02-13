<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="RegisterServlet" method="get">
        用户名：<input type="text" name="username">
        <br>
        验证码：<input type="text" name="code" style="width: 80px">
        <br>
        <%-- 点击图片 或 页面刷新 重新加载则会更换验证码 --%>
        <a href=""><img src="KaptchaServlet" width="150"></a>
        <br>
        <input type="submit" value="注册">
    </form>
</body>
</html>