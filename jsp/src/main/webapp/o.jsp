<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
输出请求参数username的值：${param.username}<br>
输出请求参数password的值：${param.password}<br>

<%--paramValues：获取请求参数中的多个值--%>
输出请求参数username的值：${paramValues.username[0]}<br>
输出请求参数password的值：${paramValues.password[0]}<br>

<hr>
输出请求头User-Agent的值：${header["User-Agent"]}<br><%--因为该请求头有特殊字符，所以需要使用方括号运算符--%>
输出请求头Host的值：${header.Host}<br>
</body>
</html>
