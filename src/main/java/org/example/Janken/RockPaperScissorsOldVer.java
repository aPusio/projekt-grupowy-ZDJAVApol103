//package RockPaperScissors;
//
//import java.util.*;
//
//public class RockPaperScissors {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        while (true) {
//            List<String> rps = new ArrayList<>();
//            List<String> symbols = List.of("rock", "paper", "scissors", "lizard", "spock");
//            Random random = new Random();
//            String computerMove = rps.get(random.nextInt(rps.size()));
//            String playerMove;
//            HashMap<String, List<String>> rules = new HashMap<>();
//            rules.put("rock",List.of("lizard", "scissors"));
//            rules.put("paper", List.of("rock", "spock"));
//            rules.put("scissors", List.of("paper", "lizard"));
//            rules.put("lizard", List.of("spock", "paper"));
//            rules.put("spock", List.of("rock", "scissors"));
//            ResultMessage win = (symbol) -> {
//                System.out.println("You win!");
//            };
//            while (true) {
//                System.out.println("Make a move from: rock, paper, scissors, lizard or spock");
//                playerMove = scan.nextLine();
//                if (symbols.contains(playerMove)) {
//                    break;
//                }
//                System.out.println(playerMove + " is not a valid move.");
//            }
//
//            System.out.println("Computer played: " + computerMove);
//
//            if (playerMove.equals(computerMove)) {
//                System.out.println("The game is a tie!");
////            } else if (playerMove.equals("rock")) {
////                if (computerMove.equals("lizard") || computerMove.equals("scissors")) {
////                    win.result();
////                } else if (computerMove.equals("spock") || computerMove.equals("paper")) {
////                    loose.result();
////                }
////            } else if (playerMove.equals("paper")) {
////                if (computerMove.equals("rock") || computerMove.equals("spock")) {
////                    win.result();
////                } else if (computerMove.equals("scissors") || computerMove.equals("lizard")) {
////                    loose.result();
////                }
////            } else if (playerMove.equals("scissors")) {
////                if (computerMove.equals("paper") || computerMove.equals("lizard")) {
////                    win.result();
////                } else if (computerMove.equals("rock") || computerMove.equals("spock")) {
////                    loose.result();
////                }
////            } else if (playerMove.equals("lizard")) {
////                if (computerMove.equals("spock") || computerMove.equals("paper")) {
////                    win.result();
////                } else if (computerMove.equals("rock") || computerMove.equals("scissors")) {
////                    loose.result();
////                }
////            } else if (playerMove.equals("spock")) {
////                if (computerMove.equals("rock") || computerMove.equals("scissors")) {
////                    win.result();
////                } else if (computerMove.equals("lizard") || computerMove.equals("paper")) {
////                    loose.result();
////                }
//            }else if(playerMove.compareTo(rules.)){
//            }
////                win.result("rock", "lizard", "scissors");
////                loose.result("rock", "spock", "paper");
////                win.result("paper", "rock", "spock");
////                loose.result("paper", "scissors", "lizard");
////                win.result("scissors", "paper", "lizard");
////                loose.result("scissors", "spock", "rock");
////                win.result("lizard", "spock", "paper");
////                loose.result("lizard", "rock", "scissors");
////                win.result("spock", "rock", "scissors");
////                loose.result("spock", "lizard", "paper");
//
//            }
//                System.out.println("Play again? (y/n)");
//                String playAgain = scan.nextLine();
//
//                if (!playAgain.equals("y")) {
//                    break;
//                }
//            }
//            scan.close();
//        }
//
