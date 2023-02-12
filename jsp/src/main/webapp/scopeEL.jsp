<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%
        // 往四个域中存值
        pageContext.setAttribute("key", "pageContext");
        request.setAttribute("key", "request");
        session.setAttribute("key", "session");
        application.setAttribute("key", "application");
    %>
    <%-- 若不指定域对象则默认从四大域中查找 --%>
    ${key}<%-- pageContext --%>
    ${applicationScope.key}<%-- application --%>

</body>
</html>