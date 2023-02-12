<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%
        /* 这样写使代码更加简洁 */
        pageContext.setAttribute("req", request);
    %>
    <%=pageContext.getSession().getId()%><br>
    <%=session.getId()%><br>
    SessionID：${pageContext.session.id}<br>
    协议：${req.scheme}<br><%-- 十分简洁 --%>
    服务端名称：${pageContext.request.serverName}<br>
    服务端端口号：${pageContext.request.serverPort}<br>
    项目路径：${pageContext.request.contextPath}<br>
    客户端IP地址：${pageContext.request.remoteHost}<br>
    请求方式：${pageContext.request.method}<br>
</body>
</html>