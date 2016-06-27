<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Товары</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/MainStyle.css" rel="stylesheet" type="text/css">
    <link href="css/table.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/viewing.js"></script>
</head>
<body>

<script type="text/javascript">
    var error = '${error}';

    $(document).ready(function () {
        starts(error);
    });
</script>

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

    <div class="bus">
        <div class="error">Выбор товара</div>
        <div id = "error" class="error"></div>
        <div class="search">
            <input type="text" placeholder="Название или id товара" id = "search">
            <input type="button" value="Поиск" onclick="search()">
        </div>
    </div>
    <div id = "someContainer"></div>
</div>
</div>
</body>
</html>
