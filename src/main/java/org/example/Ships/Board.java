package org.example.Ships;

public class Board {

    private boolean board[][] = new boolean[10][10];

    public boolean[][] getBoard() {
        return board;
    }



    public boolean addShip(int xStart, int yStart, int xEnd, int yEnd, int shipLength) {

        if ((xStart >= 0 && xStart < 10) && (xEnd >= 0 && xEnd < 10) && (yStart >= 0 && yStart < 10) && (yEnd >= 0 && yEnd < 10)) {
            if (yStart == yEnd) {
                for (int i = xStart; i <= xEnd; i++) {
                    board[yStart][i] = true;
                }
            } else {
                if (xStart == xEnd) {
                    for (int i = yStart; i <= yEnd; i++) {
                        board[i][xStart] = true;
                    }
                }

            }
            return true;

        }
        return false;
    }
}