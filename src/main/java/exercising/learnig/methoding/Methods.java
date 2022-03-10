package exercising.learnig.methoding;


import exercising.learnig.arraysCreating.Paair;

import java.util.*;
import java.util.function.Predicate;

public class Methods {

    public static boolean CheckedList (int fieldNumber, List<Integer> listNumbers){
        Predicate<Integer> haspaair = namepaair -> namepaair.equals(fieldNumber);
        return listNumbers.stream().anyMatch(haspaair) && fieldNumber < 10 && fieldNumber > 0;
    }
    public static boolean EndGame(List<Paair> paairState) {
        EndOfGameConditions endOfGameConditionsO = new EndOfGameConditions('o');
        EndOfGameConditions endOfGameConditionsX = new EndOfGameConditions('x');
        return endOfGameConditionsX.condition1(paairState) || endOfGameConditionsX.condition2(paairState) ||
                endOfGameConditionsX.condition3(paairState) || endOfGameConditionsX.condition4(paairState) ||
                endOfGameConditionsX.condition5(paairState) || endOfGameConditionsX.condition6(paairState) ||
                endOfGameConditionsX.condition7(paairState) || endOfGameConditionsX.condition8(paairState) ||
                endOfGameConditionsO.condition1(paairState) || endOfGameConditionsO.condition2(paairState) ||
                endOfGameConditionsO.condition3(paairState) || endOfGameConditionsO.condition4(paairState) ||
                endOfGameConditionsO.condition5(paairState) || endOfGameConditionsO.condition6(paairState) ||
                endOfGameConditionsO.condition7(paairState) || endOfGameConditionsO.condition8(paairState) ||
                paairState.size() == 9;
    }

    public static Scanner getScanning(){
        return new Scanner(System.in);
    }

    public static String SelectAnOption(String comment){
        Scanner scanner = Methods.getScanning();
        String option;
        do {
            System.out.print(comment);
            option = scanner.next();
        } while ((!Objects.equals(option, "o")) && (!Objects.equals(option, "x")));
        return option;
    }

    public static int SelectAnItem(String comment){
        Scanner scanner = Methods.getScanning();
        int option;
        System.out.print(comment);
        option = scanner.nextInt();
        return option;
    }
}
