/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.CartItem;
import models.Order;
import models.Product;
import utils.DbConnection;

public class UserService {

    private static Connection connection;
    private static PreparedStatement preparedStatement, preparedStatement_order_details;
    private static ResultSet resultSet;

    public static ArrayList<Product> getProductsByCategory(int id) {
        ArrayList<Product> products = new ArrayList<Product>();

        try {
            connection = DbConnection.getDbConnection();
            String query = "select p.id as 'pid', p.name, p.image, c.name as 'category', p.price, p.quantity , p.unit from products p, categories c WHERE p.category = c.id AND c.id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("pid"));
                product.setName(resultSet.getString("name"));
                product.setImage(resultSet.getString("image"));
                product.setCategoryName(resultSet.getString("category"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setUnit(resultSet.getString("unit"));
                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }

    public static ArrayList<Product> searchProducts(String searchQuery) {
        ArrayList<Product> products = new ArrayList<Product>();

        try {
            connection = DbConnection.getDbConnection();
            String query = "SELECT * FROM products WHERE name LIKE ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + searchQuery + "%");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setImage(resultSet.getString("image"));
                product.setCategoryName(resultSet.getString("category"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setUnit(resultSet.getString("unit"));
                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }

    public static boolean saveOrder(ArrayList<CartItem> items, int userId, String date, String orderId) {
        boolean result = false;
        double total = 0;

        for (CartItem item : items) {
            total = total + item.getPrice() * item.getQuantity();
        }

        try {
            connection = DbConnection.getDbConnection();

            String query = "INSERT INTO orders (orderId, userId, orderDate,status, total) VALUES(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderId);
            preparedStatement.setInt(2, userId);
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, "Placed");
            preparedStatement.setDouble(5, total);
            result = preparedStatement.executeUpdate() > 0;

            if (result == true) {

                for (CartItem item : items) {
                    String queryNew = "INSERT INTO orderDetails(orderId,productId, quantity, subTotal)VALUES(?,?,?,?)";
                    preparedStatement_order_details = connection.prepareStatement(queryNew);
                    preparedStatement_order_details.setString(1, orderId);
                    preparedStatement_order_details.setInt(2, item.getProductId());
                    preparedStatement_order_details.setInt(3, item.getQuantity());
                    preparedStatement_order_details.setDouble(4, item.getQuantity() * item.getPrice());
                    result = preparedStatement_order_details.executeUpdate() > 0;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static ArrayList<Order> getMyOrders(int id) {
        ArrayList<Order> orders = new ArrayList<Order>();

        try {
            connection = DbConnection.getDbConnection();
            String query = "SELECT * FROM orders WHERE userId = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getString("orderId"));
                order.setDate(resultSet.getString("orderDate"));
                order.setTotal(resultSet.getDouble("total"));
                order.setStatus(resultSet.getString("status"));
                orders.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return orders;
    }

    public static boolean cancelOrder(String orderId) {
        boolean result = false;

        try {
            connection = DbConnection.getDbConnection();
            String query = "UPDATE orders SET status = ? WHERE orderId = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Cancelled");
            preparedStatement.setString(2, orderId);
            result = preparedStatement.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
