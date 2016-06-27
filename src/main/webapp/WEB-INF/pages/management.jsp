<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Управление</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" />

</head>
<body>

<div id="main_container">
    <!-- FRAME -->
    <div id="frame">

        <!-- BEGIN HEADER -->
        <div id="top">
            <div id="logo">
                <div id="pad_logo">
                    <a href="index"><img src="image/logo.gif" alt="" /></a>
                </div>
            </div>

            <div id="topmenu">
                <div id="nav">
                    <ul id="menu">
                        <li><a href="index">Главная</a></li>
                        <li><a href="management/categories/view">Категории</a></li>
                        <li><a href="management/goods/add">Добавить товар</a></li>
                        <li><a href="management/goods/view">Просмотреть товары</a></li>
                        <li class="last"><a href="management">Управление</a></li>
                    </ul>
                </div>
            </div>
        </div>

    <h3>Вы находитесь в административном центре сайта</h3>

        </div>
    </div>

</div>
</body>
</html>
