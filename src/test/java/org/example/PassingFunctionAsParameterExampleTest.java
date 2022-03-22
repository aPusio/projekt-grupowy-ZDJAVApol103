package org.example;

import lombok.Builder;
import lombok.Value;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class PassingFunctionAsParameterExampleTest {

    private SampleService sampleService = new SampleService();

    @Test
    public void passingFunctionGetXSShouldMultiplicativeResult(){
        //given
        Point point = Point.builder().x(4).y(5).build();

        //when
        int result = sampleService.multiplyPositionBy2(point::getX);

        //then
        Assertions.assertEquals(8, result);
    }

    @Test
    public void passingFunctionGetYSShouldMultiplicativeResult(){
        //given
        Point point = Point.builder().x(4).y(5).build();

        //when
        int result = sampleService.multiplyPositionBy2(point::getY);

        //then
        Assertions.assertEquals(10, result);
    }

    static class SampleService {
        //here i used supplier because functions getx and gety has no parameters.
        //more info here -> https://www.baeldung.com/java-8-functional-interfaces
        public int multiplyPositionBy2(Supplier<Integer> supplier){
            int multiplier = 2;
            return supplier.get() * multiplier;
        }
    }

    @Value
    @Builder
    static class Point{
        int x;
        int y;
    }
}
