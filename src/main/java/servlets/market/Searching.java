package servlets.market;

import entities.Goods;
import entity.SearchingPrint;
import org.apache.commons.lang.math.NumberUtils;
import service.GoodsDao;

import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet(value = "/market/search")
public class Searching extends SearchingPrint {

    @EJB
    GoodsDao goodsDao;

    protected List search(HttpServletRequest request) throws ParseException, IOException, SQLException, NumberFormatException, NamingException, NullPointerException {
        String param = request.getParameter("param");
        if(NumberUtils.isNumber(param)){
            return goodsDao.findById(new Integer(param));
        }
        if (param.length() != 0){
            return goodsDao.findByTitle(param);
        }
        return goodsDao.findAll();
    }
}