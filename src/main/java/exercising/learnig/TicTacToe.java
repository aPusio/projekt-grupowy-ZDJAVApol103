package exercising.learnig;

import exercising.learnig.arraysCreating.Paair;
import exercising.learnig.boardUpdating.CreatingAnArrayOfSpaces;
import exercising.learnig.boardUpdating.WrittingToAnArray;
import exercising.learnig.factoring.ReadingTheGame;
import exercising.learnig.methoding.Comment;
import exercising.learnig.methoding.DeclaringVariables;
import exercising.learnig.methoding.Methods;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {

        //-----------------------deklaracja zmiennych --------------------------------------------------------
        Random random = new Random();
        DeclaringVariables declaringVariables = new DeclaringVariables();
        char[][] board = CreatingAnArrayOfSpaces.AnArrayOfSpaces(new char[3][3]);
        //-------------------wybór opcji wczytaj stan gry / rozpocznij nową grę ------------------------------
       declaringVariables.setOption(Methods.SelectAnOption(Comment.GameStateOptions()));
        //-------------------wybór stanu gry -----------------------------------------------------------------
        if (Objects.equals(declaringVariables.getOption(), "o")) {
            System.out.println(ReadingTheGame.StatesOfTheGame());
            declaringVariables.setState(Methods.SelectAnItem(Comment.GameStateSelection()));
            for(Paair paair: ReadingTheGame.ReadTheStateOfTheGame(declaringVariables.getState())){
                WrittingToAnArray.MapState(paair, board);}
            CreatingAnArrayOfSpaces.GameBoard(board);
        //-------------------wybór etapu gry -----------------------------------------------------------------
            declaringVariables.setSelect(Methods.SelectAnOption(Comment.SelectAStageOfTheGame()));
            if (Objects.equals(declaringVariables.getSelect(), "o")){
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
        declaringVariables.setFirstPlayer(Methods.SelectAnOption(Comment.PlayerChoice()));
        // -------------------wybierz, który gracz rozpoczyna ------------------------------------------------
        declaringVariables.setStartingPlayer(Methods.SelectAnOption(Comment.ThePlayerStartsTheGame()));
        // -------------------początek partii gry ------------------------------------------------------------
        do {
        // -------------------wykonanie ruchu - wybór gracza wykonujący ruch----------------------------------
            if (Objects.equals(declaringVariables.getFirstPlayer(), "x")) {
                declaringVariables.setSecondPlayer("o");
            } else declaringVariables.setSecondPlayer("x");
        //--------------------gracz wykonuje ruch ------------------------------------------------------------
                do {
                    if (Objects.equals(declaringVariables.getStartingPlayer(), declaringVariables.getFirstPlayer())){
                        declaringVariables.setFieldNumber(Methods.SelectAnItem(Comment.FieldSelection()));
                    } else {
                        declaringVariables.setFieldNumber(random.nextInt(9) + 1);}
                }
                while ((Methods.CheckedLists(declaringVariables.getFieldNumber(), declaringVariables.getListOfBusyFields())) &&
                        declaringVariables.getFieldNumber() < 10 && declaringVariables.getFieldNumber() > 0);

        //--------------------zapisywanie nowego ruchu --------------------------------------------------------
            declaringVariables.getPlayerMoveList().add(new Paair(declaringVariables.getStartingPlayer().charAt(0), declaringVariables.getFieldNumber()));
            declaringVariables.getListOfBusyFields().add(declaringVariables.getFieldNumber());
        //--------------------aktualizacja stanu gry ----------------------------------------------------------
            for(Paair paair: declaringVariables.getPlayerMoveList()){
                WrittingToAnArray.MapState(paair, board);
            }
        //--------------------drukowanie stanu gry na tablicy -------------------------------------------------
            CreatingAnArrayOfSpaces.GameBoard(board);
            System.out.println(declaringVariables.getListOfBusyFields());
        //--------------------sprawdzenie warunków kończących grę ---------------------------------------------
            if (Methods.EndGame1(declaringVariables.getPlayerMoveList())){
                break;
            }
        //--------------------wybór nowego ruchu lub koniec gry -----------------------------------------------
            declaringVariables.setTurn(Methods.SelectAnOption(Comment.FurtherMove()));
        //--------------------zamiana gracza wykonującego ruch ------------------------------------------------
            if ((Objects.equals(declaringVariables.getTurn(), "o")) &&
                    Objects.equals(declaringVariables.getStartingPlayer(), declaringVariables.getFirstPlayer())) {
                declaringVariables.setStartingPlayer(declaringVariables.getSecondPlayer());
            } else{
                declaringVariables.setStartingPlayer(declaringVariables.getFirstPlayer());
                }
        //--------------------koniec gry ----------------------------------------------------------------------
        } while (!Objects.equals(declaringVariables.getTurn(), "x"));
        Comment.WinPlayer(declaringVariables.getPlayerMoveList());
        //--------------------wybór, czy zapisać grę ----------------------------------------------------------
        declaringVariables.setSave(Methods.SelectAnOption(Comment.WhetherToSaveTheGame()));
        if (Objects.equals(declaringVariables.getSave(),"o")){
            ReadingTheGame.LoadGameState(declaringVariables.getPlayerMoveList());
        } else {
           Scanner scanner = Methods.getScanning();
            scanner.close();
        }
        Comment.GameOver();
    }
    }