<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        function ajaxRequest() {
            //1、首先创建XMLHttpRequest对象
            var xhr = new XMLHttpRequest();

            //2、调用open()方法设置请求参数
                //如果是GET，想带参数则可以直接url后面加上"?xxx=xxx"
            xhr.open("GET", "AjaxXhrServlet");
            //3、调用send()方法发送参数
            xhr.send();
                //如果是POST，想带参数则需要使用setRequestHeader()来添加HTTP请求头，然后在send()方法中规定发送的数据
            /*xhr.open("POST","AjaxXhrServlet");
            xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");

            xhr.send("id=1&name=zs");*/

            
            //4、在seng()方法前绑定onreadystatechange事件，处理请求完成后的操作
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    //解析json字符串为json对象
                    var jsonObj = JSON.parse(xhr.responseText);
                    //把响应的数据显示在页面上
                    document.getElementById("main").innerHTML = "编号：" + jsonObj.id + "，姓名：" + jsonObj.name;
                }
            }
        }
    </script>
</head>
<body>
<button onclick="ajaxRequest()">ajax request</button>
<div id="main"></div>
</body>
</html>
