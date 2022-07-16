<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
        //json的定义
        var jsonObj = {
            key1: 24,
            key2: "kb",
            key3: [13, true, "hd"],
            key4: {
                key4_1: 24,
                key4_2: [35, false, "dt"]
            },
            key5: [{
                key5_1_1: 55,
                key5_1_2: "wm"
            }, {
                key5_2_1: 22,
                key5_2_2: "as"
            }
            ]
        }
        var jsonObjStr = JSON.stringify(jsonObj)
        alert(jsonObjStr)//转换为字符串，类似于Java中的toString()方法

        var jsonObjObj =JSON.parse(jsonObjStr)
        alert(jsonObjObj)//转换为对象
    </script>
</head>
<body>

</body>
</html>
