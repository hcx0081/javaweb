<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<h1>scope.jsp 页面</h1>
<%
    //往四个域中存值
    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
%>
pageContext域是否有值：<%=pageContext.getAttribute("key")%><br>
request域是否有值：<%=request.getAttribute("key")%><br>
session域是否有值：<%=session.getAttribute("key")%><br>
application域是否有值：<%=application.getAttribute("key")%><br>
${key}<%--输出 pageContext，因为优先级高 --%>
</body>
</html>
