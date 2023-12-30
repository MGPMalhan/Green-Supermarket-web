/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;
import services.user.UserService;

public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Product> foods = UserService.getProductsByCategory(1);
        ArrayList<Product> nonFoods = UserService.getProductsByCategory(2);
        ArrayList<Product> frozenFoods = UserService.getProductsByCategory(3);
        ArrayList<Product> fruitsAndVeg = UserService.getProductsByCategory(4);
        ArrayList<Product> alcohol = UserService.getProductsByCategory(5);

        int[] count = {foods.size(), nonFoods.size(), frozenFoods.size(), fruitsAndVeg.size(), alcohol.size()};

        request.setAttribute("productCounts", count);

        request.getRequestDispatcher("home.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
