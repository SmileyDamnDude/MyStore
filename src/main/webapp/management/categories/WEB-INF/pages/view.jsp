<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Категории</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/table.css" rel="stylesheet" type="text/css">
    <link href="css/MainStyle.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/viewing.js"></script>
</head>
<body>

<script type="text/javascript">
    var message = '${message}';
    $(document).ready(function () {
        starts(message);
    });

    var ondelete = function (id) {
        $.ajax({
            type: 'POST',
            url: 'delete',
            data: {'category': id.toString()},
            dataType: 'json',
            success: function (data) {
                alert(data);
                location.reload();
            },
            error: function (msg) {
                var error = JSON.parse(msg.responseText);
                alert(error);
            }
        });
    };

    var search = function () {
        var result = $("#result");
        if (result != null){
            result.remove();
        }
        exception("");
        var param = $("#search").val();

        $.ajax({
            type: 'get',
            url: 'search',
            data: {'param': param},
            dataType: 'json',
            success: function (data) {
                if(data == null || data.length == 0){
                    exception("Не найдены категории");
                    return -1;
                }
                print(data);
            },
            error: function (rsp) {
                var error = JSON.parse(rsp.responseText);
                exception(error);
            }

        });
    };

    var starts = function (error) {
        if (error.length != 0){
            exception(error);
        }
    };

    var exception = function (msg) {
        $("#error").text(msg);
    };

    var print = function (jsonData) {
        var table = $('<table id = "result"></table>').addClass('table_blur');
        var row = $('<th>Номер</th><th>Название</th><th></th><th></th>');

        table.append(row);

        for (var j = 0; j < jsonData.length; j++) {
            var category = jsonData[j];
            var rowData;
            row = $('<tr></tr>');
            rowData = $('<td>' + category['id'] + '</td><td>' + category['title'] + '</td><td>' + '<input type="button" value="-" onclick="ondelete(' + category['id'] + ')">' + '</td>');
            row.append(rowData);

            table.append(row);
        }
        $('#someContainer').append(table);
    };

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
            <h1>Категории</h1>
            <div id = "error" class="error"></div>
            <form action="add" method="post">
                <input type="text" required placeholder="Название категории" name = "title" pattern="^[A-Za-zА-Яа-яЁё0-9 -]{1,50}$">
                <textarea type="text" placeholder="Описание" name = "description"></textarea>
                <div class="stopForm"></div>
                <input type="submit"  value="Добавить">
                <div class="Stop"></div>
            </form>


            <input type="text" placeholder="Название или id категории" id = "search">
            <div class="stopForm"></div>
            <input type="button"  id="searchButton" value="Поиск" onclick="search()">

            <div class="Stop"></div>
        </div>
        <div class="Stop"></div>
        <div id = "someContainer"></div>

    </div>
</div>

</body>
</html>
