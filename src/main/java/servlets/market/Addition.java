package servlets.market;

import entities.Order;
import entities.User;
import service.OrderDao;
import service.UserDao;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet(value = "/market/add")
public class Addition extends entity.AdditionPrint {

    @EJB
    OrderDao orderDao;
    @EJB
    UserDao userDao;

    protected String add(HttpServletRequest request) throws SQLException, ParseException, NumberFormatException, NullPointerException, EJBException {
        List<User> users = userDao.findByUsername(request.getRemoteUser());
        Order order = new Order(users.get(0).getId(), new Integer(request.getParameter("id")));
        return orderDao.saveOrder(order) == 1 ? "Заказ добавлен" : "Заказ не добавлен";
    }
}
