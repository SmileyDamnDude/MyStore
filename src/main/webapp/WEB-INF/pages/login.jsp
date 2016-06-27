<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page session="true"%>
<html>

<head>
	<title>Логин</title>


	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" />

	<link href="${pageContext.request.contextPath}/css/styleAdd1.css" rel="stylesheet" type="text/css">
</head>


<body onload='document.loginForm.username.focus();'>

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
						<li><a href="registration">Регистрация</a></li>
						<li class="last"><a href="#bottom_container">Контакты</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
<div id="loginForm">

	<section class="container">
		<div class="login">

			<h1>Логин</h1>

			<div id = "error" class = "fieldError"></div>
			<form method="post" action="j_security_check">
				<div>
					<input type="text" required name="j_username" placeholder="Логин">
				</div>
				<div><input type="text" required name="j_password" placeholder="Пароль"></div>
				<div class="submit">
					<input type="submit" name="Submit" value="Войти">
				</div>
			</form>


		</div>

	</section>


		</div>


	</div>
</body>
</html>