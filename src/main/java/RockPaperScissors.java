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
                if (playerMove.equals("1") || playerMove.equals("2") || playerMove.equals("3") ||
                        playerMove.equals("4") || playerMove.equals("5") || playerMove.equals("6") ||
                                playerMove.equals("7")){
                                    break;
                }
                System.out.println(playerMove + " is not a valid move.");
            }

            System.out.println("Computer played: " + computerMove);

            if (playerMove.equals(computerMove)) {
                System.out.println("The game was a tie!");
            }
            else if (playerMove.equals("1")) {
                if (computerMove.equals("2")) {
                    System.out.println("Rock drowns in water. You lose!");}
                else if(computerMove.equals("3")) {
                    System.out.println("Air erodes rock. You lose!");}
                else if (computerMove.equals("4")) {
                    System.out.println("Paper covers rock. You lose!");}
                else if (computerMove.equals("5")) {
                    System.out.println("Rock destroys sponge. You win!");}
                else if (computerMove.equals("6")) {
                    System.out.println("Rock crushes scissors. You win!");}
                else if (computerMove.equals("7")) {
                    System.out.println("Rock suffocates fire. You win!");}
            }

            else if (playerMove.equals("2")) {
                if (computerMove.equals("1")) {
                    System.out.println("Rock drowns in water. You win!");}
                else if(computerMove.equals("3")) {
                    System.out.println("Water evaporates into air. You lose!");}
                else if (computerMove.equals("4")) {
                    System.out.println("Paper floats on the water. You lose!");}
                else if (computerMove.equals("5")) {
                    System.out.println("Sponge absorbs water. You lose!");}
                else if (computerMove.equals("6")) {
                    System.out.println("Scissors sinks into the water. You win!");}
                else if (computerMove.equals("7")) {
                    System.out.println("Water extinguish th fire. You win!");}
            }

            else if (playerMove.equals("3")) {
                if (computerMove.equals("1")) {
                    System.out.println("Air erodes rock. You win!");}
                else if(computerMove.equals("2")) {
                    System.out.println("Water evaporates into aie. You win!");}
                else if (computerMove.equals("4")) {
                    System.out.println("Paper fly into the air. You lose!");}
                else if (computerMove.equals("5")) {
                    System.out.println("Sponge turns into Spongebob. You lose!");}
                else if (computerMove.equals("6")) {
                    System.out.println("Scissors cuts the air. You lose!");}
                else if (computerMove.equals("7")) {
                    System.out.println("Air quenches the fire. You win!");}
            }
            else if (playerMove.equals("4")) {
                if (computerMove.equals("1")) {
                    System.out.println("Paper covers rock. You win!");
                } else if (computerMove.equals("2")) {
                    System.out.println("Paper floats on the water. You win!");
                } else if (computerMove.equals("3")) {
                    System.out.println("Paper fly into the air. You win!");
                } else if (computerMove.equals("5")) {
                    System.out.println("Sponge turns into Spongebob. You lose!");
                } else if (computerMove.equals("6")) {
                    System.out.println("Scissors cuts paper. You lose!");
                } else if (computerMove.equals("7")) {
                    System.out.println("Fire burns paper. You lose!");
                }
            }
            else if (playerMove.equals("5")) {
                if (computerMove.equals("1")) {
                    System.out.println("Rock destroys sponge. You lose!");
                } else if (computerMove.equals("2")) {
                    System.out.println("Sponge absorbs water. You win!");
                } else if (computerMove.equals("3")) {
                    System.out.println("Sponge turns into Spongebob. You win!");
                } else if (computerMove.equals("4")) {
                    System.out.println("Sponge turns into Spongebob. You win!");
                } else if (computerMove.equals("6")) {
                    System.out.println("Scissors cuts sponge. You lose!");
                } else if (computerMove.equals("7")) {
                    System.out.println("Fire burns sponge. You lose!");
                }
            }
            else if (playerMove.equals("6")) {
                if (computerMove.equals("1")) {
                    System.out.println("Rock crushes scissors. You lose!");
                } else if (computerMove.equals("2")) {
                    System.out.println("Scissors sinks into the water. You lose!");
                } else if (computerMove.equals("3")) {
                    System.out.println("Scissors cuts the air. You win!");
                } else if (computerMove.equals("4")) {
                    System.out.println("Scissors cuts paper. You win!");
                } else if (computerMove.equals("5")) {
                    System.out.println("Scissors cuts sponge. You win!");
                } else if (computerMove.equals("7")) {
                    System.out.println("Fire melts scissors. You lose!");
                }
            }
            else if (playerMove.equals("7")) {
                if (computerMove.equals("1")) {
                    System.out.println("Rock suffocates fire. You lose!");
                } else if (computerMove.equals("2")) {
                    System.out.println("Water extinguish th fire. You lose!");
                } else if (computerMove.equals("3")) {
                    System.out.println("Air quenches the fire. You lose!");
                } else if (computerMove.equals("4")) {
                    System.out.println("Fire burns paper. You win!");
                } else if (computerMove.equals("5")) {
                    System.out.println("Fire burns sponge. You win!");
                } else if (computerMove.equals("6")) {
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

