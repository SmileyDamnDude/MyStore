package servlets.categories;


import entities.Category;
import service.CategoryDao;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@WebServlet(value = "/management/categories/add")
public class Addition extends entity.Addition {//Добавление категории

    @EJB
    CategoryDao categoryDao;

    protected void add(HttpServletRequest request)throws NumberFormatException, SQLException, EJBException, NullPointerException{
        Category category = Category.getCategory(request);
        String message = categoryDao.saveCategory(category) == 1 ? "Категория успешно добавлена" : "Ошибка добавления в базу данных";
        request.getSession().setAttribute("message", message);
    }
}
