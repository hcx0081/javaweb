<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    /*
    * 建议使用 print() 方法输出
    * 因为该方法无论输出任何数据都没有问题（都是转换为字符串后进行 write() 输出）
    * */
    //out.write("out输出1 <br>");
    out.print("out输出1 <br>");
    //执行 flush() 会把out缓冲区数据追加到response缓冲区末尾
    out.flush();
    //out.write("out输出2 <br>");
    out.print("out输出2 <br>");

    response.getWriter().write("response输出1 <br>");
    response.getWriter().write("response输出2 <br>");
%>
</body>
</html>
