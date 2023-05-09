<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div>
        <h2>登录</h2>
        <form action="LoginServlet" method="post">
            <div>
                <input placeholder="用户名" name="username" type="text"/>
            </div>
            <div>
                <input placeholder="密码" name="password" type="password"/>
            </div>
            <button>登录</button>
        </form>

    </div>
</body>
</html>