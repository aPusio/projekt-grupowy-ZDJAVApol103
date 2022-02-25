package org.example.Hangman;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Hangman {

    public static final int WINNING_SCORE = 3;

    public void menu(){

    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        printPalyerPick("first");
        Player player1 = new Player.PlayerBuilder(scanner.next()).score(0).build();
        printPalyerPick("second");
        Player player2 = new Player.PlayerBuilder(scanner.next()).score(0).build();

        boolean endGame = false;

        while (!endGame) {
            printScore(player1, player2);
            runRound(player1, scanner);
            printScore(player1, player2);
            runRound(player2, scanner);

            if (player1.getScore() == WINNING_SCORE || player2.getScore() == WINNING_SCORE) {
                endGame = true;
                if (player1.getScore() == player2.getScore()) {
                    System.out.println("draw");
                } else if (player1.getScore() == WINNING_SCORE) {
                    System.out.println("P1 wins");
                } else {
                    System.out.println("P2 wins");
                }
            }
        }
        scanner.close();
    }

    private void printPalyerPick(String number) {
        if(number.equals("first")){
            System.out.print("Select first player\n");
        }
        if(number.equals("second")){
            System.out.print("Select second player\n");
        }
    }

    private void printScore(Player player1, Player player2) {
        System.out.printf("P1 score: %d\n", player1.getScore());
        System.out.printf("P2 score: %d\n", player2.getScore());
    }

    public void runRound(Player player, Scanner scanner) {
        player.setChances(7);
        Set<Character> letters = new HashSet<>();

        WordsProcessor wordProccessor = new WordsProcessor();
        boolean currentRound = true;
        wordProccessor.setNewWord();
        wordProccessor.setNewArray();
        String hashedWord = wordProccessor.hash(wordProccessor.getWordToArray());

        while (currentRound) {
            System.out.printf("Grę zaczyna %s,ilość szans: %d, aktuana ilość punktów %d, wybierz literę\n", player.getName(), player.getChances(), player.getScore());
            String s = scanner.next();
            char c = s.charAt(0);

            if (wordProccessor.check(wordProccessor.getWordToArray(), c)) {
                hashedWord = wordProccessor.partialUnhash(wordProccessor.getWordToArray(), c, hashedWord);
                System.out.println(hashedWord);
            } else {
                player.subtractChance();
                System.out.println(player.getChances());
                System.out.println(hashedWord);
            }

            GallowPrinter.printGallow(player.chancesReversed());
            letters.add(c);
            System.out.println(letters);

            if (player.getChances() == 0) {
                System.out.printf("Przegrana! %s nie odgadł hasła, ilość punktów %d, pozostałe szane %d\n", player.getName(), player.getScore(), player.getChances());
                currentRound = false;
            }

            if (!wordProccessor.check(hashedWord.toCharArray(), '#')) {
                player.increseScore();
                System.out.printf("Wygrana! %s odgadł hasło, ilość punktów %d, pozostałe szane %d\n", player.getName(), player.getScore(), player.getChances());
                currentRound = false;
            }
        }

    }


}
