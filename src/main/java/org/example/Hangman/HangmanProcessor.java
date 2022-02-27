package org.example.Hangman;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HangmanProcessor {

    public static final int WINNING_SCORE = 1; // debug  :D:D
    public static final int CHANCES = 1; // debug  :D:D
    private SessionFactory sf;
    private Scanner scanner;

    public HangmanProcessor(SessionFactory sessionFactory, Scanner scanner) {
        this.sf = sessionFactory;
        this.scanner = scanner;
    }

    public void menu() {
        boolean loopMenu = true;
        while (loopMenu) {
            switch (scannerPrint(scanner)) {
                case "1":
                    System.out.println("start game");
                    HangmanProcessor hangmanProcessor = new HangmanProcessor(sf,scanner);
                    hangmanProcessor.start(sf);
                    break;
                case "11":
                    System.out.println("Load game");
                    HangmanProcessor hangmanProcessor2 = new HangmanProcessor(sf,scanner);
                    //tu będzie czytanie z bazy
                    hangmanProcessor2.start(sf);
                    break;
                case "2":
                    System.out.println("add single word");
                    String wordToAdd = scanner.next(); //
                    System.out.println(wordToAdd);
                    WordsProcessor wordsProcessor = new WordsProcessor(sf);
                    wordsProcessor.addWord(wordToAdd);
                    break;
                case "3":
                    System.out.println("delete single word");
                    WordsProcessor wp = new WordsProcessor(sf);
                    System.out.println(wp.readEveryWordFromDB());
                    break;
                case "4":
                    System.out.println("edit single word");
                    break;
                case "0":
                    loopMenu = false;
                    break;
                default:
                    System.out.println("wrong option");
            }
        }
    }
    public void start(SessionFactory sessionFactory, String usedLetters){
        printPalyerPick("first");
        Player player1 = new Player.PlayerBuilder(scanner.next()).score(0).build();
        printPalyerPick("second");
        Player player2 = new Player.PlayerBuilder(scanner.next()).score(0).build();

        boolean endGame = false;

        while (!endGame) {
            printScore(player1, player2);
            runRound(player1, scanner, sessionFactory);
            printScore(player1, player2);
            runRound(player2, scanner, sessionFactory);

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

    }

    public void start(SessionFactory sessionFactory) {
        ///
        printPalyerPick("first");
        Player player1 = new Player.PlayerBuilder(scanner.next()).score(0).build();
        printPalyerPick("second");
        Player player2 = new Player.PlayerBuilder(scanner.next()).score(0).build();

        boolean endGame = false;

        while (!endGame) {
            printScore(player1, player2);
            runRound(player1, scanner, sessionFactory);
            printScore(player1, player2);
            runRound(player2, scanner, sessionFactory);

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

    }

    private String charToString(char[] array){
        StringBuilder sb = new StringBuilder();


        return sb.toString();
    }

    private String scannerPrint(Scanner scanner) {
        System.out.println("Pick option" +
                "1. new game" +
                "2. add word" +
                "3. delete word" +
                "4. edit word" +
                "0. exit");
        return scanner.next();
    }

    private void printPalyerPick(String number) {
        if (number.equals("first")) {
            System.out.print("Select first player\n");
        }
        if (number.equals("second")) {
            System.out.print("Select second player\n");
        }
    }

    private void printScore(Player player1, Player player2) {
        System.out.printf("P1 score: %d\n", player1.getScore());
        System.out.printf("P2 score: %d\n", player2.getScore());
    }



    void updateUsedLetters(Long id, String haslo, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            //sprawdź czy istnieje wpis dla HangmanGame
            //jeżeli istnieją to ro update, jeżeli nie isnieją to insert

            Transaction transaction = session.beginTransaction();
            Words words = session.get(Words.class, id);
            words.setWord(haslo);
            session.saveOrUpdate(words);
            //log.info("Updated {}",words);
            transaction.commit();
        }
    }

    public String saveUsedLetter(char c){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        return stringBuilder.toString();
    }

    public void runRound(Player player, Scanner scanner, SessionFactory sessionFactory) {
        player.setChances(CHANCES);
        Set<Character> letters = new HashSet<>();

        WordsProcessor wordsProcessor = new WordsProcessor(sf);
        boolean currentRound = true;

        List<Words> list = wordsProcessor.readEveryWordFromDB();
        String haslo = wordsProcessor.pickOneWordDeleteAfter(list);

        System.out.println(haslo);  // debug  :D:D
        wordsProcessor.setNewWord(haslo);
        wordsProcessor.setNewArray();
        String hashedWord = wordsProcessor.hash(wordsProcessor.getWordToArray());

        while (currentRound) {
            System.out.printf("Grę zaczyna %s,ilość szans: %d, aktualna ilość punktów %d, wybierz literę\n", player.getName(), player.getChances(), player.getScore());
            String s = scanner.next();
            char c = s.charAt(0);

            if (wordsProcessor.check(wordsProcessor.getWordToArray(), c)) {
                hashedWord = wordsProcessor.partialUnhash(wordsProcessor.getWordToArray(), c, hashedWord);
                System.out.println(hashedWord);
            } else {
                player.subtractChance();
                System.out.println(player.getChances());
                System.out.println(hashedWord);
            }

            GallowPrinter.printGallow(player.chancesReversed());
            letters.add(c);
            System.out.println(letters);

            Hangman hangman = new Hangman();
            hangman.setUsedLetters(saveUsedLetter(c));
            hangman.setPlayer1(player);
            //hibernate

            if (player.getChances() == 0) {
                System.out.printf("Przegrana! %s nie odgadł hasła, ilość punktów %d, pozostałe szanse %d\n", player.getName(), player.getScore(), player.getChances());
                currentRound = false;
            }

            if (!wordsProcessor.check(hashedWord.toCharArray(), '#')) {
                player.increseScore();
                System.out.printf("Wygrana! %s odgadł hasło, ilość punktów %d, pozostałe szanse %d\n", player.getName(), player.getScore(), player.getChances());
                currentRound = false;
            }
        }
    }
}
