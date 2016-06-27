<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Регистрация</title>
    <link href="${pageContext.request.contextPath}/css/styleAdd2.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.min.js"></script>
</head>


<body onload='document.loginForm.username.focus();'>

<script type="text/javascript">
    var message = '${message}';

    $(document).ready(function () {
        if (message.length != 0){
            $("#error").text(message);
        }
    });
</script>

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
                        <li><a class="active" href="index">Главная</a></li>
                        <li><a href="services">Услуги</a></li>
                        <li><a href="management">Управление</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div id="loginForm">

        <section class="container">
            <div class="login">

                <h1>Регистрация</h1>
                <div id = "error" class = "fieldError"></div>
                <form method="post" action="registration">
                    <div><input required type="text" name="username" placeholder="Логин"></div>
                    <div><input required type="password" name="password1" placeholder="Пароль"></div>
                    <div><input required type="password" name="password2" placeholder="Повторите пароль"></div>
                    <div><input required type="email" name="email" placeholder="Адрес электронной почты"></div>
                    <div class="submit"><input type="submit" name="Submit" value="Регистрация"></div>
                </form>
            </div>

        </section>

    </div>
</div>
</body>