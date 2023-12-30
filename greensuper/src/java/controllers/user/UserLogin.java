/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.user.AuthService;
import utils.Validations;

public class UserLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        List<String> validationErrors = Validations.validateLogiForm(email, password);

        if (validationErrors.isEmpty()) {
            User user = AuthService.userLogin(email, password);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("HomeController");
            } else {
                request.setAttribute("InvalidCred", "Invalid Credentials");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("loginErrors", validationErrors);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

}
