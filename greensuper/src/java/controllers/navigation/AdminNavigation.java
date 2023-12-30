/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.navigation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;
import services.admin.ProductService;

public class AdminNavigation extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String to = request.getParameter("to");
        if (to.equals("AdminHome")) {
            ArrayList<Product> products = ProductService.getAllProducts();
            request.setAttribute("count", products.size());
            request.getRequestDispatcher("WEB-INF/admin/home.jsp").forward(request, response);
        } else if (to.equals("Products")) {
            
            ArrayList<Product> products = ProductService.getAllProducts();
            request.setAttribute("products", products);
            request.getRequestDispatcher("WEB-INF/admin/products.jsp").forward(request, response);
        } else if (to.equals("AddProduct")) {
            request.getRequestDispatcher("WEB-INF/admin/add-product.jsp").forward(request, response);
        } else if (to.equals("GetById")) {
            int id = Integer.parseInt(request.getParameter("id"));
            response.sendRedirect("GetProductById?id=" + id);
        } else if (to.equals("DeleteById")) {
            int id = Integer.parseInt(request.getParameter("id"));
            response.sendRedirect("DeleteProduct?id=" + id);
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
}
