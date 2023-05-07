<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%
        // 从请求头中获取Locale头字段信息，例如：zh_CN
        Locale locale = request.getLocale();
        System.out.println(locale);// zh_CN
        // 获取资源包（根据指定的baseName和Locale读取语言信息）
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n", locale);

        System.out.println(resourceBundle.getString("username"));// 用户名
    %>
    <%-- 设置locale信息 --%>
    <fmt:setLocale value="${param.locale}"></fmt:setLocale>
    <%-- 设置baseName --%>
    <fmt:setBundle basename="i18n"></fmt:setBundle>
    <a href="i18n.jsp?locale=zh_CN">中文</a>
    <a href="i18n.jsp?locale=en_US">English</a>

    <h1><fmt:message key="register"/></h1>
    <table>
        <tr>
            <td><fmt:message key="username"/>：</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td><fmt:message key="password"/>：</td>
            <td><input type="password"></td>
        </tr>
        <tr>
            <td><fmt:message key="sex"/>：</td>
            <td>
                <input type="radio"><fmt:message key="man"/>
                <input type="radio"><fmt:message key="women"/>
            </td>
        </tr>
        <tr>
            <td>
                <button><fmt:message key="reset"/></button>
            </td>
            <td>
                <button><fmt:message key="submit"/></button>
            </td>
        </tr>
    </table>
</body>
</html>