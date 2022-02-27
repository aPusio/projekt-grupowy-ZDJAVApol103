package org.example.Ships;

public class Board {

    private boolean board[][] = new boolean[10][10];

    int scoreAvaliable=0;



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
            scoreAvaliable+=shipLength;
//            ShipsProcessor shipsProcessor = new ShipsProcessor();
//            shipsProcessor.dodaj(shipLength, xStart, xEnd, yStart, yEnd, 0);

            return true;
        }
        return false;
    }

    public boolean addShot(int x, int y) {

        if (!board[y][x]) {
            System.out.println("You missed.");
            return false;
        }else{
            board[y][x] = false;
            System.out.println("HIT!");
            scoreAvaliable = scoreAvaliable-1;
            return true;
        }

    }

    public int getScoreAvaliable(){
        return scoreAvaliable;
    }


}