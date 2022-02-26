//package RockPaperScissors;
//
//import java.util.*;
//
//public class RPS {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        while (true) {
//            List<String> rps = new ArrayList<>();
//            List<String> symbols = List.of("rock", "paper", "scissors", "lizard", "spock");
//            Random random = new Random();
//            String computerMove = rps.get(random.nextInt(rps.size()));
//            String playerMove;
//
//            while (true) {
//                System.out.println("Make a move from: rock, paper, scissors, lizard or spock");
//                playerMove = scan.nextLine();
//                if (symbols.contains(playerMove)) {
//                    break;
//                }
//                System.out.println(playerMove + " is not a valid move.");
//            }
//            // Rules
//            HashMap<String, List<String>> rules = new HashMap<>();
//            rules.put("rock",List.of("lizard", "scissors"));
//            rules.put("paper", List.of("rock", "spock"));
//            rules.put("scissors", List.of("paper", "lizard"));
//            rules.put("lizard", List.of("spock", "paper"));
//            rules.put("spock", List.of("rock", "scissors"));
//        //    List<String> strings = rules.get(playerMove);
//
//        }
//    }
//}