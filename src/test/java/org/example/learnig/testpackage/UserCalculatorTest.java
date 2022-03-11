package org.example.learnig.testpackage;

import org.example.testpackage.IoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserCalculatorTest {
// spy to antypatern
//    private Scanner scanner = Mockito.spy(Scanner.class);
//mock sie nie uda bo scanner jest final
//    private Scanner scanner = Mockito.mock(Scanner.class);

    private final IoService ioService = Mockito.mock(IoService.class);
    private final org.example.testpackage.UserCalculator userCalculator = new org.example.testpackage.UserCalculator(ioService);

    @Test
    public void adding2and5shouldReturn7MockingOrederExample(){

        //when
        Mockito.when(ioService.getNextInt(Mockito.anyString()))
                .thenReturn(2)
                .thenReturn(5);
        Integer addition = userCalculator.addition();

        //then
        assertEquals(7,addition);
    }

    @Test
    public void adding2and5shouldReturn7MockingParameterValue(){
        //when
        Mockito.when(ioService.getNextInt(Mockito.eq("PODAJ A")))
                .thenReturn(2);
        Mockito.when(ioService.getNextInt(Mockito.eq("PODAJ B")))
                .thenReturn(5);

        Integer addition = userCalculator.addition();
        //then
        assertEquals(7,addition);
    }


}