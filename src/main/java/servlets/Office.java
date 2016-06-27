package servlets;

import entities.Order;
import entity.UnionSelect;
import service.OrderDao;
import service.UserDao;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/office")
public class Office extends UnionSelect {
    @EJB
    UserDao userDao;
    @EJB
    OrderDao orderDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        try{
            select(request);
        }
        catch (Exception exception){
            request.getSession().setAttribute("message", handle(exception));
        }
        request.getRequestDispatcher("WEB-INF/pages/office.jsp").forward(request, response);
    }

    protected void select(HttpServletRequest request) throws IOException, ParseException, IndexOutOfBoundsException, NamingException, SQLException, NullPointerException, EJBException {
        String username = request.getRemoteUser();
        ArrayList<Order> orders = orderDao.findOrdersByUsername(username);
        request.setAttribute("orders", print(orders));
    }
}
