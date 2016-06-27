package servlets.goods;

import entity.DeletionEntity;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@WebServlet(value = "/management/goods/delete")
public class Deletion extends DeletionEntity {



    @Override
    protected void delete(HttpServletRequest request)throws SQLException, NumberFormatException, NullPointerException{
       /* int number = new Integer(request.getParameter("number"));
        String message = busDao.delete(number) > 0 ? "Автобус удален из базы" : "Удаление не выполнено";
        request.getSession().setAttribute("error", message);*/
    }
}
