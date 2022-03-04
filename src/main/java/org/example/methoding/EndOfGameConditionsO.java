package org.example.methoding;

import org.example.arraysCreating.Paair;

import java.util.List;

public class EndOfGameConditionsO {

    public static boolean condition1(List<Paair> paairState){
        return paairState.contains(new Paair('o', 1)) &&
                paairState.contains(new Paair('o', 2)) &&
                paairState.contains(new Paair('o', 3));
    }
    public static boolean condition2(List<Paair> paairState){
        return paairState.contains(new Paair('o', 4)) &&
                paairState.contains(new Paair('o', 5)) &&
                paairState.contains(new Paair('o', 6));
    }
    public static boolean condition3(List<Paair> paairState){
        return paairState.contains(new Paair('o', 7)) &&
                paairState.contains(new Paair('o', 8)) &&
                paairState.contains(new Paair('o', 9));
    }
    public static boolean condition4(List<Paair> paairState){
        return paairState.contains(new Paair('o', 1)) &&
                paairState.contains(new Paair('o', 4)) &&
                paairState.contains(new Paair('o', 7));
    }
    public static boolean condition5(List<Paair> paairState){
        return paairState.contains(new Paair('o', 2)) &&
                paairState.contains(new Paair('o', 5)) &&
                paairState.contains(new Paair('o', 8));
    }
    public static boolean condition6(List<Paair> paairState){
        return paairState.contains(new Paair('o', 3)) &&
                paairState.contains(new Paair('o', 6)) &&
                paairState.contains(new Paair('o', 9));
    }
    public static boolean condition7(List<Paair> paairState){
        return paairState.contains(new Paair('o', 1)) &&
                paairState.contains(new Paair('o', 5)) &&
                paairState.contains(new Paair('o', 9));
    }
    public static boolean condition8(List<Paair> paairState){
        return paairState.contains(new Paair('o', 3)) &&
                paairState.contains(new Paair('o', 5)) &&
                paairState.contains(new Paair('o', 7));
    }
}
