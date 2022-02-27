package org.example.game2048;

import java.util.ArrayList;
import java.util.List;

public class MainStart {

    public static void main(String[] args) {

        List<Point> secondBoard = new ArrayList<>();
        secondBoard.add(new Point(0,0,9));
        secondBoard.add(new Point(1,0,2));
        secondBoard.add(new Point(3,0,2));
        secondBoard.add(new Point(1,1,4));
        secondBoard.add(new Point(2,1,4));
        secondBoard.add(new Point(1,2,2));
        secondBoard.add(new Point(0,3,2));
        secondBoard.add(new Point(2,3,2));


        BoardGenerator.printBoard(secondBoard);
        System.out.println("--------- Down:");
        Movement.moveDown(secondBoard);
        BoardGenerator.printBoard(secondBoard);
        System.out.println("--------- Right:");
        Movement.moveRight(secondBoard);
        BoardGenerator.printBoard(secondBoard);
        System.out.println("--------- Up:");
        Movement.moveUp(secondBoard);
        BoardGenerator.printBoard(secondBoard);
        System.out.println("--------- Left:");
        Movement.moveLeft(secondBoard);
        BoardGenerator.printBoard(secondBoard);
        System.out.println("--------- Up:");
        Movement.moveUp(secondBoard);
        BoardGenerator.printBoard(secondBoard);
        System.out.println("--------- Down:");
        Movement.moveDown(secondBoard);
        BoardGenerator.printBoard(secondBoard);
        System.out.println("--------- Right:");
        Movement.moveRight(secondBoard);
        BoardGenerator.printBoard(secondBoard);
        System.out.println("--------- Down:");
        Movement.moveDown(secondBoard);
        BoardGenerator.printBoard(secondBoard);

    }
}