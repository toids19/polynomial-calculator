package org.example.controller;

import org.example.model.Operations;
import org.example.model.Polynomials;
import org.example.view.OperationsPanel;
import org.example.view.PolynomialsPanel;

public class OperationsController {

    private final PolynomialsPanel polynomialsPanel;  // Reference to the PolynomialsPanel
    private final OperationsPanel operationsPanel;    // Reference to the OperationsPanel

    // Constructor for OperationsController
    public OperationsController(PolynomialsPanel polynomialsPanel, OperationsPanel operationsPanel) {
        this.polynomialsPanel = polynomialsPanel;     // Initialize polynomialsPanel
        this.operationsPanel = operationsPanel;       // Initialize operationsPanel
    }

    // Method to perform an operation based on the given operation string
    public void performOperation(String operation) {
        // Check if either polynomialsPanel or operationsPanel is null
        if (polynomialsPanel == null || operationsPanel == null) {
            // If any of the panels are null, print an error message and return
            System.err.println("PolynomialsPanel or OperationsPanel is null. Cannot perform operation.");
            return;
        }

        // Get the text from the input fields of the PolynomialsPanel
        String poly1String = polynomialsPanel.getTxtFirstPolynomial().getText();
        String poly2String = polynomialsPanel.getTxtSecondPolynomial().getText();

        // Create two Polynomials objects
        Polynomials poly1 = new Polynomials();
        Polynomials poly2 = new Polynomials();

        // Parse the input strings into the Polynomials objects
        poly1.parsePolynomial(poly1String);
        poly2.parsePolynomial(poly2String);

        Polynomials result = null;  // Initialize the result to null

        // Perform the selected operation based on the input string
        switch (operation) {
            case "Addition":
                result = Operations.Addition(poly1, poly2);
                break;
            case "Subtraction":
                result = Operations.Subtraction(poly1, poly2);
                break;
            case "Multiplication":
                result = Operations.Multiplication(poly1, poly2);
                break;
            case "Division":
                // Perform division operation and set the result directly to the PolynomialsPanel
                String divisionResult = Operations.Division(poly1, poly2);
                polynomialsPanel.setTxtResult(divisionResult);
                break;
            case "Derivation":
                result = Operations.Derivation(poly1);
                break;
            case "Integration":
                // Perform integration operation and set the result directly to the PolynomialsPanel
                String integrationResult = Operations.Integration(poly1);
                polynomialsPanel.setTxtResult(integrationResult);
                break;
            default:
                // If an invalid operation is selected, print an error message
                System.out.println("Invalid operation selected.");
        }

        // If a result is obtained from the operation, display it in the Result text field of PolynomialsPanel
        if (result != null) {
            polynomialsPanel.setTxtResult(result.getPolynomialString());
        }
    }
}
