package servlets.goods;

import entities.Category;
import entities.Goods;
import service.CategoryDao;
import service.GoodsDao;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(value = "/management/goods/add")
public class Addition extends entity.Addition {

    @EJB
    private GoodsDao goodsDao;
    @EJB
    private CategoryDao categoryDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            ArrayList<Category> categories = categoryDao.findAll();
            request.setAttribute("categories", print(categories));
        }
        catch (Exception exception){
            request.getSession().setAttribute("message", handle(exception));
        }
        request.getRequestDispatcher("WEB-INF/pages/add.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        try{
            add(request);
        }
        catch (Exception exception){
            request.getSession().setAttribute("message", handle(exception));
        }
        response.sendRedirect("add");
    }

    protected void add(HttpServletRequest request)throws NumberFormatException, SQLException, EJBException, NullPointerException{
        Goods goods = Goods.getGoods(request);
        String message = goodsDao.saveGoods(goods) == 1 ? "Товар успешно добавлен" : "Ошибка добавления в базу данных";
        request.getSession().setAttribute("message", message);
    }
}
