<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>scope2.jsp 页面</h1>
pageContext域是否有值：<%=pageContext.getAttribute("key")%><br>
request域是否有值：<%=request.getAttribute("key")%><br>
session域是否有值：<%=session.getAttribute("key")%><br>
application域是否有值：<%=application.getAttribute("key")%><br>
${key}<%--输出 session，因为优先级高 --%>
</body>
</html>
