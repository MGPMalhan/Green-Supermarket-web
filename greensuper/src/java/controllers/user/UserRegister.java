/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.user.AuthService;
import utils.Validations;

public class UserRegister extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fullName = request.getParameter("full_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        List<String> validationErrors = Validations.validateRegisterForm(fullName, email, password, confirmPassword);

        if (validationErrors.isEmpty()) {

            User user = new User();
            user.setFullName(fullName);
            user.setEmail(email);
            user.setPassword(password);
            user.setConfirmPassword(confirmPassword);

            String result = AuthService.userRegister(user);

            if (result.equals("OK")) {
                request.setAttribute("OK", "User registration successfully");
               
            } else if(result.equals("EmailInvalid")) {
                request.setAttribute("FAILED", "A user already registerd with this email!");
            } else {
                request.setAttribute("BAD", "Something went wrong");
            }

        } else {
            request.setAttribute("errors", validationErrors);
        }
        
         request.getRequestDispatcher("login.jsp").forward(request, response);

    }

}
