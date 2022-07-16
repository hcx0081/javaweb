<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<iframe name="target" width="500px" height="500px"></iframe>
<div style="float: right;margin-right: 600px">
    <ul>
        <li><a href="CreateCookieServlet" target="target">cookie的创建</a></li>
        <li><a href="GetCookieServlet" target="target">cookie的获取</a></li>
        <li><a href="" target="target">cookie值的修改</a></li>
        <li>cookie的存活周期</li>
        <li style="list-style-type: none">
            <ul>
                <li><a href="" target="target">cookie的默认存活时间</a></li>
                <li><a href="DeleteCookieServlet" target="target">cookie立即删除</a></li>
                <li><a href="" target="target">cookie存活时间3600秒（1小时）</a></li>
            </ul>
        </li>
        <li><a href="PathCookieServlet" target="terget">cookie的路径设置</a></li>
        <li><a href="" target="terget">cookie的用户免登录</a></li>
    </ul>
</div>
</body>
</html>