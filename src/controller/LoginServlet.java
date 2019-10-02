package controller;

import dal.Repo;
import dal.Repository;
import model.User;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Repo repo           = Repository.getRepository();
        List<User> users    = repo.getUsers();
        String email        = request.getParameter("email");
        String password     = Util.convertToSHA256(request.getParameter("password"));

        PrintWriter out = response.getWriter();
        for (User user: users) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                out.write("Logged in as: " + user.getEmail() + " with password: " + user.getPassword());
                out.close();
                return;
            }
        }
        out.write("Nope!");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/home");
    }
}
