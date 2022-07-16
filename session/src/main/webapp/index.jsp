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
        <li><a href="CreateOrGetSessionServlet" target="target">session的创建和获取（id号、是否为新创建）</a></li>
        <li><a href="SetAndGetAttributeServlet" target="target">session域数据的存储和获取</a></li>
        <li>session的存活</li>
        <li style="list-style-type: none">
            <ul>
                <li><a href="DefaultLifeSessionServlet" target="target">session的默认超时及配置</a></li>
                <li><a href="SetLifeServlet" target="target">session3秒超时销毁</a></li>
                <li><a href="DestroySessionServlet" target="target">session马上销毁</a></li>
            </ul>
        </li>
        <li><a href="" target="terget">浏览器和session绑定的原理</a></li>
    </ul>
</div>
</body>
</html>