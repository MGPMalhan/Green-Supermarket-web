/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.paypal.base.rest.PayPalRESTException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import models.CartItem;

import models.OrderDetails;
import models.User;
import services.user.PaymentServices;

public class AuthorizePayment extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AuthorizePayment</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AuthorizePayment at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<CartItem> items = (ArrayList<CartItem>) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
        } else {
            List<OrderDetails> orders = new ArrayList<OrderDetails>();

            for (CartItem orderItem : items) {
                OrderDetails order = new OrderDetails(orderItem.getName(), String.valueOf(orderItem.getPrice() * orderItem.getQuantity()), "0", "0", String.valueOf(orderItem.getPrice() * orderItem.getQuantity()));
                orders.add(order);
            }

            try {
                PaymentServices paymentServices = new PaymentServices();
                String approvalLink = paymentServices.authorizePayment(orders);
                response.sendRedirect(approvalLink);

            } catch (Exception ex) {
                request.setAttribute("errorMessage", ex.getMessage());
                ex.printStackTrace();
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }

    }

}
