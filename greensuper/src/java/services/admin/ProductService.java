/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Product;
import utils.DbConnection;

public class ProductService {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static boolean addProduct(Product product) {
        boolean result = false;

        try {
            connection = DbConnection.getDbConnection();
            String query = "INSERT INTO products (name, image, category, price, quantity, unit) VALUES(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getImage());
            preparedStatement.setInt(3, product.getCategory());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getQuantity());
            preparedStatement.setString(6, product.getUnit());

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

    public static boolean updateProduct(Product product, int productId) {
        boolean result = false;

        try {
            connection = DbConnection.getDbConnection();
            String query = "UPDATE products SET name=?, image=?, category=?, price=?, quantity=?, unit=? WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getImage());
            preparedStatement.setInt(3, product.getCategory());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getQuantity());
            preparedStatement.setString(6, product.getUnit());
            preparedStatement.setInt(7, productId);

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

    public static boolean deleteProduct(int productId) {
        boolean result = false;

        try {
            connection = DbConnection.getDbConnection();
            String query = "DELETE FROM products WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productId);

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

    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>();

        try {
            connection = DbConnection.getDbConnection();
            String query = "select p.id as 'pid', p.name, p.image, c.name as 'category', p.price, p.quantity , p.unit from products p, categories c WHERE p.category = c.id";
            preparedStatement = connection.prepareStatement(query);
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

    public static Product getProductById(int id) {
        Product product = null;

        try {
            connection = DbConnection.getDbConnection();
            String query = "select p.id as 'pid', p.name, p.image, c.name as 'category', p.price, p.quantity , p.unit from products p, categories c WHERE p.category = c.id AND p.id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("pid"));
                product.setName(resultSet.getString("name"));
                product.setImage(resultSet.getString("image"));
                product.setCategoryName(resultSet.getString("category"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setUnit(resultSet.getString("unit"));
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

        return product;
    }

}
