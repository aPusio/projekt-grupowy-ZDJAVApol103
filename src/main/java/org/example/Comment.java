package org.example;

import org.example.Service.Paair;
import org.hibernate.SessionFactory;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;

public class Comment {
    public static void WinPlayer(List<Paair> paairState){
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
        if (paairState.stream().anyMatch(haspaair1) && paairState.stream().anyMatch(haspaair2)
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
                paairState.stream().anyMatch(haspaair5) && paairState.stream().anyMatch(haspaair7)){
            System.out.println("Winner is Player 'x'" + LocalDateTime.now() + paairState);
        } else if (paairState.stream().anyMatch(haspaair10) && paairState.stream().anyMatch(haspaair11)
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
                paairState.stream().anyMatch(haspaair14) && paairState.stream().anyMatch(haspaair16)){
            System.out.println("Winner is Player 'o'" + LocalDateTime.now() + paairState);
        } else if (paairState.stream().anyMatch(haspaair1) && paairState.stream().anyMatch(haspaair2) &&
                paairState.stream().anyMatch(haspaair3) && paairState.stream().anyMatch(haspaair4) &&
                paairState.stream().anyMatch(haspaair5) && paairState.stream().anyMatch(haspaair6) &&
                paairState.stream().anyMatch(haspaair7) && paairState.stream().anyMatch(haspaair8) &&
                paairState.stream().anyMatch(haspaair9) && paairState.stream().anyMatch(haspaair10) &&
                paairState.stream().anyMatch(haspaair11) && paairState.stream().anyMatch(haspaair12) &&
                paairState.stream().anyMatch(haspaair13) && paairState.stream().anyMatch(haspaair14) &&
                paairState.stream().anyMatch(haspaair15) && paairState.stream().anyMatch(haspaair16) &&
                paairState.stream().anyMatch(haspaair17) && paairState.stream().anyMatch(haspaair18)) {
            System.out.println("There is no winner" + LocalDateTime.now() + paairState);
        } else if (paairState.stream().anyMatch(haspaair1) || paairState.stream().anyMatch(haspaair2) ||
                    paairState.stream().anyMatch(haspaair3) || paairState.stream().anyMatch(haspaair4) ||
                    paairState.stream().anyMatch(haspaair5) || paairState.stream().anyMatch(haspaair6) ||
                    paairState.stream().anyMatch(haspaair7) || paairState.stream().anyMatch(haspaair8) ||
                    paairState.stream().anyMatch(haspaair9) || paairState.stream().anyMatch(haspaair10) ||
                    paairState.stream().anyMatch(haspaair11) || paairState.stream().anyMatch(haspaair12) ||
                    paairState.stream().anyMatch(haspaair13) || paairState.stream().anyMatch(haspaair14) ||
                    paairState.stream().anyMatch(haspaair15) || paairState.stream().anyMatch(haspaair16) ||
                    paairState.stream().anyMatch(haspaair17) || paairState.stream().anyMatch(haspaair18)){
            System.out.println("Game pending" + LocalDateTime.now() + paairState);
        }
    }
    public static void ThePlayerStartsTheGame(){
        System.out.print("wybierz, który gracz rozpoczyna 'x' lub 'o': ");
    }
    public static void FieldSelection(){
        System.out.printf("1 2 3%n4 5 6%n7 8 9%n");
        System.out.print("wybierz pole od 1 do 9: ");
    }
    public static void FurtherMove(){
        System.out.print("n - next player: e - end game: ");
    }

    public  static void GameBoard(String[][] gameboard, Paair paairState){
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard.length; j++) {
                gameboard[i][j] = " ";
            }
        }
        Methods.State(paairState.getNumber(), String.valueOf(paairState.getStr()), gameboard);
        for (String[] strings : gameboard) {
            for (int j = 0; j < gameboard.length; j++) {
                System.out.printf(" %s%3s%3s ", "|", strings[j], "|");
            }

            System.out.println();
            System.out.print("=============================");
            System.out.println();
        }
    }
    public static void PlayerChoice(){
        System.out.print("wybór gracza: 'o' / 'x'");
    }
}
