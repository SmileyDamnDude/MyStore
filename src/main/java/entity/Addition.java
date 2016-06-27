package entity;

import javax.ejb.EJBException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@WebServlet
public abstract class Addition extends StartPrint{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("WEB-INF/pages/view.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        try{
            add(request);
            response.sendRedirect("view");
        }
        catch (Exception exception){
            request.getSession().setAttribute("message", handle(exception));
            request.getRequestDispatcher("WEB-INF/pages/view.jsp").forward(request, response);
        }
    }

    protected abstract void add(HttpServletRequest request)throws IOException, SQLException, NamingException,ParseException, NumberFormatException, NullPointerException, EJBException;
}
