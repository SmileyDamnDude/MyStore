<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить товар</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/MainStyle.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="../../js/addition.js"></script>
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
        var message = '${message}';
        var categories = '${categories}';
        $(document).ready(function () {
            if (error.length != 0){
                $("#error").text(message);
            }
            var json = JSON.parse(categories);
            for (var i = 0; i < json.length; i++){
                var category = json[i];
                $(".category").append($("<option></option>").val(category['id']).html(category['title']));
            }

        });
    </script>

    <section class="container">
        <div class="bus">
            <h1>Добавление товара</h1>
            <div id = "error" class = "error"></div>
            <form method="post" action="add">
                <select type="text"  class="category" name = "categoryId" required></select>
                <input type="text" name = "title" placeholder="Название товара (1 - 50 символов, включая пробелы и тире)" required pattern="^[A-Za-zА-Яа-яЁё0-9- ]{1,50}$">
                <input type="text"  name = "price" placeholder="Цена товара" required>
                <input type="text" name = "count" placeholder="Количество">
                <textarea id = "description" type="text" name = "description" placeholder="Описание" maxlength="256"></textarea>
                <input type="submit" value="Добавить товар">
                <div class="stopForm"></div>
            </form>
        </div>
    </section>
    <div id="footer"></div>
</div>
</div>
</body>
</html>
