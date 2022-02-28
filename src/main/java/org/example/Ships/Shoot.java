package org.example.Ships;

import java.util.Scanner;

//Class responsible for shooting opposite player ship
public class Shoot {


    public static void shoot(Board board) {
        int xCoordinate = 0;
        int yCoordinate = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give your shot coordinates:");
        System.out.print("X = ");
        xCoordinate = scanner.nextInt();
        System.out.println();
        System.out.println("Y = ");
        yCoordinate = scanner.nextInt();

        /*
        while (xCoordinate < 0 || xCoordinate >= 9 || yCoordinate < 0 || yCoordinate > 9) {
            System.out.println("Target out of the board. Please provide correct coordinates");
        }*/

        board.addShot(xCoordinate,yCoordinate);

    }
}

