package org.example.model;

import java.util.*;

public class Operations {
    // Method for adding two polynomials
    public static Polynomials Addition(Polynomials poly1, Polynomials poly2) {
        Polynomials result = new Polynomials();

        // Iterate through poly1 terms and add to result
        for (Map.Entry<Integer, Integer> entry : poly1.terms.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            result.addTerm(exponent, coefficient);
        }

        // Iterate through poly2 terms and add to result
        for (Map.Entry<Integer, Integer> entry : poly2.terms.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            int existingCoefficient = result.getCoefficient(exponent);
            if (existingCoefficient != 0) {
                result.addTerm(exponent, existingCoefficient + coefficient);
            } else {
                result.addTerm(exponent, coefficient);
            }
        }

        // Remove terms with zero coefficients
        return removeTermsZero(result);
    }

    // Method for subtracting two polynomials
    public static Polynomials Subtraction(Polynomials poly1, Polynomials poly2) {
        Polynomials result = new Polynomials();

        // Iterate through poly1 terms and add to result
        for (Map.Entry<Integer, Integer> entry : poly1.terms.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            result.addTerm(exponent, coefficient);
        }

        // Iterate through poly2 terms and subtract from result
        for (Map.Entry<Integer, Integer> entry : poly2.terms.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            int existingCoefficient = result.getCoefficient(exponent);
            result.addTerm(exponent, existingCoefficient - coefficient);
        }

        // Remove terms with zero coefficients
        return removeTermsZero(result);
    }


    // Method for multiplying two polynomials
    public static Polynomials Multiplication(Polynomials poly1, Polynomials poly2) {
        Polynomials result = new Polynomials();

        // Iterate through poly1 terms
        for (Map.Entry<Integer, Integer> entry1 : poly1.terms.entrySet()) {
            int exponent1 = entry1.getKey();
            int coefficient1 = entry1.getValue();
            // Iterate through poly2 terms
            for (Map.Entry<Integer, Integer> entry2 : poly2.terms.entrySet()) {
                int exponent2 = entry2.getKey();
                int coefficient2 = entry2.getValue();
                int exponentAddition = exponent1 + exponent2;
                int coefficientMultiplication = coefficient1 * coefficient2;

                // Check if the exponent already exists in the result
                if (result.terms.containsKey(exponentAddition)) {
                    // If it does, add the coefficients
                    int existingCoefficient = result.terms.get(exponentAddition);
                    int newCoefficient = existingCoefficient + coefficientMultiplication;
                    result.addTerm(exponentAddition, newCoefficient);
                } else {
                    // If it doesn't, simply add the new term
                    result.addTerm(exponentAddition, coefficientMultiplication);
                }
            }
        }

        return result;
    }

    // Method for computing the derivative of a polynomial
    public static Polynomials Derivation(Polynomials poly1) {
        Polynomials result = new Polynomials();

        // Iterate through poly1 terms
        for (Map.Entry<Integer, Integer> entry : poly1.terms.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            // Only consider terms with exponent greater than 0 for the derivative
            if (exponent > 0) {
                int exponentSubtraction = exponent - 1;
                int coefficientMultiplication = coefficient * exponent;

                // Check if the exponent already exists in the result
                if (result.terms.containsKey(exponentSubtraction)) {
                    // If it does, add the new coefficient
                    int existingCoefficient = result.terms.get(exponentSubtraction);
                    int newCoefficient = existingCoefficient + coefficientMultiplication;
                    result.addTerm(exponentSubtraction, newCoefficient);
                } else {
                    // If it doesn't, simply add the new term
                    result.addTerm(exponentSubtraction, coefficientMultiplication);
                }
            }
        }

        return result;
    }

