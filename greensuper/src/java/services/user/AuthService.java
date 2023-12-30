/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DbConnection;
import models.User;

public class AuthService {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static boolean checkEmail(String email) {

        boolean isExists = false;

        try {
            connection = DbConnection.getDbConnection();
            String query = "SELECT COUNT(*) FROM users WHERE email = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            isExists = resultSet.next() && resultSet.getInt(1) > 0;

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

        return isExists;
    }

    public static String userRegister(User user) {
        String result = null;

        if (!checkEmail(user.getEmail())) {
            try {
                connection = DbConnection.getDbConnection();
                String query = "INSERT INTO users (full_name, email, password, confirm_password) VALUES (?,?,?,?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, user.getFullName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setString(4, user.getConfirmPassword());
                if (preparedStatement.executeUpdate() > 0) {
                    result = "OK";
                } else {
                    result = "BAD";
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
        } else {
            result = "EmailInvalid";
        }

        return result;
    }

    public static User userLogin(String email, String password) {
        User user = null;

        try {
            connection = DbConnection.getDbConnection();
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
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

        return user;
    }
}
