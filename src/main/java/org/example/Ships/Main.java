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


            System.out.println("Please choose the option:");
            System.out.println("1. Start new game");
            System.out.println("2. Continue last game");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                Board player1Board = new Board();
                Board player2Board = new Board();
                Players player1 = new Players("Player 1", player1Board);
                Players player2 = new Players("Player 2", player2Board);

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
                        player1Board.addShip(xStart, yStart, xEnd, yEnd, shipSize);
                        if (!(player1Board.addShip(xStart, yStart, xEnd, yEnd, shipSize))) {
                            System.out.println("position out of range or in collision with another ship");

                        }
                    }
                }
            }
        }
    }





