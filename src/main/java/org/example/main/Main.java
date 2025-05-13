package org.example.main;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import org.example.controller.PolynomialsController;
import org.example.view.CalculatorView;
import org.example.view.PolynomialsPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.IOException;

// Main class that extends JFrame
public class Main extends JFrame {

    // Declaring selectedField at the class level

    // Constructor for Main class
    public Main() {
        init(); // Call initialization method
    }

    // Initialization method
    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation
        setLocationRelativeTo(null); // Set location of the frame to center of the screen
    }

    // Main method, entry point of the program
    public static void main(String[] args) {
        FlatRobotoFont.install(); // Install Roboto font
        FlatLaf.registerCustomDefaultsSource("util.themes"); // Register custom FlatLaf themes
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13)); // Set default font
        FlatMacDarkLaf.setup(); // Setup FlatLaf with Mac Dark theme

        // Using EventQueue to ensure Swing components are created and accessed on the Event Dispatch Thread
        EventQueue.invokeLater(() -> {
            CalculatorView calculatorView = new CalculatorView(); // Create an instance of CalculatorView
            JFrame frame = new JFrame(""); // Create a new JFrame instance
            try {
                // Load the PNG icon image with absolute path
                Image iconImage = ImageIO.read(new File("/Users/moldovanutudor/Desktop/Tudor/UT/PT/pt2024_30421_moldovanu_tudor_assignment_1/src/main/resources/calculator_icon_normal.png"));
                if (iconImage != null) {
                    frame.setIconImage(iconImage);
                    System.out.println("Icon set successfully");
                } else {
                    System.out.println("Failed to load icon image");
                }
            } catch (IOException e) {
                System.err.println("Error setting icon: " + e.getMessage());
            }





            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation
            frame.getContentPane().add(calculatorView); // Add calculatorView to the content pane of the frame
            frame.pack(); // Pack the frame to fit its contents
            frame.setLocationRelativeTo(null); // Set location of the frame to center of the screen
            frame.setVisible(true); // Make the frame visible
            frame.setResizable(false); // Make the frame not resizable

            // Get the panels from CalculatorView
            PolynomialsPanel polynomialsPanel = calculatorView.getPolynomialsPanel();

            // Set the first polynomial text field selected
            polynomialsPanel.getTxtFirstPolynomial().requestFocus();

            // Focus listener to handle text field selection
            FocusAdapter focusAdapter = new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    JTextField textField = (JTextField) e.getComponent();
                    if (!PolynomialsController.validatePolynomialInput(textField.getText())) {
                        // If input is invalid, show error message directly from the function controller
                        textField.requestFocusInWindow(); // Return focus to the text field
                    }
                }
            };

            // Add focus listener to both polynomial text fields
            polynomialsPanel.getTxtFirstPolynomial().addFocusListener(focusAdapter);
            polynomialsPanel.getTxtSecondPolynomial().addFocusListener(focusAdapter);
        });
    }

}
