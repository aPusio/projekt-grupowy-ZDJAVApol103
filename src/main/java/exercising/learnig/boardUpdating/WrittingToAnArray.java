package exercising.learnig.boardUpdating;

import exercising.learnig.arraysCreating.Paair;

public class WrittingToAnArray {
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
