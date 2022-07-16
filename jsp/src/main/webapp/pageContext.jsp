<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    /*这样写使代码更加简洁*/
    pageContext.setAttribute("req", request);
%>
<%=pageContext.getSession().getId()%><br>
<%=session.getId()%><br>
1.协议:${req.scheme}<br><%--简洁了许多--%>
2.获取服务器ip名称:${pageContext.request.serverName}<br>
3.服务器端口:${pageContext.request.serverPort}<br>
4.获取工程路径:${pageContext.request.contextPath}<br>
5.获取请求方法:${pageContext.request.method}<br>
6.获取客户端ip地址:${pageContext.request.remoteHost}<br>
7.获取会话ip编号:${pageContext.session.id}<br>
</body>
</html>
