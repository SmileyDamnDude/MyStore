<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактировать</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/MainStyle.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/edition.js"></script>
    <script type="text/javascript" src="js/addition.js"></script>
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

        var categories = '${categories}';
        var jsonCategories = JSON.parse(categories);

        var message = '${message}';

        $(document).ready(function () {
            load(jsonData, jsonCategories, message);
        });
    </script>

    <div class="bus">
        <h1>Редактировать</h1>
        <div id = "error" class = "error"></div>
        <form id = "editform"method="post" action="edit"></form>
    </div>
</div>
</div>
</body>
</html>