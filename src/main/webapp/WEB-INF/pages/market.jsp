<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Товары</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/MainStyle.css" rel="stylesheet" type="text/css">
    <link href="css/table.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
</head>
<body>

<script type="text/javascript">
    var error = '${error}';

    $(document).ready(function () {
        starts(error);
    });

    var onadd = function (id) {

        try{
            $.ajax({
                type: 'POST',
                url: 'market/add',
                data: {'id': id},
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
        }

        catch (e){
            exception(e.message);
        }
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
            url: 'market/search',
            data: {'param': param},
            dataType: 'json',
            success: function (data) {
                if(data == null || data.length == 0){
                    exception("Не найдены товары");
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
        $("#title").text("Список товаров");

        var table = $('<table id = "result"></table>').addClass('table_blur');
        var row = $('<th>Номер</th><th>Название</th><th>Количество</th><th>Цена</th><th></th>');



        table.append(row);

        for (var j = 0; j < jsonData.length; j++) {
            var goods = jsonData[j];
            var category = goods['category'];
            row = $('<tr></tr>');

            var rowData = $('<td>' + goods['id'] + '</td><td>' + goods['title'] + '</td><td>' + goods['count'] + '</td><td>' + goods['price']
                    + '</td><td>' + '<input type="button" value="+" onclick="onadd(' + goods['id'] + ')">' + '</td>');
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
                        <li class="current"><a class="active" href="index">Главная</a></li>
                        <li class="last"><a href="management">Управление</a></li>
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
