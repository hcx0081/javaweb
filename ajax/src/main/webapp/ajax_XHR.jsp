<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        function ajaxRequest() {
            //1、首先创建XMLHttpRequest对象
            var xmlHttpRequest = new XMLHttpRequest();

            //2、调用open()方法设置请求参数
                //如果是GET，想带参数则可以直接url后面加上"?xxx=xxx"
            xmlHttpRequest.open("GET", "AjaxXhrServlet", true)
                //如果是POST，想带参数则需要使用setRequestHeader()来添加HTTP请求头，然后在send()方法中规定发送的数据
            /*xmlHttpRequest.open("POST","AjaxXhrServlet",true);
            xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");

            xmlHttpRequest.send("id=1&name=hcx");*/

            //3、在seng()方法前绑定onreadystatechange事件，处理请求完成后的操作
            xmlHttpRequest.onreadystatechange = function () {
                if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
                    //解析json字符串为json对象
                    var jsonObj = JSON.parse(xmlHttpRequest.responseText)
                    //把响应的数据显示在页面上
                    document.getElementById("main").innerHTML = "编号：" + jsonObj.id + "，姓名：" + jsonObj.name;
                }
            }

            //4、调用send()方法发送参数
            xmlHttpRequest.send()
        }
    </script>
</head>
<body>
<button onclick="ajaxRequest()">ajax request</button>
<div id="main"></div>
</body>
</html>
