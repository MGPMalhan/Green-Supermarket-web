/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.user;

import static controllers.user.execute_payment.generateTransactionId;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.CartItem;
import models.User;
import services.user.UserService;
import utils.GetCurrentDateAndTime;

public class PlaceOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        double total = 0;
        String date = GetCurrentDateAndTime.getCurrentDate();
        String orderId = generateTransactionId();

        if (user != null) {
            ArrayList<CartItem> items = (ArrayList<CartItem>) session.getAttribute("cart");

            for (CartItem item : items) {
                total = total + item.getPrice() * item.getQuantity();
            }

            UserService.saveOrder(items, user.getId(), date, orderId);

            session.removeAttribute("cart");

            PrintWriter out = response.getWriter();
            out.println("<script>alert('Order placed successfully'); window.location.href='http://localhost:8080/greensuper/HomeController'</script>");
        } else {
            response.sendRedirect("login.jsp");
        }

    }

}
