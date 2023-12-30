/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.user;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;
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
import services.user.PaymentServices;
import services.user.UserService;
import utils.GetCurrentDateAndTime;
import utils.Mail;

public class execute_payment extends HttpServlet {

    public static String generateTransactionId() {
        UUID uuid = UUID.randomUUID();
        String transactionId = uuid.toString().replaceAll("-", "");
        return transactionId;
    }

    public static String generateOrderId() {
        UUID uuid = UUID.randomUUID();
        String orderID = uuid.toString().replaceAll("-", "");
        return orderID;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");

        ArrayList<CartItem> items = (ArrayList<CartItem>) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        try {
            PaymentServices paymentServices = new PaymentServices();
            Payment payment = paymentServices.executePayment(paymentId, payerId);

            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);

            String date = GetCurrentDateAndTime.getCurrentDate();
            String time = GetCurrentDateAndTime.getCurrentTime();
            String orderId = generateTransactionId();
            double total = 0;

            request.setAttribute("payer", payerInfo);
            request.setAttribute("transaction", transaction);
            request.setAttribute("date", date);
            request.setAttribute("time", time);
            request.setAttribute("orderId", orderId);

            for (CartItem item : items) {
                total = total + item.getPrice() * item.getQuantity();
            }

            UserService.saveOrder(items, user.getId(), date, orderId);
            
            session.removeAttribute("cart");

            Mail mail = new Mail();

            try {
                mail.sendOrderSuccessEmail(user.getFullName(), date, time, user.getEmail(), orderId, total);
            } catch (MessagingException ex) {
                Logger.getLogger(execute_payment.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.getRequestDispatcher("receipt.jsp").forward(request, response);

        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
