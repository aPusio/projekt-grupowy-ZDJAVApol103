package exercising.learnig.boardUpdating;

import java.util.Arrays;

public class CreatingAnArrayOfSpaces {
    public static char[][] AnArrayOfSpaces(char[][] gameboard){
        for (char[] ch: gameboard) {
            Arrays.fill(ch, ' ');
        }
        return gameboard;
    }
    public static void GameBoard(char[][] gameboard) {
        System.out.println(Arrays.deepToString(gameboard));
        for (char[] strings : gameboard) {
            for (int j = 0; j < gameboard.length; j++) {
                System.out.printf(" %s%3s%3s ", "|", strings[j], "|");
            }
            System.out.println();
            System.out.print("===========================");
            System.out.println();
        }
    }
}
