package org.example.Janken;

public class RockPaperScissors {
    private User user = new User();
    private Computer computer = new Computer();
    private int userScore = 0;
    private int computerScore = 0;
    private int numberOfGames = 0;

    public enum Move {
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

        Move userMove = user.getMove();
        Move computerMove = computer.getMove();
        System.out.println("\nYou played " + userMove + ".");
        System.out.println("Computer played " + computerMove + ".\n");

        int compareMoves = userMove.compareMoves(computerMove);
        switch (compareMoves) {
            case 0:
                System.out.println("Draw!");
                break;
            case 1:
                System.out.println(userMove + " beats " + computerMove + ". You won!");
                userScore++;
                break;
            case -1:
                System.out.println(computerMove + " beats " + userMove + ". You lost.");
                computerScore++;
                break;
        }
        numberOfGames++;

        if (user.playAgain()) {
            System.out.println();
            startGame();
        } else {
            printGameStats();
        }
    }
    private void printGameStats() {
        int wins = userScore;
        int losses = computerScore;
        int draws = numberOfGames - userScore - computerScore;

        System.out.println("WINS = " + wins);
        System.out.println("LOSSES = " + losses);
        System.out.println("DRAWS = " + draws);
        System.out.println("GAME PLAYED = " + numberOfGames);
    }
}