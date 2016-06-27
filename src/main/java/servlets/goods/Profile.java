package servlets.goods;

import entities.Goods;
import entity.ProfilePrint;
import service.GoodsDao;

import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(value = "/management/goods/profile")
public class Profile extends ProfilePrint {

    @EJB
    private GoodsDao goodsDao;

    @Override
    protected void profile(HttpServletRequest request) throws IOException, SQLException, NamingException, NullPointerException{
        int number = new Integer(request.getParameter("number"));
        ArrayList<Goods> goodses = goodsDao.findById(number);
        request.setAttribute("goods", print(goodses));
    }
}
