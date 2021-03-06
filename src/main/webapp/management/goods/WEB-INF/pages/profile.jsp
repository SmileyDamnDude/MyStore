<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Профиль</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/MainStyle.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/profile.js"></script>
</head>
<body>

<div id="main_container">
    <!-- FRAME -->
    <div id="frame">

        <!-- BEGIN HEADER -->
        <div id="top">
            <div id="logo">
                <div id="pad_logo">
                    <a href="index"><img src="${pageContext.request.contextPath}/image/logo.gif" alt="" /></a>
                </div>
            </div>

            <div id="topmenu">
                <div id="nav">
                    <ul id="menu">
                        <li class="current"><a class="active" href="../../index">Главная</a></li>
                        <li class="last"><a href="../../management">Управление</a></li>
                    </ul>
                </div>
            </div>
        </div>

    <script type="text/javascript">
        var goods = '${goods}';
        var jsonData = JSON.parse(goods);
        var message = '${message}';

        $(document).ready(function () {
            controlProfile(jsonData, message);
        });
    </script>

    <div class="bus">
        <div id = "title" class="error"></div>
        <div id = "error" class="error"></div>

        <div id = "someContainer"></div>

        <div id = "formEdit"></div>
        <div id = "formDelete"></div>
    </div>
</div>
</div>
</body>
</html>