package servlets.office;


import entity.DeletingPrint;
import service.OrderDao;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@WebServlet(value = "/office/delete")
public class Deletion extends DeletingPrint {

    @EJB
    OrderDao orderDao;

    protected String delete(HttpServletRequest request)throws SQLException, NumberFormatException, NullPointerException{
        int order = new Integer(request.getParameter("order"));
        return orderDao.delete(order) > 0 ? "Заказ удален" : "Заказ не удален";
    }
}
