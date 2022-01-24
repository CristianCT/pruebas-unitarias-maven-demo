package co.com.sofka.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1+1=2")
    public void sum() {
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        Long result = basicCalculator.sum(number1, number2);

        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    /* TEST DE RESTAS */
    @Test
    @DisplayName("Testing rest: 2-1=1")
    public void rest() {
        Long number1 = 2L;
        Long number2 = 1L;
        Long expectedValue = 1L;

        Long result = basicCalculator.rest(number1, number2);

        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several rests")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "3,    1,   2",
            "5,    2,   3",
            "50,  51, -1",
            "100,  50, 50"
    })
    public void severalRests(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.rest(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    /* TEST DE MULTIPLICACIONES */
    @Test
    @DisplayName("Testing mult: 5*2=10")
    public void mult() {
        Long number1 = 5L;
        Long number2 = 2L;
        Long expectedValue = 10L;

        Long result = basicCalculator.mult(number1, number2);

        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several mults")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "3,    2,   6",
            "4,    4,   16",
            "5,  8, 40",
            "3,  9, 27"
    })
    public void severalMults(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.mult(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    /* TEST DE DIVICIONES */
    @Test
    @DisplayName("Testing rest: 9/3=3")
    public void div() {
        Long number1 = 9L;
        Long number2 = 3L;
        Long expectedValue = 3L;

        Long result = basicCalculator.div(number1, number2);

        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several divs")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "8,    4,   2",
            "25,    5,   5",
            "8,  8, 1",
            "150,  10, 15"
    })
    public void severalDivs(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.div(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Error div")
    public void divError() {
        Long number1 = 7L;
        Long number2 = 0L;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Long result = basicCalculator.div(number1, number2);
        });

        assertEquals("La divicion entre cero (0), no es posible", exception.getMessage());
    }
}