<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    请求参数username的值：${param.username}<br>
    请求参数password的值：${param.password}<br>

    请求参数username的值：${paramValues.username[0]}<br>
    请求参数password的值：${paramValues.password[0]}<br>

    <hr>
    请求头字段User-Agent的值：${header["User-Agent"]}<br><%-- 因为该请求头字段有特殊字符，所以需要使用方括号运算符 --%>
    请求头字段Host的值：${header.Host}<br>
</body>
</html>