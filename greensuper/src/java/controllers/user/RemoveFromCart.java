/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.CartItem;


public class RemoveFromCart extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int productId = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession();
        
        ArrayList<CartItem> cart = (ArrayList<CartItem>)session.getAttribute("cart");
        Iterator<CartItem> iter = cart.iterator();
        
        while(iter.hasNext()){
            CartItem temp = iter.next();
            
            if(temp.getProductId() == productId){
                iter.remove();
            }
        }

        
        response.sendRedirect("HomeController");
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }



}
