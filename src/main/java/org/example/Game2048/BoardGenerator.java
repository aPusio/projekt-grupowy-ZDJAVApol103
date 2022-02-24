package org.example.Game2048;

import java.util.List;
import java.util.Random;

public class BoardGenerator {

    public static Board generateNewBoard() {
        Random random = new Random();
        Board board = new Board();
        Point point1 = new Point(random.nextInt(3), random.nextInt(3), 2);
        Point point2;
        do {
            point2 = new Point(random.nextInt(3), random.nextInt(3), 2);
        } while (point1.equals(point2));
        board.setPointList(List.of(point1, point2));
        return board;
    }

    public static void printBoard(List<Point> pointList) {
        boolean isFilled;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                isFilled = false;
                for (Point point4 : pointList) {
                    if (point4.getX() == j && point4.getY() == i) {
                        System.out.print(point4.getValue() + " ");
                        isFilled = true;
                    }
                }
                if (!isFilled) {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
