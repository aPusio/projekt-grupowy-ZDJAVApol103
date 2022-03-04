package org.example.Tictactoe;

import org.example.HibernateFactory;
import org.example.Tictactoe.Entity.DaoRoundEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeV1 {
    public static void main(String[] args) {
        WelcomeMenu();
        DaoRoundEntity dao = new DaoRoundEntity();
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        dao.readRoundById(5L, sessionFactory);
    }

    private static char[][] getStartChars(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9) {
        return new char[][]{{c, c2, c3},
                {c4, c5, c6},
                {c7, c8, c9},
        };
    }

    private static boolean isGameFinished(char[][] board) {
        if (hasContesantWon(board,'X')) {
            printBoard(board);
            System.out.println("Player wins! ");
            return true;
        }
        if (hasContesantWon(board,'O')) {
            printBoard(board);
            System.out.println("Computer wins! ");
            return true;
        }

        for (int i = 0; i < board.length; i++){
            for (int j =0; j < board[i].length; j++ ){
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended is a tie!");
        return true;
    }

    private static boolean hasContesantWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true){
            computerMove = rand.nextInt(10);
            if (isValidMove(board,computerMove)) {
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        placeMove(board,Integer.toString(computerMove),'O');
    }

    private static boolean isValidMove(char[][] board, int position){
        switch (position) {
            case 1:
                return board[0][0] == ' ';
            case 2:
                return board[0][1] == ' ';
            case 3:
                return board[0][2] == ' ';
            case 4:
                return board[1][0] == ' ';
            case 5:
                return board[1][1] == ' ';
            case 6:
                return board[1][2] == ' ';
            case 7:
                return board[2][0] == ' ';
            case 8:
                return board[2][1] == ' ';
            case 9:
                return board[2][2] == ' ';
            default:
                return false;
        }
    }
    private static void playerTurn(char[][] board, Scanner scanner) {
        String userInput;
        while(true){
            System.out.println("Where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            if (isValidMove(board, Integer.parseInt(userInput))){
                break;
            } else {
                System.out.println(userInput + " is not valid number");
            }
        }
        placeMove(board, userInput,'X');
    }

    private static void placeMove(char[][] board, String position, char symbol) {
        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println(":( Wrong");
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
    private static void WelcomeMenu(){
        System.out.println("WELCOME TO TIC TAC TOE");

        char[][] boardStart = getStartChars('1', '2', '3', '4', '5', '6', '7', '8', '9');
        printBoard(boardStart);
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };
        System.out.println("What do you have?");
        System.out.println("1-Load Game, 2- New Game");
         String number =scanner.nextLine();
        switch(number){
            case "1": String Load = "Load Game...";
                System.out.println(Load);
            break;
            case "2": String Play = "New Game is ready..";
                System.out.println(Play);
                startPlay(scanner, board);
            break;
            default:
                System.out.println("Spróbuj jeszcze raz");
        }
        //todo
        //opcja wyboru, nowa gra, wczytanie gry

    }

    private static void startPlay(Scanner scanner, char[][] board) {
        DaoRoundEntity dao = new DaoRoundEntity();
        while (true) {
            playerTurn(board, scanner);
            if (isGameFinished(board)){
                break;
            }
            printBoard(board);
            dao.SaveTheGame(board);
            //todo Sprawdzenie czy gracz nie chce wyjść
            computerTurn(board);
            dao.SaveTheGame(board);
            //todo Sprawdzić czy gracz nie chce wyjść
            //todo Zapis do bazy
            printBoard(board);
        }
    }
}

