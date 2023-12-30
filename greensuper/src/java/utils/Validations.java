/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.ArrayList;
import java.util.List;

public class Validations {

    public static List<String> validateRegisterForm(String fullName, String email, String password, String confirmPassword) {

        List<String> errors = new ArrayList<>();

        // Validate full name
        if (fullName == null || fullName.trim().isEmpty()) {
            errors.add("Full name is required.");
        }

        // Validate email
        if (email == null || email.trim().isEmpty()) {
            errors.add("Email is required.");
        } else if (!isValidEmail(email)) {
            errors.add("Invalid email format.");
        }

        // Validate password
        if (password == null || password.trim().isEmpty()) {
            errors.add("Password is required.");
        } else if (password.length() < 8) {
            errors.add("Password must be at least 8 characters long.");
        }

        // Validate confirmPassword
        if (confirmPassword == null || confirmPassword.trim().isEmpty()) {
            errors.add("Confirm password is required.");
        } else if (!confirmPassword.equals(password)) {
            errors.add("Passwords do not match.");
        }

        return errors;
    }

    public static List<String> validateLogiForm(String email, String password) {

        List<String> errors = new ArrayList<>();

        // Validate email
        if (email == null || email.trim().isEmpty()) {
            errors.add("Email is required.");
        } else if (!isValidEmail(email)) {
            errors.add("Invalid email format.");
        }

        // Validate password
        if (password == null || password.trim().isEmpty()) {
            errors.add("Password is required.");
        } else if (password.length() < 8) {
            errors.add("Password must be at least 8 characters long.");
        }

        return errors;
    }

    private static boolean isValidEmail(String email) {

        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }
}
