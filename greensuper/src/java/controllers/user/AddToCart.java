/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.CartItem;
import models.Product;
import services.admin.ProductService;

public class AddToCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("productId"));
        int catId = Integer.parseInt(request.getParameter("catId"));
        String catName = request.getParameter("categoryName");
        int qty = Integer.parseInt(request.getParameter("qty"));

        PrintWriter out = response.getWriter();

        if (qty != 0) {
            HttpSession session = request.getSession();

            Product addedProduct = ProductService.getProductById(productId);

            ArrayList<CartItem> cartItems;

            if (session.getAttribute("cart") == null) {
                cartItems = new ArrayList<CartItem>();
                CartItem cartItem = new CartItem();
                cartItem.setProductId(productId);
                cartItem.setQuantity(qty);
                cartItem.setPrice(addedProduct.getPrice());
                cartItem.setImage(addedProduct.getImage());
                cartItem.setName(addedProduct.getName());

                cartItems.add(cartItem);

                session.setAttribute("cart", cartItems);
            } else {
                cartItems = (ArrayList<CartItem>) session.getAttribute("cart");

                boolean productExists = false;

                for (CartItem item : cartItems) {
                    if (item.getProductId() == productId) {
                        item.setQuantity(qty);
                        productExists = true;
                        break;
                    }
                }

                if (!productExists) {
                    CartItem cartItem = new CartItem();
                    cartItem.setProductId(productId);
                    cartItem.setQuantity(qty);
                    cartItem.setPrice(addedProduct.getPrice());
                    cartItem.setImage(addedProduct.getImage());
                    cartItem.setName(addedProduct.getName());

                    cartItems.add(cartItem);
                }

                session.setAttribute("cart", cartItems);

            }

            response.sendRedirect(String.format("ProductsByCategory?id=%d&category=%s", catId, catName));

        } else {
            response.sendRedirect(String.format("ProductsByCategory?id=%d&category=%s", catId, catName));
        }

    }

}
