package servlets.categories;

import entities.Category;
import entity.SearchingPrint;
import org.apache.commons.lang.math.NumberUtils;
import service.CategoryDao;

import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet(value = "/management/categories/search")
public class Searching extends SearchingPrint {

    @EJB
    CategoryDao categoryDao;

    protected List search(HttpServletRequest request) throws ParseException, IOException, SQLException, NumberFormatException, NamingException, NullPointerException {
        String param = request.getParameter("param");
        if(NumberUtils.isNumber(param)){
            return categoryDao.findById(new Integer(param));
        }
        if (param.length() != 0){
            return categoryDao.findByTitle(param);
        }
        return categoryDao.findAll();
    }
}
