
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

        var table = $('<table id = "result"></table>').addClass('table_blur');
        var row = $('<th>Номер</th><th>Категория</th><th>Название</th><th>Количество</th>');

        table.append(row);

        for (var j = 0; j < jsonData.length; j++) {
            var goods = jsonData[j];
            var category = goods['category'];
            row = $('<tr></tr>');
            var rowData = $('<td><a href = "profile?number=' + goods['id'] + '">' + goods['id'] + '</a></td><td>' + category['title'] + '</td><td>' +
                goods['price'] + '</td><td>' + goods['count'] + '</td>');
            row.append(rowData);
            table.append(row);
        }
        $('#someContainer').append(table);
    };

