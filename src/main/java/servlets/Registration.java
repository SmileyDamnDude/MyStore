package servlets;

import entities.Role;
import entities.User;
import entity.HashPassword;
import entity.StartPrint;
import service.RoleDao;
import service.UserDao;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/registration")
public class Registration extends StartPrint {

    @EJB
    UserDao userDao;

    @EJB
    RoleDao roleDao;

    public void setDao(UserDao userDao, RoleDao roleDao){
        this.userDao = userDao;
        this.roleDao = roleDao;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("WEB-INF/pages/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        try{
            registration(request);
            response.sendRedirect("index");
        }
        catch (Exception exception){
            response.sendRedirect("registration");
        }
    }

    public void registration(HttpServletRequest request) throws NullPointerException, NumberFormatException, EJBException {
        if (request.getRemoteUser() != null){
            request.getSession().setAttribute("message", "Ошибка");
            throw new NullPointerException();
        }
        User user = User.createUser(request);
        if (user == null){
            request.getSession().setAttribute("message", "Произошла ошибка");
            throw new NullPointerException();
        }
        ArrayList<User> users = userDao.findByUsername(user.getUsername());
        User userDatabase = null;
        if (users.size() > 0){
            userDatabase = userDao.findByUsername(user.getUsername()).get(0);
        }
        if (userDatabase != null){
            request.getSession().setAttribute("message", "Пользователь с таким именем уже существует");
            throw new EJBException();
        }
        String hashPassword = HashPassword.getHashPassword(user.getUsername(), user.getPassword());
        user.setPassword(hashPassword);
        userDao.save(user);
        userDatabase = (User)userDao.findByUsername(user.getUsername()).get(0);
        Role role = new Role(userDatabase.getId(), "User");
        roleDao.save(role);
        request.getSession().setAttribute("message", "Регистрация выполнена успешно");
    }
}

