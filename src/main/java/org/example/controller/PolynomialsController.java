package org.example.controller;

import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialsController {
    public static boolean validatePolynomialInput(String input) {
        // If input is "-", treat as empty field and return true
        if (input.equals("-")) {
            return true;
        }

        // Regular expression for validating each monomial
        String regex = "[+-]?\\d*\\.?\\d*\\*?x?\\^?\\d*|[-+]?\\d*\\.?\\d+";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Split input into terms
        String[] terms = input.split("\\s*(?=[+-])");

        // Iterate through each term
        for (String term : terms) {
            // Trim any leading or trailing spaces
            term = term.trim();

            // Check if the term matches the pattern
            Matcher matcher = pattern.matcher(term);
            if (!matcher.matches()) {
                // If any term does not match, show error message and return false
                showErrorMessage("Invalid polynomial input: " + term);
                return false;
            }
        }

        // All terms match the pattern, return true
        return true;
    }




    // Method to show an error message dialog
    private static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
