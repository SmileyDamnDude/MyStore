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
public abstract class Creation extends StartPrint{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("WEB-INF/pages/form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        try{
            add(request);
            response.sendRedirect("form");
        }
        catch (Exception exception){
            request.getSession().setAttribute("message", print(handle(exception)));
            request.getRequestDispatcher("WEB-INF/pages/form.jsp").forward(request, response);
        }
    }

    protected abstract void add(HttpServletRequest request)throws SQLException, NamingException,ParseException, NumberFormatException, NullPointerException, EJBException;
}
