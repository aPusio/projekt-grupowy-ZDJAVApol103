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
                System.out.println("Make a move from: rock, water, air, paper, sponge, scissors or fire");
                playerMove = scan.nextLine();
                if (playerMove.equals("rock") || playerMove.equals("water") || playerMove.equals("air") ||
                    playerMove.equals("paper") || playerMove.equals("sponge") || playerMove.equals("scissors") ||
                    playerMove.equals("fire")){
                    break;
                }
                System.out.println(playerMove + " is not a valid move.");
            }

            System.out.println("Computer played: " + computerMove);

            if (playerMove.equals(computerMove)) {
                System.out.println("The game was a tie!");
            } else if (playerMove.equals("rock")) {
                if (computerMove.equals("water")) {
                    System.out.println("Rock drowns in water. You lose!");}
                else if(computerMove.equals("air")) {
                    System.out.println("Air erodes rock. You lose!");}
                else if (computerMove.equals("paper")) {
                    System.out.println("Paper covers rock. You lose!");}
                else if (computerMove.equals("sponge")) {
                    System.out.println("Rock destroys sponge. You win!");}
                else if (computerMove.equals("scissors")) {
                    System.out.println("Rock crushes scissors. You win!");}
                else if (computerMove.equals("fire")) {
                    System.out.println("Rock suffocates fire. You win!");}
            } else if (playerMove.equals("water")) {
                if (computerMove.equals("rock")) {
                    System.out.println("Rock drowns in water. You win!");}
                else if(computerMove.equals("air")) {
                    System.out.println("Water evaporates into air. You lose!");}
                else if (computerMove.equals("paper")) {
                    System.out.println("Paper floats on the water. You lose!");}
                else if (computerMove.equals("sponge")) {
                    System.out.println("Sponge absorbs water. You lose!");}
                else if (computerMove.equals("scissors")) {
                    System.out.println("Scissors sinks into the water. You win!");}
                else if (computerMove.equals("fire")) {
                    System.out.println("Water extinguish th fire. You win!");}
            } else if (playerMove.equals("air")) {
                if (computerMove.equals("rock")) {
                    System.out.println("Air erodes rock. You win!");}
                else if(computerMove.equals("water")) {
                    System.out.println("Water evaporates into aie. You win!");}
                else if (computerMove.equals("paper")) {
                    System.out.println("Paper fly into the air. You lose!");}
                else if (computerMove.equals("sponge")) {
                    System.out.println("Sponge turns into Spongebob. You lose!");}
                else if (computerMove.equals("scissors")) {
                    System.out.println("Scissors cuts the air. You lose!");}
                else if (computerMove.equals("fire")) {
                    System.out.println("Air quenches the fire. You win!");}
            } else if (playerMove.equals("paper")) {
                if (computerMove.equals("rock")) {
                    System.out.println("Paper covers rock. You win!");
                } else if (computerMove.equals("water")) {
                    System.out.println("Paper floats on the water. You win!");
                } else if (computerMove.equals("air")) {
                    System.out.println("Paper fly into the air. You win!");
                } else if (computerMove.equals("sponge")) {
                    System.out.println("Sponge turns into Spongebob. You lose!");
                } else if (computerMove.equals("scissors")) {
                    System.out.println("Scissors cuts paper. You lose!");
                } else if (computerMove.equals("fire")) {
                    System.out.println("Fire burns paper. You lose!");
                }
            } else if (playerMove.equals("sponge")) {
                if (computerMove.equals("rock")) {
                    System.out.println("Rock destroys sponge. You lose!");
                } else if (computerMove.equals("water")) {
                    System.out.println("Sponge absorbs water. You win!");
                } else if (computerMove.equals("air")) {
                    System.out.println("Sponge turns into Spongebob. You win!");
                } else if (computerMove.equals("paper")) {
                    System.out.println("Sponge turns into Spongebob. You win!");
                } else if (computerMove.equals("scissors")) {
                    System.out.println("Scissors cuts sponge. You lose!");
                } else if (computerMove.equals("fire")) {
                    System.out.println("Fire burns sponge. You lose!");
                }
            } else if (playerMove.equals("scissors")) {
                if (computerMove.equals("rock")) {
                    System.out.println("Rock crushes scissors. You lose!");
                } else if (computerMove.equals("water")) {
                    System.out.println("Scissors sinks into the water. You lose!");
                } else if (computerMove.equals("air")) {
                    System.out.println("Scissors cuts the air. You win!");
                } else if (computerMove.equals("paper")) {
                    System.out.println("Scissors cuts paper. You win!");
                } else if (computerMove.equals("sponge")) {
                    System.out.println("Scissors cuts sponge. You win!");
                } else if (computerMove.equals("fire")) {
                    System.out.println("Fire melts scissors. You lose!");
                }
            } else if (playerMove.equals("fire")) {
                if (computerMove.equals("rock")) {
                    System.out.println("Rock suffocates fire. You lose!");
                } else if (computerMove.equals("water")) {
                    System.out.println("Water extinguish th fire. You lose!");
                } else if (computerMove.equals("air")) {
                    System.out.println("Air quenches the fire. You lose!");
                } else if (computerMove.equals("paper")) {
                    System.out.println("Fire burns paper. You win!");
                } else if (computerMove.equals("sponge")) {
                    System.out.println("Fire burns sponge. You win!");
                } else if (computerMove.equals("scissors")) {
                    System.out.println("Fire melts scissors. You win!");
                }
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

