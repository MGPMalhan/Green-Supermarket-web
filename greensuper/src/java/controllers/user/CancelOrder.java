/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.CartItem;
import models.User;
import services.user.UserService;
import utils.Mail;

public class CancelOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String orderId = request.getParameter("orderId");
        UserService.cancelOrder(orderId);

        Mail mail = new Mail();

        ArrayList<CartItem> items = (ArrayList<CartItem>) session.getAttribute("cart");

        try {
            mail.sendOrderCancelEmail(user.getFullName(), orderId, user.getEmail());
        } catch (MessagingException ex) {
            Logger.getLogger(CancelOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("MyOrders");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
