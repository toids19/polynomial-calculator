package org.example.view;

import org.example.controller.OperationsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// OperationsPanel class, extends JPanel
public class OperationsPanel extends JPanel {

    // Constructor for OperationsPanel
    public OperationsPanel(PolynomialsPanel polynomialsPanel, OperationsPanel operationsPanel) {

        // Set layout to GridLayout with 6 rows, 1 column, and gaps between buttons
        setLayout(new GridLayout(6, 1, 2, 5)); // 2 pixels horizontal gap, 5 pixels vertical gap
        setOpaque(false); // Set panel to be transparent

        // Create buttons for different operations
        JButton cmdAddition = new JButton("Addition");
        JButton cmdSubtraction = new JButton("Subtraction");
        JButton cmdMultiply = new JButton("Multiplication");
        JButton cmdDivide = new JButton("Division");
        JButton cmdDerivativation = new JButton("Derivation");
        JButton cmdIntegration = new JButton("Integration");

        // Set background colors for buttons
        cmdAddition.setBackground(new Color(208, 125, 0)); // Orange color
        cmdSubtraction.setBackground(new Color(208, 125, 0)); // Orange color
        cmdMultiply.setBackground(new Color(208, 125, 0)); // Orange color
        cmdDivide.setBackground(new Color(208, 125, 0)); // Orange color
        cmdDerivativation.setBackground(new Color(73, 73, 73)); // Dark gray color
        cmdIntegration.setBackground(new Color(73, 73, 73)); // Dark gray color

        // Add buttons to the OperationsPanel
        add(cmdAddition);
        add(cmdSubtraction);
        add(cmdMultiply);
        add(cmdDivide);
        add(cmdDerivativation);
        add(cmdIntegration);

        // Add action listeners to the operation buttons
        cmdAddition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperationsController operationsController = new OperationsController(polynomialsPanel, operationsPanel);
                operationsController.performOperation("Addition");
            }
        });

        cmdSubtraction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperationsController operationsController = new OperationsController(polynomialsPanel, operationsPanel);
                operationsController.performOperation("Subtraction");
            }
        });

        cmdMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperationsController operationsController = new OperationsController(polynomialsPanel, operationsPanel);
                operationsController.performOperation("Multiplication");
            }
        });

        cmdDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperationsController operationsController = new OperationsController(polynomialsPanel, operationsPanel);
                operationsController.performOperation("Division");
            }
        });

        cmdDerivativation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperationsController operationsController = new OperationsController(polynomialsPanel, operationsPanel);
                operationsController.performOperation("Derivation");
            }
        });

        cmdIntegration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperationsController operationsController = new OperationsController(polynomialsPanel, operationsPanel);
                operationsController.performOperation("Integration");
            }
        });
    }

}
