package exercising.learnig;

import org.example.arraysCreating.Paair;
import org.example.boardUpdating.CreatingAnArrayOfSpaces;
import org.example.boardUpdating.WrittingToAnArray;
import org.example.factoring.ReadingTheGame;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] str = CreatingAnArrayOfSpaces.AnArrayOfSpaces(new char[3][3]);

        Scanner scanner = new Scanner(System.in);
        System.out.println(ReadingTheGame.StatesOfTheGame());
        System.out.print("podaj stan: ");
        int st = scanner.nextInt();
        for(Paair paair: ReadingTheGame.ReadTheStateOfTheGame(st)){
            WrittingToAnArray.MapState(paair, str);}
        CreatingAnArrayOfSpaces.GameBoard(str);

    }
}
