var controlProfile = function (jsonData, error) {
    if (error.length != 0){
        $("#error").text(error);
    }

    var title = $("#title");

    if(jsonData.length == 0){
        title.text("Произошла ошибка. Товар не найден");
        return -1;
    }

    title.text("Данные о товаре");
    var element = $('#someContainer');
    var goods = jsonData[0];
    var category = goods['category'];
    element.append('<p>Номер: ' + goods['id'] + '</p>');
    element.append('<p>Название: ' + goods['title'] + '</p>');
    element.append('<p>Категория: ' + category['title'] + '</p>');
    element.append('<p>Цена: ' + goods['price'] + '</p>');
    element.append('<p>Количество: ' + goods['count'] + '</p>');

    $("#formEdit").append('<form method="get" action="edit">' +
        '<input type="hidden" name = "number" value="' + goods['id'] + '">' +
        '<input type="submit" value="Редактировать">' +
        '<div class="stopForm"></div>' +
        '</form>');

    $("#formDelete").append('<form method="post" action="delete">' +
        '<input type="hidden" name = "number" value="' + goods['id'] + '">' +
        '<input type="submit" value="Удалить">' +
        '<div class="stopForm"></div>' +
        '</form>');
};
