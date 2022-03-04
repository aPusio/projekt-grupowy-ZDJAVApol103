package org.example;

import org.example.boardUpdating.CreatingAnArrayOfSpaces;
import org.example.boardUpdating.WrittingToAnArray;
import org.example.arraysCreating.Paair;
import org.example.factoring.ReadingTheGame;
import org.example.methoding.Comment;
import org.example.methoding.Methods;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {

        //-----------------------deklaracja zmiennych --------------------------------------------------------
        List<Paair> listPaair = new ArrayList<>();
        List<Integer> listNumbers = new ArrayList<>();
        Random random = new Random();
        String pl, pl1, pl2, turn, option, save, select;
        char[][] board = CreatingAnArrayOfSpaces.AnArrayOfSpaces(new char[3][3]);
        int fieldNumber, state;
        //-------------------wybór opcji wczytaj stan gry / rozpocznij nową grę ------------------------------
       option = Methods.SelectAnOption(Comment.GameStateOptions());
        //-------------------wybór stanu gry -----------------------------------------------------------------
        if (Objects.equals(option, "o")) {
            System.out.println(ReadingTheGame.StatesOfTheGame());
            state = Methods.SelectAnItem(Comment.GameStateSelection());
            for(Paair paair: ReadingTheGame.ReadTheStateOfTheGame(state)){
                WrittingToAnArray.MapState(paair, board);}
            CreatingAnArrayOfSpaces.GameBoard(board);
        //-------------------wybór etapu gry -----------------------------------------------------------------
              select = Methods.SelectAnOption(Comment.SelectAStageOfTheGame());
            if (Objects.equals(select, "o")){
                board = CreatingAnArrayOfSpaces.AnArrayOfSpaces(new char[3][3]);
            } else {
                Scanner scanner = Methods.getScanning();
                scanner.close();
                Comment.GameOver();
                System.exit(0);
            }
        } else {
            Comment.TheBeginningOfTheGame();
        }
        // -------------------wybór gracza -------------------------------------------------------------------
        pl1 = Methods.SelectAnOption(Comment.PlayerChoice());
        // -------------------wybierz, który gracz rozpoczyna ------------------------------------------------
        pl = Methods.SelectAnOption(Comment.ThePlayerStartsTheGame());
        // -------------------początek partii gry ------------------------------------------------------------
        do {
        // -------------------wykonanie ruchu - wybór gracza wykonujący ruch----------------------------------
            if (Objects.equals(pl1, "x")) {
                pl2 = "o";
            } else pl2 = "x";
        //--------------------gracz wykonuje ruch ------------------------------------------------------------
                do {
                    if (Objects.equals(pl, pl1)){
                        fieldNumber = Methods.SelectAnItem(Comment.FieldSelection());
                    } else {
                        fieldNumber = random.nextInt(9) + 1; }
                }
                while ((Methods.CheckedLists(fieldNumber, listNumbers)) && fieldNumber < 10 && fieldNumber > 0);
        //--------------------zapisywanie nowego ruchu --------------------------------------------------------
            listPaair.add(new Paair(pl.charAt(0), fieldNumber));
            listNumbers.add(fieldNumber);
        //--------------------aktualizacja stanu gry ----------------------------------------------------------
            for(Paair paair: listPaair){
                WrittingToAnArray.MapState(paair, board);
            }
        //--------------------drukowanie stanu gry na tablicy -------------------------------------------------
            CreatingAnArrayOfSpaces.GameBoard(board);
            System.out.println(listNumbers);
        //--------------------sprawdzenie warunków kończących grę ---------------------------------------------
            if (Methods.EndGame1(listPaair)){
                break;
            }
        //--------------------wybór nowego ruchu lub koniec gry -----------------------------------------------
            turn = Methods.SelectAnOption(Comment.FurtherMove());
        //--------------------zamiana gracza wykonującego ruch ------------------------------------------------
                if ((Objects.equals(turn, "o")) && Objects.equals(pl, pl1)) {
                    pl = pl2;
            } else{
                    pl = pl1;
                }
        //--------------------koniec gry ----------------------------------------------------------------------
        } while (!Objects.equals(turn, "x"));
        Comment.WinPlayer(listPaair);
        //--------------------wybór, czy zapisać grę ----------------------------------------------------------
        save = Methods.SelectAnOption(Comment.WhetherToSaveTheGame());
        if (Objects.equals(save,"o")){
             ReadingTheGame.LoadGameState(listPaair);
        } else {
           Scanner scanner = Methods.getScanning();
            scanner.close();
        }
        Comment.GameOver();
    }
    }