package org.example;

import org.example.RockPaperScissors;

import java.util.Scanner;

public class User {
  private Scanner scanner;

   public User() {
      scanner = new Scanner(System.in);
   }
   public RockPaperScissors.Move getMove() {
       System.out.print("Make a choice: Rock (r), Paper (p), Scissors (s), Water (w), " +
               "Fire (f), Air (a) or Sponge (g) ? ");

       String userText = scanner.nextLine();
       userText = userText.toUpperCase();
       char firstLetter = userText.charAt(0);
       if (firstLetter == 'R' || firstLetter == 'P' || firstLetter == 'S'|| firstLetter == 'W' ||
               firstLetter == 'F' || firstLetter == 'A' ||firstLetter == 'G'){
           switch (firstLetter) {
               case 'R':
                   return RockPaperScissors.Move.ROCK;
               case 'P':
                   return RockPaperScissors.Move.PAPER;
               case 'S':
                   return RockPaperScissors.Move.SCISSORS;
               case 'W':
                   return RockPaperScissors.Move.WATER;
               case 'F':
                   return RockPaperScissors.Move.FIRE;
               case 'A':
                   return RockPaperScissors.Move.AIR;
               case 'G':
                   return RockPaperScissors.Move.SPONGE;
           }
       }
       return getMove();
   }
   public boolean playAgain() {
       System.out.print("Do you want to play again? (y/n) ");
       String userText = scanner.nextLine();
       userText = userText.toUpperCase();
       return userText.charAt(0) == 'Y' ;
   }
}