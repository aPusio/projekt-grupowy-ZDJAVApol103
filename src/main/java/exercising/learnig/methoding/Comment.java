package exercising.learnig.methoding;

import exercising.learnig.arraysCreating.Paair;

import java.time.LocalDateTime;
import java.util.List;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class Comment {

    public static void WinPlayer(List<Paair> paairState){
        EndOfGameConditions endOfGameConditionsO = new EndOfGameConditions('o');
        EndOfGameConditions endOfGameConditionsX = new EndOfGameConditions('x');
        if (endOfGameConditionsX.condition1(paairState) || endOfGameConditionsX.condition2(paairState) ||
                endOfGameConditionsX.condition3(paairState) || endOfGameConditionsX.condition4(paairState) ||
                endOfGameConditionsX.condition5(paairState) || endOfGameConditionsX.condition6(paairState) ||
                endOfGameConditionsX.condition7(paairState) || endOfGameConditionsX.condition8(paairState))
        { System.out.println("Winner is Player 'x' " + LocalDateTime.now().format(ISO_LOCAL_DATE_TIME) + " " + paairState); }
        else if (endOfGameConditionsO.condition1(paairState) || endOfGameConditionsO.condition2(paairState) ||
                endOfGameConditionsO.condition3(paairState) || endOfGameConditionsO.condition4(paairState) ||
                endOfGameConditionsO.condition5(paairState) || endOfGameConditionsO.condition6(paairState) ||
                endOfGameConditionsO.condition7(paairState) || endOfGameConditionsO.condition8(paairState))
        { System.out.println("Winner is Player 'o' " + LocalDateTime.now().format(ISO_LOCAL_DATE_TIME) + " " + paairState); }
        else if (paairState.size() == 9)
        { System.out.println("There is no winner " + LocalDateTime.now().format(ISO_LOCAL_DATE_TIME) + " "  + paairState); }
        else if (paairState.size() < 9){
            System.out.println("Game pending " + LocalDateTime.now().format(ISO_LOCAL_DATE_TIME) + " "  + paairState);
        }
    }
    public static String ThePlayerStartsTheGame(){
        return "wybierz, który gracz rozpoczyna: 'o' / 'x': ";
    }

    public static String FieldSelection(){
        return "1 2 3\n4 5 6\n7 8 9\nwybierz pole: od 1 do 9: ";
    }

    public static String FurtherMove(){
        return "o - next player: x - end game: ";
    }

    public static String  PlayerChoice() { return "wybierz gracza: 'o' / 'x': "; }

    public static String GameStateOptions() { return "wybierz opcję: o- wczytaj grę x- zagraj: "; }

    public static String GameStateSelection() { return "wybierz stan gry: "; }

    public static void TheBeginningOfTheGame() { System.out.println("początek gry"); }

    public static String WhetherToSaveTheGame() { return "wybierz opcję: o- zapisz grę x- nie zapisuj: "; }

    public static String SelectAStageOfTheGame() { return "wybierz opcję: o- graj dalej x- kończ grę: "; }

    public static void GameOver() { System.out.println("GAME OVER"); }
}
