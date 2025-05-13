package org.example.view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

// PolynomialsPanel class, extends JPanel
public class PolynomialsPanel extends JPanel {

    private final JTextField txtFirstPolynomial;
    private final JTextField txtSecondPolynomial;
    private final JTextField txtResult; // Added txtResult

    // Constructor for PolynomialsPanel
    public PolynomialsPanel() {
        setLayout(new MigLayout("wrap")); // Set the layout using MigLayout with "wrap" constraint
        setOpaque(false); // Set panel to be transparent

        // Initialize text fields and labels
        txtFirstPolynomial = new JTextField(10);
        txtSecondPolynomial = new JTextField(10);
        txtResult = new JTextField(10);
        txtResult.setEditable(false); // Make result field non-editable
        JLabel lblFirstPolynomial = new JLabel("FIRST POLYNOMIAL");
        JLabel lblSecondPolynomial = new JLabel("SECOND POLYNOMIAL");
        JLabel lblResult = new JLabel("RESULT");

        // Set background color for text fields
        txtResult.setBackground(new Color(47, 47, 47));
        txtFirstPolynomial.setBackground(new Color(47, 47, 47));
        txtSecondPolynomial.setBackground(new Color(47, 47, 47));

        // Set font for labels
        setLabelFont(lblFirstPolynomial);
        setLabelFont(lblSecondPolynomial);
        setLabelFont(lblResult);

        // Add components to the panel with MigLayout constraints
        add(lblFirstPolynomial);
        add(txtFirstPolynomial, "growx"); // Text field expands horizontally
        add(lblSecondPolynomial);
        add(txtSecondPolynomial, "growx"); // Text field expands horizontally
        add(lblResult);
        add(txtResult, "growx"); // Text field expands horizontally
    }

    // Method to set the font for labels
    private void setLabelFont(JLabel label) {
        Font font = new Font("Nunito", Font.BOLD, 11); // Create a custom font
        label.setFont(font); // Set the font for the label
    }

    // Getter for txtFirstPolynomial
    public JTextField getTxtFirstPolynomial() {
        return txtFirstPolynomial;
    }

    // Getter for txtSecondPolynomial
    public JTextField getTxtSecondPolynomial() {
        return txtSecondPolynomial;
    }

    // Setter for txtResult
    public void setTxtResult(String resultText) {
        txtResult.setText(resultText);
    }
}
