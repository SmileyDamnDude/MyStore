package servlets.categories;


import entity.DeletingPrint;
import service.CategoryDao;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@WebServlet(value = "/management/categories/delete")
public class Deletion extends DeletingPrint {

    @EJB
    CategoryDao categoryDao;

    @Override
    protected String delete(HttpServletRequest request)throws SQLException, NumberFormatException, NullPointerException{
        int number = new Integer(request.getParameter("category"));
        return categoryDao.delete(number) > 0 ? "Категория удалена" : "Удаление не выполнено";
    }
}
