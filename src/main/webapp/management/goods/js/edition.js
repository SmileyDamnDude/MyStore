var load = function (jsonData, jsonCategories, error) {
    if (error.length != 0) {
        $("#error").text(error);
        return -1;
    }
    if (jsonData.length == 0) {
        $("#error").text("Произошла ошибка. Товар не найден");
        return -1;
    }

    var form = $("#editform");
    var goods = jsonData[0];
    var category1 = goods['category'];

    form.append('<input type="hidden" id = "number" name = "number">');
    form.append('<input type="text" id = "title" name = "title" placeholder="Название товара (1 - 50 символов, включая пробелы и тире)" required pattern="^[A-Za-zА-Яа-яЁё0-9- ]{1,50}$">');
    form.append('<select class="category" id = "category" name = "categoryId" required ></select>');
    form.append('<input type="text" id = "price" name = "price" placeholder="Цена товара" required>');
    form.append('<input type="text" id = "count" name="count" placeholder="Количество">');
    form.append('<textarea type="text" id = "description" name = "description" placeholder="Описание"></textarea>');
    form.append('<input type="submit" value="Сохранить изменения">');
    form.append('<div class="stop"></div>');

    for (var i = 0; i < jsonCategories.length; i++){
        var category = jsonCategories[i];
        $(".category").append($("<option></option>").val(category['id']).html(category['title']));
    }

    $("#number").val(goods['id']);
    $("#title").val(goods['title']);
    $("#category").val(category1['id']);
    $("#price").val(goods['price']);
    $("#count").val(goods['count']);
    $("#description").val(goods['description']);
};