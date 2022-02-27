package org.example.Janken;

import java.util.Random;

public class Computer {
    public RockPaperScissors.Move getMove() {
        RockPaperScissors.Move[] moves = RockPaperScissors.Move.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];
    }
}