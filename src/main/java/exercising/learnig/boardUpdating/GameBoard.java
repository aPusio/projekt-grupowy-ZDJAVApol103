package exercising.learnig.boardUpdating;

import exercising.learnig.arraysCreating.Paair;

import java.util.Arrays;

public class GameBoard {

    private final char[][] gameBoard = GameBoard.AnArrayOfSpaces(new char[3][3]);

    public char[][] getGameBoard() { return gameBoard; }

    public static char[][] AnArrayOfSpaces(char[][] gameBoard){
        for (char[] ch: gameBoard) {
            Arrays.fill(ch, ' ');
        }
        return gameBoard;
    }
    public static void Board(char[][] gameBoard) {
        for (char[] strings : gameBoard) {
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.printf(" %s%3s%3s ", "|", strings[j], "|");
            }
            System.out.println();
            System.out.print("===========================");
            System.out.println();
        }
    }
    public static void MapState(Paair paairState, char[][] board) {
        switch (paairState.getFieldNumber()) {
            case 1: {
                board[0][0] = paairState.getPlayer();
                break;
            }

            case 2: {
                board[0][1] = paairState.getPlayer();
                break;
            }

            case 3: {
                board[0][2] = paairState.getPlayer();
                break;
            }

            case 4: {
                board[1][0] = paairState.getPlayer();
                break;
            }

            case 5: {
                board[1][1] = paairState.getPlayer();
                break;
            }

            case 6: {
                board[1][2] = paairState.getPlayer();
                break;
            }

            case 7: {
                board[2][0] = paairState.getPlayer();
                break;
            }

            case 8: {
                board[2][1] = paairState.getPlayer();
                break;
            }

            case 9: {
                board[2][2] = paairState.getPlayer();
                break;
            }
        }
    }
}
