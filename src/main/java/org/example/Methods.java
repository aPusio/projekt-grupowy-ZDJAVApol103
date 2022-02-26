package org.example;


import java.util.*;
import java.util.function.Predicate;

public class Methods {

    public static void State(int number, String player, String[][] board) {
        switch (number) {
            case 1 : {
                board[0][0] = player;
                System.out.println(Arrays.deepToString(board));
                break;
            }

            case 2 :{
                board[0][1] = player;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 3 : {
                board[0][2] = player;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 4 : {
                board[1][0] = player;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 5 : {
                board[1][1] = player;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 6 : {
                board[1][2] = player;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 7 : {
                board[2][0] = player;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 8 : {
                board[2][1] = player;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 9 : {
                board[2][2] = player;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            default:
                System.out.println("koniec gry");
            break;
        }
    }
    public static boolean CheckedLists(int fieldNumber, List<Integer> listNumbers){
        Integer IntegerNumber = fieldNumber;
        boolean b = false;
        for (Integer listNumber : listNumbers) {
            b = listNumber.equals(IntegerNumber);
            if (b){
                break;
            }
        }
        return b;
    }
    public static void MapState(Paair paairState, String[][] board){
        switch (paairState.number) {
            case 1 : {
                board[0][0] = paairState.str;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 2 : {
                board[0][1] = paairState.str;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 3 : {
                board[0][2] = paairState.str;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 4 : {
                board[1][0] = paairState.str;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 5 : {
                board[1][1] = paairState.str;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 6 : {
                board[1][2] = paairState.str;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 7 : {
                board[2][0] = paairState.str;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 8 : {
                board[2][1] = paairState.str;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            case 9 : {
                board[2][2] = paairState.str;
                System.out.println(Arrays.deepToString(board));
                break;
            }
            default:
                System.out.println("koniec gry:");
            break;
        }
    }

    public static boolean EndGame(List<Paair> paairState) {
        Predicate<Paair> haspaair1 = namepaair -> namepaair.equals(new Paair("x", 1));
        Predicate<Paair> haspaair2 = namepaair -> namepaair.equals(new Paair("x", 2));
        Predicate<Paair> haspaair3 = namepaair -> namepaair.equals(new Paair("x", 3));
        Predicate<Paair> haspaair4 = namepaair -> namepaair.equals(new Paair("x", 4));
        Predicate<Paair> haspaair5 = namepaair -> namepaair.equals(new Paair("x", 5));
        Predicate<Paair> haspaair6 = namepaair -> namepaair.equals(new Paair("x", 6));
        Predicate<Paair> haspaair7 = namepaair -> namepaair.equals(new Paair("x", 7));
        Predicate<Paair> haspaair8 = namepaair -> namepaair.equals(new Paair("x", 8));
        Predicate<Paair> haspaair9 = namepaair -> namepaair.equals(new Paair("x", 9));
        Predicate<Paair> haspaair10 = namepaair -> namepaair.equals(new Paair("o", 1));
        Predicate<Paair> haspaair11 = namepaair -> namepaair.equals(new Paair("o", 2));
        Predicate<Paair> haspaair12 = namepaair -> namepaair.equals(new Paair("o", 3));
        Predicate<Paair> haspaair13 = namepaair -> namepaair.equals(new Paair("o", 4));
        Predicate<Paair> haspaair14 = namepaair -> namepaair.equals(new Paair("o", 5));
        Predicate<Paair> haspaair15 = namepaair -> namepaair.equals(new Paair("o", 6));
        Predicate<Paair> haspaair16 = namepaair -> namepaair.equals(new Paair("o", 7));
        Predicate<Paair> haspaair17 = namepaair -> namepaair.equals(new Paair("o", 8));
        Predicate<Paair> haspaair18 = namepaair -> namepaair.equals(new Paair("o", 9));
        return paairState.stream().anyMatch(haspaair1) && paairState.stream().anyMatch(haspaair2)
                && paairState.stream().anyMatch(haspaair3) || paairState.stream().anyMatch(haspaair4)
                && paairState.stream().anyMatch(haspaair5) && paairState.stream().anyMatch(haspaair6) ||
                paairState.stream().anyMatch(haspaair7) && paairState.stream().anyMatch(haspaair8) &&
                        paairState.stream().anyMatch(haspaair9) || paairState.stream().anyMatch(haspaair1) &&
                paairState.stream().anyMatch(haspaair4) && paairState.stream().anyMatch(haspaair7) ||
                paairState.stream().anyMatch(haspaair2) && paairState.stream().anyMatch(haspaair5)
                        && paairState.stream().anyMatch(haspaair8) || paairState.stream().anyMatch(haspaair3) &&
                paairState.stream().anyMatch(haspaair6) && paairState.stream().anyMatch(haspaair9) ||
                paairState.stream().anyMatch(haspaair1) && paairState.stream().anyMatch(haspaair5)
                && paairState.stream().anyMatch(haspaair9) || paairState.stream().anyMatch(haspaair3) &&
                paairState.stream().anyMatch(haspaair5) && paairState.stream().anyMatch(haspaair7) ||
                paairState.stream().anyMatch(haspaair10) && paairState.stream().anyMatch(haspaair11)
                        && paairState.stream().anyMatch(haspaair12) || paairState.stream().anyMatch(haspaair13)
                && paairState.stream().anyMatch(haspaair14) && paairState.stream().anyMatch(haspaair15) ||
                paairState.stream().anyMatch(haspaair16) && paairState.stream().anyMatch(haspaair17) &&
                        paairState.stream().anyMatch(haspaair18) || paairState.stream().anyMatch(haspaair10) &&
                paairState.stream().anyMatch(haspaair13) && paairState.stream().anyMatch(haspaair16) ||
                paairState.stream().anyMatch(haspaair11) && paairState.stream().anyMatch(haspaair14)
                        && paairState.stream().anyMatch(haspaair17) || paairState.stream().anyMatch(haspaair12) &&
                paairState.stream().anyMatch(haspaair15) && paairState.stream().anyMatch(haspaair18) ||
                paairState.stream().anyMatch(haspaair10) && paairState.stream().anyMatch(haspaair14)
                        && paairState.stream().anyMatch(haspaair18) || paairState.stream().anyMatch(haspaair12) &&
                paairState.stream().anyMatch(haspaair14) && paairState.stream().anyMatch(haspaair16) ||
                paairState.stream().anyMatch(haspaair1) && paairState.stream().anyMatch(haspaair2) &&
                        paairState.stream().anyMatch(haspaair3) && paairState.stream().anyMatch(haspaair4) &&
                        paairState.stream().anyMatch(haspaair5) && paairState.stream().anyMatch(haspaair6) &&
                        paairState.stream().anyMatch(haspaair7) && paairState.stream().anyMatch(haspaair8) &&
                        paairState.stream().anyMatch(haspaair9) && paairState.stream().anyMatch(haspaair10) &&
                        paairState.stream().anyMatch(haspaair11) && paairState.stream().anyMatch(haspaair12) &&
                        paairState.stream().anyMatch(haspaair13) && paairState.stream().anyMatch(haspaair14) &&
                        paairState.stream().anyMatch(haspaair15) && paairState.stream().anyMatch(haspaair16) &&
                        paairState.stream().anyMatch(haspaair17) && paairState.stream().anyMatch(haspaair18);
    }
    }
