/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import models.Product;
import services.admin.ProductService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class UpdateProduct extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<String> errors = new ArrayList<String>();
        
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String unit = request.getParameter("unit");
        
        Product product = new Product();
        Product fetchedProduct = ProductService.getProductById(id);
        
        if (name == null || name.trim().isEmpty()) {
            errors.add("Name is required");
        } else {
            product.setName(name);
        }
        
        int category;
        try {
            category = Integer.parseInt(request.getParameter("category"));
            product.setCategory(category);
        } catch (NumberFormatException e) {
            errors.add("Category is invalid");
        }
        
        double price;
        try {
            price = Double.parseDouble(request.getParameter("price"));
            product.setPrice(price);
        } catch (NumberFormatException e) {
            errors.add("Price is invalid");
        }
        
        int quantity;
        try {
            quantity = Integer.parseInt(request.getParameter("quantity"));
            product.setQuantity(quantity);
        } catch (NumberFormatException e) {
            errors.add("Quantity is invalid");
        }
        
        if (unit == null || unit.trim().isEmpty()) {
            errors.add("Unit is invalid");
        } else {
            product.setUnit(unit);
        }
        
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        
        if (fetchedProduct.getImage() != null) {
            
        }
        
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        try {
            for (Part part : request.getParts()) {
                
                String fileName = extractFileName(part);
                
                if (!fileName.equals("unknown")) {
                    product.setImage(fileName);
                    part.write(uploadPath + File.separator + fileName);
                }
                
            }
        } catch (Exception e) {
            product.setImage(fetchedProduct.getImage());
        }
        
        if (errors.isEmpty()) {
            
            boolean isUpdated = ProductService.updateProduct(product, id);
            
            if (isUpdated == true) {
                
                request.setAttribute("success", "product is updated");
                
            } else {
                request.setAttribute("failed", "something went wrong");
            }
            
        } else {
            request.setAttribute("errors", errors);
        }
        
        request.getRequestDispatcher("WEB-INF/admin/update-product.jsp").forward(request, response);
    }
    
    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return "unknown";
    }
    
}