    //Computes the integration of a polynomial and returns the result as a formatted string.
    public static String Integration(Polynomials poly1) {
        // StringBuilder to store the integrated polynomial
        StringBuilder result = new StringBuilder();

        // Get the exponents of the polynomial and sort them in descending order
        List<Integer> exponents = new ArrayList<>(poly1.terms.keySet());
        exponents.sort(Collections.reverseOrder());

        // Iterate through each term in the polynomial
        for (int exponent : exponents) {
            // Get the coefficient of the current term
            int coefficient = poly1.terms.get(exponent);

            // Calculate the new exponent after integration
            int newExponent = exponent + 1;

            // Calculate the new coefficient after integration
            double newCoefficient = (double) coefficient / newExponent;

            // Append the term to the result if the new coefficient is not zero
            if (newCoefficient != 0) {
                // Add the appropriate sign if needed
                if (!result.isEmpty()) {
                    if (newCoefficient > 0) {
                        result.append(" + ");
                    } else {
                        result.append(" - ");
                        // Make the coefficient positive for display
                        newCoefficient = -newCoefficient;
                    }
                }

                // Format the term based on the new exponent
                if (newExponent == 0) {
                    // For constant term (x^0), only append the coefficient
                    result.append(String.format("%.2f", newCoefficient).replace(".00", ""));
                } else if (newExponent == 1) {
                    // For linear term (x^1), format as "x" or "-x"
                    result.append(newCoefficient == 1 ? "x" : (newCoefficient == -1 ? "-x" : String.format("%.2f", newCoefficient).replace(".00", "") + "x"));
                } else {
                    // For other exponents, format as "x^exponent"
                    result.append(newCoefficient == 1 ? "x^" + newExponent : (newCoefficient == -1 ? "-x^" + newExponent : String.format("%.2f", newCoefficient).replace(".00", "") + "x^" + newExponent));
                }
            }
        }

        // Add the constant of integration "C" at the end
        result.append(" + C");

        // Convert the StringBuilder to a string and return
        return result.toString();
    }


    public static String Division(Polynomials dividend, Polynomials divisor) {
        Polynomials quotient = new Polynomials();  // Initialize the quotient

        // Check if divisor is not zero
        if (divisor.terms.isEmpty()) {
            return "Divisor is 0";
        }

        // Check if dividend and divisor are the same
        if (dividend.equals(divisor)) {
            return "Q: 1, R: 0";
        }

        // Check if dividend and divisor are the same
        if (dividend.degree() == divisor.degree() && dividend.terms.entrySet().size() == 1 && divisor.terms.entrySet().size() == 1) {
            return "Q: " + dividend.getCoefficient(1) + "/" + divisor.getCoefficient(1) + ", R: 0";
        }

        // Create a copy of the dividend for manipulation
        Polynomials remainder = new Polynomials(dividend);

        // Arrange dividend and divisor in decreasing order of degrees
        remainder.orderByDegree();
        divisor.orderByDegree();

        // Perform division until degree of remainder is less than divisor
        while (remainder.degree() >= divisor.degree()) {
            // Get the leading terms of dividend and divisor
            int dividendDegree = remainder.degree();
            int divisorDegree = divisor.degree();

            int coefficientDividend = remainder.getCoefficient(dividendDegree);
            int coefficientDivisor = divisor.getCoefficient(divisorDegree);

            // Check for division by 0
            if (coefficientDivisor == 0) {
                return "Divisor is 0!";
            }

            // Compute the quotient for the current division step
            int degreeDifference = dividendDegree - divisorDegree;
            int quotientCoefficient = coefficientDividend / coefficientDivisor;

            // Add this term to the quotient
            quotient.addTerm(degreeDifference, quotientCoefficient);

            // Multiply the divisor with the computed quotient
            Polynomials termProduct = new Polynomials();
            termProduct.addTerm(degreeDifference, quotientCoefficient);
            Polynomials product = Multiplication(divisor, termProduct);

            // Subtract the product from the current remainder to get the new remainder
            remainder = Subtraction(remainder, product);
        }

        // Format the quotient and remainder strings
        String quotientString = quotient.getPolynomialString();
        String remainderString = remainder.getPolynomialString();

        // Check if both quotient and remainder are zero
        if (quotientString.isEmpty()) {
            quotientString = "0";
        }
        if (remainderString.isEmpty()) {
            remainderString = "0";
        }

        // Return the result as a single string
        return "Q: " + quotientString + ", R: " + remainderString;
    }


    // Helper method to remove terms with zero coefficients
    private static Polynomials removeTermsZero(Polynomials result) {
        // Create a set to store exponents with zero coefficients
        Set<Integer> zeroCoefficients = new HashSet<>();

        // Iterate through the terms of the result polynomial
        for (Map.Entry<Integer, Integer> entry : result.terms.entrySet()) {
            // If the coefficient of a term is zero, add its exponent to the set
            if (entry.getValue() == 0) {
                zeroCoefficients.add(entry.getKey());
            }
        }

        // Remove terms with zero coefficients from the result polynomial
        for (int exponent : zeroCoefficients) {
            result.terms.remove(exponent);
        }
        return result;
    }
}
