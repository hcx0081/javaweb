<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form enctype="multipart/form-data" method="post" action="UploadServlet">
        用户名：<input type="text" name="username">
        <br>
        头像：<input type="file" name="picture">
        <br>
        简历：<input type="file" name="resume">
        <br>
        <input type="submit" value="上传">
    </form>
</body>
</html>