package org.example.Game2048.Board;

import org.example.Game2048.EndOfGameException;
import org.example.Game2048.Point.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardGenerator {
    private static final Random RANDOM = new Random();

    public static Board generateNewBoard() {
        Board board = new Board();
        Point point1 = new Point(RANDOM.nextInt(4), RANDOM.nextInt(4), 2);
        Point point2;
        do {
            point2 = new Point(RANDOM.nextInt(4), RANDOM.nextInt(4), 2);
        } while (point1.equals(point2));
        board.setPointList(List.of(point1, point2));
        return board;
    }

    public static Board updateBoard(Board board) {
        List<Point> points = new ArrayList<>(board.getPointList());
        Point newPoint;
        boolean isNewPointEqual;
        if (points.size() < 16) {
            do {
                isNewPointEqual = false;
                newPoint = new Point(RANDOM.nextInt(4), RANDOM.nextInt(4), 2);
                for (Point x : points) {
                    if (newPoint.equals(x)) {
                        isNewPointEqual = true;
                        break;
                    }
                }
            } while (isNewPointEqual);
            points.add(newPoint);
            board.setPointList(points);
            return board;
        } else
            throw new EndOfGameException();
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


