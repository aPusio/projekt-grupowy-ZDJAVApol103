package org.example.learnig.testpackage;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
//    @DisplayName("TO JEST OPIS TESTU")
    public void adding2and2shouldReturn4() {
        //given
        int a = 2;
        int b = 2;

        //when
        Integer addition = calculator.addition(a, b);

        //then
        assertEquals(4, addition);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 2, 4",
            "5, 1, 6",
    })
    public void parametrizedTest(int a, int b, int expectedResult){
        //when
        Integer result = calculator.addition(a, b);

        //then
        assertEquals(expectedResult, result);
    }

}