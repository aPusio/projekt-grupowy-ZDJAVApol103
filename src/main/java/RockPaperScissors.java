import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true){
            String[] rps = { "rock", "water", "air", "paper", "sponge", "scissors", "fire"};
            String computerMove = rps[new Random().nextInt(rps.length)];
            String playerMove;

            while(true){
                System.out.println("Make a move from: rock = 1, water = 2, air = 3, paper = 4, " +
                        "sponge = 5, scissors = 6 or fire = 7");
                playerMove = scan.nextLine();
                if (playerMove.equals("1") || (playerMove.equals("2") || (playerMove.equals("3") ||
                        (playerMove.equals("4") || (playerMove.equals("5") || (playerMove.equals("6") ||
                                (playerMove.equals("7")))))))){
                                    break;
                }
            }
        }

    }
}
