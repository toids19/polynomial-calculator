package org.example.model;

import java.util.*;

public class Polynomials {
    public Map<Integer, Integer> terms;  // Map to store polynomial terms

    public Polynomials() {
        terms = new HashMap<>();  // Initialize the terms map
    }

    // Constructor to create a new polynomial from an existing one
    public Polynomials(Polynomials polynomial) {
        this.terms = new HashMap<>(polynomial.terms);
    }

    // Add a term to the polynomial
    public void addTerm(int exponent, int coefficient) {
        terms.put(exponent, coefficient);  // Add a term with given exponent and coefficient
    }

    // Get the coefficient of a term with given exponent
    public int getCoefficient(int exponent) {
        return terms.getOrDefault(exponent, 0);  // Get the coefficient or 0 if not present
    }

    // Print the polynomial in a readable format without spaces
    public String getPolynomialString() {
        StringBuilder sb = new StringBuilder();  // String builder to construct the output

        boolean firstTerm = true;  // Flag for first term in the polynomial

        // Create a custom comparator to sort keys (exponents) in reverse order
        Comparator<Integer> reverseComparator = Comparator.reverseOrder();

        // Create a sorted set of the exponents using the custom comparator
        SortedSet<Integer> sortedExponents = new TreeSet<>(reverseComparator);
        sortedExponents.addAll(terms.keySet());

        for (int exponent : sortedExponents) {
            int coefficient = terms.get(exponent);  // Get the coefficient for the exponent

            if (coefficient != 0) {  // Only include non-zero terms
                if (firstTerm) {
                    firstTerm = false;
                } else {
                    if (coefficient > 0) {
                        sb.append("+");
                    } else {
                        sb.append("-");
                        coefficient = -coefficient;  // Make coefficient positive for output
                    }
                }

                if (exponent == 0) {
                    sb.append(coefficient);  // Constant term
                } else if (exponent == 1) {
                    if (coefficient == 1) {
                        sb.append("x");// If it's 1 we add just the term
                    }
                        else if (coefficient == -1) {
                            sb.append("-x");
                        }
                     else {
                        sb.append(coefficient).append("x");  // Coefficient and 'x'
                    }
                } else {
                    if (coefficient == 1) {
                        sb.append("x^").append(exponent);  // Exponent term with 'x'
                    } else {
                        sb.append(coefficient).append("x^").append(exponent);  // Coefficient, 'x', and exponent
                    }
                }
            }
        }
        return sb.toString();  // Return the final polynomial as a string
    }


    public void parsePolynomial(String input) {
        terms.clear(); // Clear the existing terms

        // If the input is just a '-', return (this is likely an edge case for no terms)
        if (input.equals("-")) {
            return;
        }

        // Split the input by "+" or "-"
        String[] parts = input.split("(?=[+-])");

        // Iterate through each part of the polynomial
        for (String part : parts) {
            // Split each part by "x^" to separate coefficient and exponent
            String[] subParts = part.split("x\\^");

            // Initialize coefficient and exponent variables
            int coefficient;
            int exponent;

            // Handle the case of missing coefficient or exponent
            if (subParts.length == 1) {
                // If there is no "x^" term, we are dealing with a constant or "x" term
                String[] subPartsX = subParts[0].split("x");

                if (subPartsX.length == 1 && subPartsX[0].equals(subParts[0])) {
                    // Case: Constant term (like "5")
                    coefficient = Integer.parseInt(subParts[0]);
                    exponent = 0; // Constant term has an exponent of 0
                } else if (subPartsX.length == 0) {
                    // Case: Only "x" term (like "x")
                    coefficient = 1; // Coefficient of 1 if not specified
                    exponent = 1;    // Exponent of 1 for "x"
                } else {
                    // Case: "x" term with a coefficient (like "2x" or "-x")
                    exponent = 1; // Exponent of 1 for "x"

                    if (subPartsX[0].equals("+")) {
                        coefficient = 1; // Coefficient is 1 for "+x"
                    } else if (subPartsX[0].equals("-")) {
                        coefficient = -1; // Coefficient is -1 for "-x"
                    } else {
                        coefficient = Integer.parseInt(subPartsX[0]); // Get the coefficient
                    }
                }
            } else {
                // If there is an "x^" term, parse coefficient and exponent
                if (subParts[0].isEmpty()) {
                    coefficient = 1; // Default coefficient of 1 if omitted
                } else if (subParts[0].equals("-")) {
                    coefficient = -1; // Coefficient of -1 if "-x^"
                } else {
                    coefficient = Integer.parseInt(subParts[0]); // Get the coefficient
                }

                exponent = Integer.parseInt(subParts[1]); // Get the exponent
            }

            // Add the term to the map
            terms.put(exponent, coefficient);
        }
    }


    // Method to order the terms of the polynomial by degree in descending order
    public void orderByDegree() {
        // Create a new LinkedHashMap to store the sorted entries
        Map<Integer, Integer> sortedTerms = new LinkedHashMap<>();

        // Sort the entries based on the exponents in descending order
        terms.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByKey().reversed())
                .forEachOrdered(entry -> sortedTerms.put(entry.getKey(), entry.getValue()));

        // Update the terms map with the sorted entries
        terms = sortedTerms;
    }

    public int degree() {
        if (terms.isEmpty()) {
            return 0; // If polynomial has no terms, degree is 0
        }

        // Initialize the maximum degree
        int maxDegree = 0;

        // Iterate through all terms to find the maximum degree
        for (int exponent : terms.keySet()) {
            if (exponent > maxDegree) {
                maxDegree = exponent;
            }
        }

        return maxDegree;
    }


}
