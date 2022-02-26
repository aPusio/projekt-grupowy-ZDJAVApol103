import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            String[] rps = {"rock", "paper", "scissors", "lizard", "spock"};
            String computerMove = rps[new Random().nextInt(rps.length)];
            String playerMove;

            while (true) {
                System.out.println("Make a move from: rock, paper, scissors, lizard or spock");
                playerMove = scan.nextLine();
                if (playerMove.equals("rock") || playerMove.equals("paper") || playerMove.equals("scissors") ||
                        playerMove.equals("lizard") || playerMove.equals("spock")) {
                    break;
                }
                System.out.println(playerMove + " is not a valid move.");
            }

            System.out.println("Computer played: " + computerMove);

            if (playerMove.equals(computerMove)) {
                System.out.println("The game was a tie!");
            } else if (playerMove.equals("rock")) {
                if (computerMove.equals("lizard") || computerMove.equals("scissors")) {
                    System.out.println("You win!");
                } else if (computerMove.equals("spock") || computerMove.equals("paper")) {
                    System.out.println("You lose!");}
            } else if (playerMove.equals("paper")) {
                if (computerMove.equals("rock") || computerMove.equals("spock")) {
                    System.out.println("You win!");
                } else if (computerMove.equals("scissors") || computerMove.equals("lizard")) {
                    System.out.println("You lose!");}
            } else if (playerMove.equals("scissors")) {
                if (computerMove.equals("paper") || computerMove.equals("lizard")) {
                    System.out.println("You win!");
                } else if (computerMove.equals("rock") || computerMove.equals("spock")) {
                    System.out.println("You lose!");}
            } else if (playerMove.equals("lizard")) {
                if (computerMove.equals("spock") || computerMove.equals("paper")) {
                    System.out.println("You win!");
                } else if (computerMove.equals("rock") || computerMove.equals("scissors")) {
                    System.out.println("You lose!");}
            } else if (playerMove.equals("spock")) {
                if (computerMove.equals("rock") || computerMove.equals("scissors")) {
                    System.out.println("You win!");
                } else if (computerMove.equals("lizard") || computerMove.equals("paper")) {
                    System.out.println("You lose!");}
                }


                System.out.println("Play again? (y/n)");
                String playAgain = scan.nextLine();

                if (!playAgain.equals("y")) {
                    break;
                }
            }
            scan.close();
        }
    }