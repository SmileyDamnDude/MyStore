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
    var orders = '${orders}';
    var jsonOrders = JSON.parse(orders);

    var message = '${message}';

    $(document).ready(function () {
        prints(message, jsonOrders);
    });


    var ondelete = function (id) {
        $.ajax({
            type: 'POST',//тип запроса: get,post либо head
            url: 'office/delete',//url адрес файла обработчика
            data: {'order': id.toString()},//параметры запроса
            dataType: 'json',
            success: function (data) {//возвращаемый результат от сервера
                alert(data);
                location.reload();
            },
            error: function (msg) {
                var error = JSON.parse(msg.responseText);
                alert(error);
            }
        });
    };

    var prints = function (message, jsonOrders) {
        if (message.length != 0){
            $("#error").text(message);
            return -1;
        }

        if(jsonOrders.length == 0){
            $("#error").text("Заказы не найдены");
            return -1;
        }

        var table = $('<table></table>').addClass('table_blur');
        var row = $('<th>Номер</th><th>Название</th><th>Стоимость</th><th></th>');
        table.append(row);

        for (var j = 0; j < jsonOrders.length; j++) {
            var order = jsonOrders[j];
            var goods = order['goods'];

            row = $('<tr></tr>');
            var rowData = $('<td>' + order['id'] + '</td><td>' + goods['title'] + '</td><td>' + goods['price']  + '</td><td>' + '<input type="button" value="-" onclick="ondelete(' + order['id'] + ')">' + '</td>');
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
        <div class="error">Выбор товара</div>
        <div id = "error" class="error"></div>
    </div>
    <div id = "someContainer"></div>
</div>
</div>
</body>
</html>
