<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%
        /*
         * 建议使用print()方法输出
         * 因为该方法无论输出任何数据都没有问题（都是转换为字符串后进行write()输出）
         * */
        out.print("out.print输出1 <br>");
        out.write("out.write输出1 <br>");
        // 执行flush()会把out缓冲区数据追加到response缓冲区末尾
        out.flush();
        out.print("out.print输出2 <br>");
        out.write("out.write输出2 <br>");

        response.getWriter().write("response输出1 <br>");
        response.getWriter().write("response输出2 <br>");
    %>
</body>
</html>