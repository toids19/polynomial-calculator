package org.example.view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

// CalculatorView class, extends JPanel
public class CalculatorView extends JPanel {

    private PolynomialsPanel polynomialsPanel;

    // Constructor for CalculatorView
    public CalculatorView() {
        init(); // Call initialization method
    }

    // Initialization method
    private void init() {
        // Set the layout of the CalculatorView using MigLayout with "fill" constraint
        setLayout(new MigLayout("fill"));

        // Create instances of the panels
        // Declare instance variables for panels
        polynomialsPanel = new PolynomialsPanel();
        OperationsPanel operationsPanel = new OperationsPanel(polynomialsPanel, new OperationsPanel(polynomialsPanel, null)); // Pass a temporary OperationsPanel

        // Inside CalculatorView or wherever DigitPanel is instantiated
        DigitPanel digitPanel = new DigitPanel(polynomialsPanel);

        // Add the panels to the CalculatorView with constraints
        add(polynomialsPanel, "width 200px, height 100px, aligny top"); // PolynomialsPanel with specific width, height, and alignment
        add(operationsPanel, "width 250px, height 200px, aligny top, right, wrap"); // OperationsPanel with specific width, height, alignment, and wrapping
        add(digitPanel, "span, grow, wrap"); // DigitPanel with "span" to take remaining space, "grow" to grow horizontally, and wrapping

        // Set the background color of the CalculatorView
        Color backgroundColor = new Color(0xFF2F2F2F, true); // Create a color with transparency
        setBackground(backgroundColor);

        setPreferredSize(new Dimension(400, 400));  // Set the preferred size of the CalculatorView
    }

    // Getter for PolynomialsPanel
    public PolynomialsPanel getPolynomialsPanel() {
        return polynomialsPanel;
    }

}
