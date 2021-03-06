package entity;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet
public abstract class ProfilePrint extends StartPrint{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            profile(request);
        }
        catch (Exception exception) {
            request.getSession().setAttribute("message", handle(exception));
        }
        request.getRequestDispatcher("WEB-INF/pages/profile.jsp").forward(request, response);
    }

    protected abstract void profile(HttpServletRequest request)throws IOException, SQLException, NamingException, NullPointerException;
}
