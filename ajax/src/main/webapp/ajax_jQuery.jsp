<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%--org.webjars.bower--%>
    <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>

    <%--    &lt;%&ndash;org.webjars&ndash;%&gt;--%>
    <%--    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>--%>

    <script type="text/javascript">
        $(function () {

                $("#ajaxBtn").click(function () {
                    $.ajax({
                        url: "AjaxJqueryServlet",
                        // data: "",
                        type: "get",
                        success: function (data) {
                            alert("服务器返回的数据是：" + data)
                            $("#main").html("$.ajax() —— 编号：" + data.id + "，姓名：" + data.name)
                        },
                        dataType: "json",
                    })
                })


                $("#getBtn").click(function () {
                    $.get("GetJqueryServlet", function (data) {
                        $("#main").html("$.get() —— 编号：" + data.id + "，姓名：" + data.name)
                    }, "json")
                })


                $("#postBtn").click(function () {
                    //PostJqueryServlet中需要调用doPost()方法处理数据
                    $.post("PostJqueryServlet", function (data) {
                        $("#main").html("$.post() —— 编号：" + data.id + "，姓名：" + data.name)
                    }, "json")
                })


                $("#getJsonBtn").click(function () {
                    $.getJSON("GetJsonJqueryServlet", function (data) {
                        $("#main").html("$.getJSON() —— 编号：" + data.id + "，姓名：" + data.name)
                    })
                })


                $("#serializeBtn").click(function () {
                    $.getJSON("SerializeJqueryServlet", $("#form").serialize(), function (data) {
                        $("#main").html("serialize() —— 编号：" + data.id + "，姓名：" + data.name)
                    })
                })


            }
        )
    </script>
</head>
<body>
    <form id="form">
        编号：<input type="text" name="id"><br>
        姓名：<input type="text" name="name"><br>
        爱好：<input type="checkbox" name="hobby" value="编程">编程
        <input type="checkbox" name="hobby" value="运动">运动<br>
    </form>

    <button id="ajaxBtn">$.ajax()</button>
    <button id="getBtn">$.get()</button>
    <button id="postBtn">$.post()</button>
    <button id="getJsonBtn">$.getJSON()</button>

    <div id="main">

    </div>

    <br>
    <br>
    <br>

    <input type="button" id="serializeBtn" value="提交——serialize()">

</body>
</html>