/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Product;
import services.admin.ProductService;

public class AdminLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        if (username.equals("admin") && password.equals("admin")) {
            session.setAttribute("admin", true);
            ArrayList<Product> products = ProductService.getAllProducts();
            request.setAttribute("count", products.size());
            request.getRequestDispatcher("WEB-INF/admin/home.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Invalid credentials");
            request.getRequestDispatcher("WEB-INF/admin/login.jsp").forward(request, response);
        }
    }

}
