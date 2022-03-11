package exercising.learnig;

import exercising.learnig.arraysCreating.Paair;
import exercising.learnig.boardUpdating.GameBoard;
import exercising.learnig.factoring.SaveTheGameDAO;
import exercising.learnig.methoding.Comment;
import exercising.learnig.methoding.GameContext;
import exercising.learnig.methoding.Methods;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {

        //-----------------------deklaracja zmiennych --------------------------------------------------------
        Random random = new Random();
        GameContext gameContext = new GameContext();
        GameBoard gameBoard = new GameBoard();
        //-------------------wybór opcji wczytaj stan gry / rozpocznij nową grę ------------------------------
       gameContext.setOption(Methods.SelectAnOption(Comment.GameStateOptions()));
        //-------------------wybór stanu gry -----------------------------------------------------------------
        if (Objects.equals(gameContext.getOption(), "o")) {
            System.out.println(SaveTheGameDAO.StatesOfTheGame());
            gameContext.setState(Methods.SelectAnItem(Comment.GameStateSelection()));
            for(Paair paair: SaveTheGameDAO.ReadTheStateOfTheGame(gameContext.getState())){
                GameBoard.MapState(paair, gameBoard.getGameBoard());}
            GameBoard.Board(gameBoard.getGameBoard());
        //-------------------wybór etapu gry -----------------------------------------------------------------
            gameContext.setSelect(Methods.SelectAnOption(Comment.SelectAStageOfTheGame()));
            if (Objects.equals(gameContext.getSelect(), "o")){
                gameBoard = new GameBoard();
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
        gameContext.setFirstPlayer(Methods.SelectAnOption(Comment.PlayerChoice()));
        // -------------------wybierz, który gracz rozpoczyna ------------------------------------------------
        gameContext.setStartingPlayer(Methods.SelectAnOption(Comment.ThePlayerStartsTheGame()));
        // -------------------początek partii gry ------------------------------------------------------------
        do {
        // -------------------wykonanie ruchu - wybór gracza wykonujący ruch----------------------------------
            if (Objects.equals(gameContext.getFirstPlayer(), "x")) {
                gameContext.setSecondPlayer("o");
            } else gameContext.setSecondPlayer("x");
        //--------------------gracz wykonuje ruch ------------------------------------------------------------
                do {
                    if (Objects.equals(gameContext.getStartingPlayer(), gameContext.getFirstPlayer())){
                        gameContext.setFieldNumber(Methods.SelectAnItem(Comment.FieldSelection()));
                    } else {
                        gameContext.setFieldNumber(random.nextInt(9) + 1);}
                }
                while (Methods.CheckedList(gameContext.getFieldNumber(), gameContext.getListOfBusyFields()));

        //--------------------zapisywanie nowego ruchu --------------------------------------------------------
            gameContext.getPlayerMoveList().add(new Paair(gameContext.getStartingPlayer().charAt(0), gameContext.getFieldNumber()));
            gameContext.getListOfBusyFields().add(gameContext.getFieldNumber());
        //--------------------aktualizacja stanu gry ----------------------------------------------------------
            for(Paair paair: gameContext.getPlayerMoveList()){
                GameBoard.MapState(paair, gameBoard.getGameBoard());
            }
        //--------------------drukowanie stanu gry na tablicy -------------------------------------------------
            GameBoard.Board(gameBoard.getGameBoard());
            System.out.println(gameContext.getListOfBusyFields());
        //--------------------sprawdzenie warunków kończących grę ---------------------------------------------
            if (Methods.EndGame(gameContext.getPlayerMoveList())){
                break;
            }
        //--------------------wybór nowego ruchu lub koniec gry -----------------------------------------------
            gameContext.setTurn(Methods.SelectAnOption(Comment.FurtherMove()));
        //--------------------zamiana gracza wykonującego ruch ------------------------------------------------
            if ((Objects.equals(gameContext.getTurn(), "o")) &&
                    Objects.equals(gameContext.getStartingPlayer(), gameContext.getFirstPlayer())) {
                gameContext.setStartingPlayer(gameContext.getSecondPlayer());
            } else{
                gameContext.setStartingPlayer(gameContext.getFirstPlayer());
                }
        //--------------------koniec gry ----------------------------------------------------------------------
        } while (!Objects.equals(gameContext.getTurn(), "x"));
        Comment.WinPlayer(gameContext.getPlayerMoveList());
        //--------------------wybór, czy zapisać grę ----------------------------------------------------------
        gameContext.setSave(Methods.SelectAnOption(Comment.WhetherToSaveTheGame()));
        if (Objects.equals(gameContext.getSave(),"o")){
            SaveTheGameDAO.LoadGameState(gameContext.getPlayerMoveList());
        } else {
           Scanner scanner = Methods.getScanning();
            scanner.close();
        }
        Comment.GameOver();
    }
    }