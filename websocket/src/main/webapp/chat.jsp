<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html>
<head>
    <title>Chat</title>
</head>
<body style="display: flex;flex-direction: column">
    <div>
        用户名：${username}
        <button id="down">离线</button>
    </div>
    <div style="display: flex">
        <div style="width: 500px;height: 250px;border:1px solid black" id="room">

        </div>
        <div style="display: flex;flex-direction: column;justify-content: space-around">
            <div>
                用户列表：
                <div id="userList"></div>
            </div>
            <div>
                系统广播：
                <div id="broadcastRoom"></div>
            </div>
        </div>
    </div>
    <div>
        <input id="txt">
        <button id="send">发送</button>
    </div>
    <script>
        let txt = document.getElementById('txt');
        let send = document.getElementById('send');
        let room = document.getElementById('room');
        let broadcastRoom = document.getElementById('broadcastRoom');
        let down = document.getElementById('down');

        let userList;

        <%-- 请求连接 --%>
        let webSocket = new WebSocket("ws://localhost:8080/chat");

        webSocket.onopen = function () {


        }
        // 接收消息
        webSocket.onmessage = function (ev) {
            let mesObj = JSON.parse(ev.data);
            console.log(mesObj)

            if (mesObj.type === "user") {
                let mesArr = JSON.parse(ev.data).data;
                let userList = document.getElementById('userList');
                userList.innerHTML = ''
                mesArr.forEach(it => {
                    if (it === '${username}') {
                        return
                    }
                    userList.innerHTML += `<input type="radio" name="user" value="\${it}">\${it}<br>`;
                })
            }

            if (mesObj.type === "single") {
                room.innerHTML += `<p>\${mesObj.sender}：\${mesObj.data}</p>`;
            }
            if (mesObj.type === "broadcast") {
                broadcastRoom.innerHTML += `<p>\${mesObj.sender}：\${mesObj.data}</p>`;
            }
        };

        // 发送消息
        send.onclick = function () {
            let sender = '${username}';
            let receiver = [];
            let data = txt.value;
            let type;

            let user = document.getElementsByName('user');
            if (user != null) {
                user.forEach(user => {
                    if (user.checked === true) {
                        receiver.push(user.value);
                    }
                })
            }
            if (receiver.length !== 0) {
                receiver.push("${username}")
                type = 'single';
            } else {
                type = 'broadcast';
            }

            let mesObj = {
                sender,
                receiver,
                data,
                type
            };
            console.log(mesObj)
            webSocket.send(JSON.stringify(mesObj));
        };

        // 断开连接
        down.onclick = function () {
            webSocket.close();
        };
    </script>
</body>
</html>