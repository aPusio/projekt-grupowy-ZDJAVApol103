package org.example;

public class RockPaperScissors {
    private User user = new User();
    private Computer computer = new Computer();
    private int userScore = 0;
    private int computerScore = 0;
    private int numberOfGames = 0;
    private int numberOfRound = 0;
    private int roundWins = 0;
    private int roundLost = 0;

    enum Move {
        ROCK, PAPER, SCISSORS, WATER, FIRE, AIR, SPONGE;

        public int compareMoves(Move otherMove) {
            if (this == otherMove)
                return 0;
            switch (this) {
                case ROCK:
                    return (otherMove == SCISSORS || otherMove == FIRE || otherMove == SPONGE ? 1 : -1);
                case PAPER:
                    return (otherMove == ROCK || otherMove == WATER || otherMove == AIR ? 1 : -1);
                case SCISSORS:
                    return (otherMove == PAPER || otherMove == SPONGE || otherMove == AIR ? 1 : -1);
                case WATER:
                    return (otherMove == ROCK || otherMove == FIRE || otherMove == SCISSORS ? 1 : -1);
                case FIRE:
                    return (otherMove == SCISSORS || otherMove == PAPER || otherMove == SPONGE ? 1 : -1);
                case AIR:
                    return (otherMove == WATER || otherMove == ROCK || otherMove == FIRE ? 1 : -1);
                case SPONGE:
                    return (otherMove == PAPER || otherMove == AIR || otherMove == WATER ? 1 : -1);
            }
            return 0;
        }
    }

    public void startGame() {
        System.out.println("WELCOME IN ROCK, PAPER, SCISSORS ADVANCED VERSION!");

        while (userScore <= 2 && computerScore <= 2){
            Move userMove = user.getMove();
            Move computerMove = computer.getMove();
            System.out.println("\nYou played " + userMove + ".");
            System.out.println("Computer played " + computerMove + ".\n");

            int compareMoves = userMove.compareMoves(computerMove);
            switch (compareMoves) {
                case 0:
                    System.out.println("Draw!\n");
                    break;
                case 1:
                    System.out.println(userMove + " beats " + computerMove + ". You won!\n");
                    userScore++;
                    break;
                case -1:
                    System.out.println(computerMove + " beats " + userMove + ". You lost.\n");
                    computerScore++;
                    break;
            }
            numberOfGames++;
        }
        printActualGameStats();
        actualRoundStats();
        clearStats();

        if (user.playAgain()) {
            System.out.println();
            startGame();
        } else {
            endGame();
        }
    }
    private void printActualGameStats() {
        int wins = userScore;
        int losses = computerScore;
        int draws = numberOfGames - userScore - computerScore;

        System.out.println("WINS = " + wins);
        System.out.println("LOSSES = " + losses);
        System.out.println("DRAWS = " + draws);
        System.out.println("GAME PLAYED = " + numberOfGames + "\n");

        if (wins > losses){
            System.out.println("!!! CONGRATULATIONS !!! YOU WIN THIS ROUND !!!\n");
        }
        else if (wins == losses){
            System.out.println("YOU TIED\n");
        }
        else {
            System.out.println("SORRY :( YOU LOST THIS ROUND\n");
        }
    }
    private void actualRoundStats(){
        numberOfRound++;
        if (userScore > computerScore){
            roundWins++; }
        else {
            roundLost++;
        }
    }
    private void clearStats(){
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
    }
    private void endGame() {
        if (roundWins > roundLost){
            System.out.println("\n!!! YOU ARE A WINNER !!!");
        }
        else {
            System.out.println("\n:( YOUR ARE A LOSER");
        }
        System.out.println("\nROUNDS = " + numberOfRound);
        System.out.println("WON ROUNDS = " + roundWins);
        System.out.println("LOST ROUNDS = " + roundLost);
        System.out.println("\nTHE END\nTHANKS FOR THE GAME ");
    }
}