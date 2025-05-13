package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DigitPanel extends JPanel {

    private JTextField selectedField; // Field to store the currently selected text field

    // Constructor for DigitPanel
    public DigitPanel(PolynomialsPanel polynomialsPanel) {

        // Set layout to GridLayout with 4 rows, 4 columns, and gaps between buttons
        setLayout(new GridLayout(4, 4, 3, 3)); // 3 pixels horizontal gap, 3 pixels vertical gap
        setOpaque(false); // Set panel to be transparent

        // Create and add buttons for different digits and operations

        // Button to clear the input
        JButton cmdClear = new JButton("AC");
        cmdClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearText(); // Clear the text of the selected field
            }
        });
        add(cmdClear); // Add the button to the DigitPanel

        // Button for x
        JButton cmdX = new JButton("X");
        cmdX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendText("x"); // Append "*" to the selected field
            }
        });
        add(cmdX); // Add the button to the DigitPanel


        // Button for exponentiation
        JButton cmdPower = new JButton("<html>x<sup>y</sup></html>");

        cmdPower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendText("x^"); // Append "x^" to the selected field
            }
        });
        add(cmdPower); // Add the button to the DigitPanel

        // Loop to create and add digit buttons from 0 to 9
        for (int i : new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}){
            JButton digitButton = new JButton(Integer.toString(i)); // Create a button with the digit label
            digitButton.setBackground(new Color(114, 114, 114)); // Set background color for digit buttons
            digitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    appendText(digitButton.getText()); // Append the digit to the selected field
                }
            });
            digitButton.setFocusable(false); // Ensure the button doesn't grab focus
            add(digitButton); // Add the digit button to the DigitPanel
        }

        // Button for addition
        JButton cmdPlus = new JButton("+");
        cmdPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendText("+"); // Append "+" to the selected field
            }
        });
        add(cmdPlus); // Add the button to the DigitPanel

        // Button for subtraction
        JButton cmdMinus = new JButton("-");
        cmdMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendText("-"); // Append "-" to the selected field
            }
        });
        add(cmdMinus); // Add the button to the DigitPanel


        // Button for Exit
        JButton cmdExit = new JButton("Exit");
        cmdExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exits the program with status 0
            }
        });
        add(cmdExit); // Add the button to the DigitPanel


        // Add FocusListener to polynomial text fields to update selectedField
        polynomialsPanel.getTxtFirstPolynomial().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                selectedField = polynomialsPanel.getTxtFirstPolynomial();
            }
        });

        polynomialsPanel.getTxtSecondPolynomial().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                selectedField = polynomialsPanel.getTxtSecondPolynomial();
            }
        });
    }

    // Method to append text to the selected field
    private void appendText(String text) {
        if (selectedField != null) {
            selectedField.setText(selectedField.getText() + text); // Append the provided text to the existing text
        }
    }

    // Method to clear the text of the selected field
    private void clearText() {
        if (selectedField != null) {
            selectedField.setText(""); // Clear the text of the selected field
        }
    }
}
