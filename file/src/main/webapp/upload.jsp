<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    1、要有一个 form 标签， method="post"（ get 方法有长度限制，即 url 地址的字符个数有上限，上传的文件一般都会超出长度限制，所以用 post ）
    2、文件上传的 form 标签的 enctype 属性值必须为 multipart/form-data
    3、在 form 标签中使用 input type="file" 添加上传的文件
    4、编写服务器代码（ servlet 程序）接收，处理上传的数据

    multipart/form-data 表示提交的数据，以多段（每一个表单项一个数据段）形式进行拼接，然后以二进制流的形式发送给服务器，
    所以不能使用 getParameter() 进行接收
--%>
<form enctype="multipart/form-data" method="post" action="UploadServlet">
    用户名：<input type="text" name="username">
    <br>
    头像：<input type="file" name="myfile">
    <br>
    <input type="submit" value="上传">
</form>
</body>
</html>
