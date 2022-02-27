package org.example.Ships;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();


    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int shipSize = 2;
        int xStart;
        int yStart;
        int xEnd;
        int yEnd;
        Shoot shoot = new Shoot();
        Board player1Board = new Board();
        Board player2Board = new Board();
        Players player1 = new Players("Player 1", player1Board);
        Players player2 = new Players("Player 2", player2Board);
        int tura = 1;

        System.out.println("Please choose the option:");
        System.out.println("1. Start new game");
        System.out.println("2. Continue last game");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
            for (int i = 1; i <= 2; i++) {
                System.out.println("Player " + i + " creation...");
                for (int j = 1; j <= 1; j++) {
                    switch (j) {
                        case 1:
                            shipSize = 2;
                            break;
                        case 2:
                            shipSize = 3;
                            break;
                        case 3:
                            shipSize = 3;
                            break;
                        case 4:
                            shipSize = 4;
                            break;
                        case 5:
                            shipSize = 5;
                            break;
                    }
                    System.out.println("Put X coordinate for start point of ship size: " + shipSize);
                    xStart = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Put Y coordinate for start point of ship size: " + shipSize);
                    yStart = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Put X coordinate for end point of ship size: " + shipSize);
                    xEnd = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Put X coordinate for end point of ship size: " + shipSize);
                    yEnd = scanner.nextInt();
                    scanner.nextLine();
                    if (i == 1) {
                        player1Board.addShip(xStart, yStart, xEnd, yEnd, shipSize);
//                        if (!(player1Board.addShip(xStart, yStart, xEnd, yEnd, shipSize))) {
//                            System.out.println("position out of range or in collision with another ship");
//                        }
                    }
                    if (i == 2) {
                        player2Board.addShip(xStart, yStart, xEnd, yEnd, shipSize);
//                        if (!(player2Board.addShip(xStart, yStart, xEnd, yEnd, shipSize))) {
//                            System.out.println("position out of range or in collision with another ship");
//                        }
                    }

                }
            }
        }
        while (flag) {

            switch (tura) {

                case 1: {
                    System.out.println("Player 1...");
                    Shoot.shoot(player2Board);
                    if(player2Board.getScoreAvaliable()==0){
                        System.out.println("You WIN");
                        flag = false;
                        break;
                    }

                    tura = 2;
                }
                case 2: {
                    System.out.println("Player 2...");
                    Shoot.shoot(player1Board);
                    if(player1Board.getScoreAvaliable()==0){
                        System.out.println("You WIN");
                        flag = false;
                        break;
                    }
                    tura = 1;
                }
            }
        }
    }
}





