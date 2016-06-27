<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="date" class="java.util.Date" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Ошибка входа</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all">
</head>
<body>

<div id="main_container">
    <!-- FRAME -->
    <div id="frame">

        <!-- BEGIN HEADER -->
        <div id="top">
            <div id="logo">
                <div id="pad_logo">
                    <a href="index.html"><img src="image/logo.gif" alt="" /></a>
                </div>
            </div>

            <div id="topmenu">
                <div id="nav">
                    <ul id="menu">
                        <li class="current"><a class="active" href="index">Главная</a></li>
                        <li><a href="services">Услуги</a></li>
                        <li class="last"><a href="management">Управление</a></li>
                    </ul>
                </div>
            </div>
        </div>

    <div class="main-box">

        <p>Вход не выполнен</p>
        <p>Неверный логин или пароль</p>
        <!--
        <li>Дата и время: <fmt:formatDate value="${date}" type="both" dateStyle="long" timeStyle="long" />
        <li>URI: <c:out value="${requestScope['javax.servlet.forward.request_uri']}" />
        <li>Браузер: <c:out value="${header['user-agent']}" />
-->
    </div>
    </div>
</div>
</body>
</html>