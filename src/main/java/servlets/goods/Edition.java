package servlets.goods;


import entities.Category;
import entities.Goods;
import entity.EditionPrint;
import service.CategoryDao;
import service.GoodsDao;


import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(value = "/management/goods/edit")
public class Edition extends EditionPrint {

    @EJB
    private GoodsDao goodsDao;
    @EJB
    private CategoryDao categoryDao;

    @Override
    protected void select(HttpServletRequest request) throws IOException, SQLException, NamingException, NumberFormatException, NullPointerException{
        int number = new Integer(request.getParameter("number"));
        ArrayList<Goods> goods = goodsDao.findById(number);
        request.setAttribute("goods", print(goods));
        ArrayList<Category> categories = categoryDao.findAll();
        request.setAttribute("categories", print(categories));
    }

    @Override
    protected void edit(HttpServletRequest request) throws SQLException, NumberFormatException, NullPointerException, EJBException{
        Goods goods = Goods.getGoods(request);
        String message = goodsDao.updateGoods(goods) > 0 ? "Изменения сохранены" : "Изменения не сохранены";
        request.getSession().setAttribute("error", message);
    }
}
