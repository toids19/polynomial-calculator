import org.example.model.Operations;
import org.example.model.Polynomials;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {

    @Test
    public void testAddition() {

        // Test addition with positive coefficients
        Polynomials poly1 = new Polynomials();
        poly1.addTerm(3, 3);
        poly1.addTerm(2, 2);
        poly1.addTerm(0, 7);

        Polynomials poly2 = new Polynomials();
        poly2.addTerm(1, 2);
        poly2.addTerm(0, 1);

        Polynomials expectedResult = new Polynomials();
        expectedResult.addTerm(3, 3);
        expectedResult.addTerm(2, 2);
        expectedResult.addTerm(1, 2);
        expectedResult.addTerm(0, 8);

        Polynomials result = Operations.Addition(poly1, poly2);

        assertEquals(expectedResult.getPolynomialString(), result.getPolynomialString());


        // Test addition with negative coefficients
        Polynomials poly3 = new Polynomials();
        poly3.addTerm(2, -4);
        poly3.addTerm(1, -3);
        poly3.addTerm(0, -5);

        Polynomials poly4 = new Polynomials();
        poly4.addTerm(2, -2);
        poly4.addTerm(1, -1);
        poly4.addTerm(0, -7);

        Polynomials expectedResult2 = new Polynomials();
        expectedResult2.addTerm(2, -6);
        expectedResult2.addTerm(1, -4);
        expectedResult2.addTerm(0, -12);

        Polynomials result2 = Operations.Addition(poly3, poly4);

        assertEquals(expectedResult2.getPolynomialString(), result2.getPolynomialString());


        // Test addition with null coefficients
        Polynomials poly5 = new Polynomials();
        poly5.addTerm(3, 0);
        poly5.addTerm(2, 0);
        poly5.addTerm(1, 0);

        Polynomials poly6 = new Polynomials();
        poly6.addTerm(2, 1);
        poly6.addTerm(1, 0);
        poly6.addTerm(0, 0);

        Polynomials expectedResult3 = new Polynomials();
        expectedResult3.addTerm(3, 0);
        expectedResult3.addTerm(2, 1);
        expectedResult3.addTerm(1, 0);

        Polynomials result3 = Operations.Addition(poly5, poly6);

        assertEquals(expectedResult3.getPolynomialString(), result3.getPolynomialString());


        // Test addition with mixed coefficients
        Polynomials poly7 = new Polynomials();
        poly7.addTerm(3, 3);
        poly7.addTerm(2, 0);
        poly7.addTerm(1, -2);
        poly7.addTerm(0, 7);

        Polynomials poly8 = new Polynomials();
        poly8.addTerm(2, -2);
        poly8.addTerm(1, 3);
        poly8.addTerm(0, -1);

        Polynomials expectedResult4 = new Polynomials();
        expectedResult4.addTerm(3, 3);
        expectedResult4.addTerm(2, -2);
        expectedResult4.addTerm(1, 1);
        expectedResult4.addTerm(0, 6);

        Polynomials result4 = Operations.Addition(poly7, poly8);

        assertEquals(expectedResult4.getPolynomialString(), result4.getPolynomialString());
    }


    @Test
    public void testSubtraction() {
        // Test subtraction with positive coefficients
        Polynomials poly1 = new Polynomials();
        poly1.addTerm(3, 3);
        poly1.addTerm(2, 2);
        poly1.addTerm(0, 7);

        Polynomials poly2 = new Polynomials();
        poly2.addTerm(1, 2);
        poly2.addTerm(0, 1);

        Polynomials expectedResult = new Polynomials();
        expectedResult.addTerm(3, 3);
        expectedResult.addTerm(2, 2);
        expectedResult.addTerm(1, -2);
        expectedResult.addTerm(0, 6);

        Polynomials result = Operations.Subtraction(poly1, poly2);

        assertEquals(expectedResult.getPolynomialString(), result.getPolynomialString());


        // Test subtraction with negative coefficients
        Polynomials poly3 = new Polynomials();
        poly3.addTerm(2, -4);
        poly3.addTerm(1, -3);
        poly3.addTerm(0, -5);

        Polynomials poly4 = new Polynomials();
        poly4.addTerm(2, -2);
        poly4.addTerm(1, -1);
        poly4.addTerm(0, -7);

        Polynomials expectedResult2 = new Polynomials();
        expectedResult2.addTerm(2, -2);
        expectedResult2.addTerm(1, -2);
        expectedResult2.addTerm(0, 2);

        Polynomials result2 = Operations.Subtraction(poly3, poly4);

        assertEquals(expectedResult2.getPolynomialString(), result2.getPolynomialString());


        // Test subtraction with null coefficients
        Polynomials poly5 = new Polynomials();
        poly5.addTerm(3, 0);
        poly5.addTerm(2, 0);
        poly5.addTerm(1, 0);

        Polynomials poly6 = new Polynomials();
        poly6.addTerm(2, 1);
        poly6.addTerm(1, 0);
        poly6.addTerm(0, 0);

        Polynomials expectedResult3 = new Polynomials();
        expectedResult3.addTerm(3, 0);
        expectedResult3.addTerm(2, -1);
        expectedResult3.addTerm(1, 0);

        Polynomials result3 = Operations.Subtraction(poly5, poly6);

        assertEquals(expectedResult3.getPolynomialString(), result3.getPolynomialString());


        // Test subtraction with mixed coefficients
        Polynomials poly7 = new Polynomials();
        poly7.addTerm(3, 3);
        poly7.addTerm(2, 0);
        poly7.addTerm(1, -2);
        poly7.addTerm(0, 7);

        Polynomials poly8 = new Polynomials();
        poly8.addTerm(2, -2);
        poly8.addTerm(1, 3);
        poly8.addTerm(0, -1);

        Polynomials expectedResult4 = new Polynomials();
        expectedResult4.addTerm(3, 3);
        expectedResult4.addTerm(2, 2);
        expectedResult4.addTerm(1, -5);
        expectedResult4.addTerm(0, 8);

        Polynomials result4 = Operations.Subtraction(poly7, poly8);

        assertEquals(expectedResult4.getPolynomialString(), result4.getPolynomialString());
    }


    @Test
    public void testMultiplication() {
        Polynomials poly1 = new Polynomials();
        poly1.addTerm(3, 3);
        poly1.addTerm(2, 2);
        poly1.addTerm(0, 7);

        Polynomials poly2 = new Polynomials();
        poly2.addTerm(1, 2);
        poly2.addTerm(0, 1);

        Polynomials expectedResult = new Polynomials();
        expectedResult.addTerm(4, 6);
        expectedResult.addTerm(3, 7);
        expectedResult.addTerm(2, 2);
        expectedResult.addTerm(1, 14);
        expectedResult.addTerm(0, 7);

        Polynomials result = Operations.Multiplication(poly1, poly2);

        assertEquals(expectedResult.getPolynomialString(), result.getPolynomialString());


        // Test multiplication with null coefficient
        Polynomials poly3 = new Polynomials();
        poly3.addTerm(3, 3);
        poly3.addTerm(2, 2);
        poly3.addTerm(0, 0);

        Polynomials poly4 = new Polynomials();
        poly4.addTerm(1, 2);
        poly4.addTerm(0, 1);

        Polynomials expectedResult2 = new Polynomials();
        expectedResult2.addTerm(4, 6);
        expectedResult2.addTerm(3, 7);
        expectedResult2.addTerm(2, 2);
        expectedResult2.addTerm(1, 0);
        expectedResult2.addTerm(0, 0);

        Polynomials result2 = Operations.Multiplication(poly3, poly4);

        assertEquals(expectedResult2.getPolynomialString(), result2.getPolynomialString());


        // Test multiplication with negative coefficients
        Polynomials poly5 = new Polynomials();
        poly5.addTerm(3, -3);
        poly5.addTerm(2, -2);
        poly5.addTerm(1, -7);

        Polynomials poly6 = new Polynomials();
        poly6.addTerm(1, -2);
        poly6.addTerm(0, -1);

        Polynomials expectedResult3 = new Polynomials();
        expectedResult3.addTerm(4, 6);
        expectedResult3.addTerm(3, 7);
        expectedResult3.addTerm(2, 16);
        expectedResult3.addTerm(1, 7);

        Polynomials result3 = Operations.Multiplication(poly5, poly6);

        assertEquals(expectedResult3.getPolynomialString(), result3.getPolynomialString());


        // Test multiplication with mixed coefficients
        Polynomials poly7 = new Polynomials();
        poly7.addTerm(3, 3);
        poly7.addTerm(2, 0);
        poly7.addTerm(1, -2);
        poly7.addTerm(0, 7);

        Polynomials poly8 = new Polynomials();
        poly8.addTerm(2, -2);
        poly8.addTerm(1, 3);
        poly8.addTerm(0, -1);

        Polynomials expectedResult4 = new Polynomials();
        expectedResult4.addTerm(5, -6);
        expectedResult4.addTerm(4, 9);
        expectedResult4.addTerm(3, 1);
        expectedResult4.addTerm(2, -20);
        expectedResult4.addTerm(1, 23);
        expectedResult4.addTerm(0, -7);

        Polynomials result4 = Operations.Multiplication(poly7, poly8);

        assertEquals(expectedResult4.getPolynomialString(), result4.getPolynomialString());
    }


    @Test
    public void testDerivation() {
        // Test derivation with positive coefficients
        Polynomials poly1 = new Polynomials();
        poly1.addTerm(3, 3);
        poly1.addTerm(2, 2);
        poly1.addTerm(0, 7);

        Polynomials expectedResult = new Polynomials();
        expectedResult.addTerm(2, 9);
        expectedResult.addTerm(1, 4);
        expectedResult.addTerm(0, 0);

        Polynomials result = Operations.Derivation(poly1);

        assertEquals(expectedResult.getPolynomialString(), result.getPolynomialString());


        // Test derivation with negative coefficients
        Polynomials poly2 = new Polynomials();
        poly2.addTerm(2, -4);
        poly2.addTerm(1, -3);
        poly2.addTerm(0, -5);

        Polynomials expectedResult2 = new Polynomials();
        expectedResult2.addTerm(1, -8);
        expectedResult2.addTerm(0, -3);

        Polynomials result2 = Operations.Derivation(poly2);

        assertEquals(expectedResult2.getPolynomialString(), result2.getPolynomialString());


        // Test derivation with null coefficients
        Polynomials poly3 = new Polynomials();
        poly3.addTerm(3, 0);
        poly3.addTerm(2, 0);
        poly3.addTerm(1, 0);

        Polynomials expectedResult3 = new Polynomials();
        expectedResult3.addTerm(2, 0);
        expectedResult3.addTerm(1, 0);
        expectedResult3.addTerm(0, 0);

        Polynomials result3 = Operations.Derivation(poly3);

        assertEquals(expectedResult3.getPolynomialString(), result3.getPolynomialString());


        // Test derivation with mixed coefficients
        Polynomials poly4 = new Polynomials();
        poly4.addTerm(3, -3);
        poly4.addTerm(2, 0);
        poly4.addTerm(1, 2);
        poly4.addTerm(0, -7);

        Polynomials expectedResult4 = new Polynomials();
        expectedResult4.addTerm(2, -9);
        expectedResult4.addTerm(0, 2);

        Polynomials result4 = Operations.Derivation(poly4);

        assertEquals(expectedResult4.getPolynomialString(), result4.getPolynomialString());
    }


    @Test
    public void testIntegration() {
        // Test integration with positive coefficients
        Polynomials poly1 = new Polynomials();
        poly1.addTerm(3, 3);
        poly1.addTerm(2, 2);
        poly1.addTerm(0, 7);

        String expectedResult = "0.75x^4 + 0.67x^3 + 7x + C";

        String result = Operations.Integration(poly1);

        assertEquals(expectedResult, result);


        // Test integration with negative coefficients
        Polynomials poly2 = new Polynomials();
        poly2.addTerm(2, -4);
        poly2.addTerm(1, -3);
        poly2.addTerm(0, -5);

        String expectedResult2 = "-1.33x^3 - 1.50x^2 - 5x + C";

        String result2 = Operations.Integration(poly2);

        assertEquals(expectedResult2, result2);


        // Test integration with null coefficients
        Polynomials poly3 = new Polynomials();
        poly3.addTerm(3, 0);
        poly3.addTerm(2, 0);
        poly3.addTerm(1, 0);

        String expectedResult3 = " + C";

        String result3 = Operations.Integration(poly3);

        assertEquals(expectedResult3, result3);


        // Test integration with mixed coefficients
        Polynomials poly4 = new Polynomials();
        poly4.addTerm(3, -3);
        poly4.addTerm(2, 0);
        poly4.addTerm(1, 2);
        poly4.addTerm(0, -7);

        String expectedResult4 = "-0.75x^4 + x^2 - 7x + C";

        String result4 = Operations.Integration(poly4);

        assertEquals(expectedResult4, result4);
    }

        @Test
        public void testDivision() {
            // Test division with positive coefficients
            Polynomials dividend1 = new Polynomials();
            dividend1.addTerm(3, 1);
            dividend1.addTerm(2, -2);
            dividend1.addTerm(1, 6);
            dividend1.addTerm(0, -5);

            Polynomials divisor1 = new Polynomials();
            divisor1.addTerm(2, 1);
            divisor1.addTerm(0, -1);

            String result1 = Operations.Division(dividend1, divisor1);
            String expected1 = "Q: x-2, R: 7x-7";
            assertEquals(expected1, result1);

            // Test division with negative coefficients
            Polynomials dividend2 = new Polynomials();
            dividend2.addTerm(2, 5);
            dividend2.addTerm(1, 3);
            dividend2.addTerm(0, -2);

            Polynomials divisor2 = new Polynomials();
            divisor2.addTerm(1, 1);
            divisor2.addTerm(0, 1);

            String result2 = Operations.Division(dividend2, divisor2);
            String expected2 = "Q: 5x-2, R: 0";
            assertEquals(expected2, result2);

            // Test division with mixed coefficients
            Polynomials dividend3 = new Polynomials();
            dividend3.addTerm(5, -3);
            dividend3.addTerm(3, 9);
            dividend3.addTerm(1, 2);
            dividend3.addTerm(0, 4);

            Polynomials divisor3 = new Polynomials();
            divisor3.addTerm(2, -1);
            divisor3.addTerm(0, 2);

            String result3 = Operations.Division(dividend3, divisor3);
            String expected3 = "Q: 3x^3-3x, R: 8x+4";
            assertEquals(expected3, result3);

            // Test division with zero coefficients for the dividend
            Polynomials dividend4 = new Polynomials();
            dividend4.addTerm(3, 0);
            dividend4.addTerm(2, 0);
            dividend4.addTerm(1, 0);
            dividend4.addTerm(0, 0);

            Polynomials divisor4 = new Polynomials();
            divisor4.addTerm(2, -1);
            divisor4.addTerm(0, 2);

            String result4 = Operations.Division(dividend4, divisor4);
            String expected4 = "Q: 0, R: 0";
            assertEquals(expected4, result4);


            // Test division with zero coefficients for the divisor
            Polynomials dividend5 = new Polynomials();
            dividend5.addTerm(3, 1);
            dividend5.addTerm(2, 1);
            dividend5.addTerm(1, 1);
            dividend5.addTerm(0, 1);

            Polynomials divisor5 = new Polynomials();
            divisor5.addTerm(2, 0);
            divisor5.addTerm(0, 0);

            String result5 = Operations.Division(dividend5, divisor5);
            String expected5 = "Divisor is 0!";
            assertEquals(expected5, result5);
        }
    }








