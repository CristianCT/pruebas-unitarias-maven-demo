package co.com.sofka.app.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicCalculator {
    private static final Logger logger = LoggerFactory.getLogger(BasicCalculator.class);

    public Long sum(Long number1, Long number2){
        logger.info("Summing {} + {}", number1, number2);
        return number1 + number2;
    }

    public Long rest(Long number1, Long number2){
        logger.info("Substracting {} - {}", number1, number2);
        return number1 - number2;
    }

    public Long mult(Long number1, Long number2){
        logger.info("Multiplying {} - {}", number1, number2);
        return number1 * number2;
    }

    public Long div(Long number1, Long number2){
        if (number2 == 0){
            logger.error("Error con los datos a operar");
            throw new IllegalArgumentException("La divicion entre cero (0), no es posible");
        }
        logger.info("Dividing {} - {}", number1, number2);
        return number1 / number2;
    }
}
