package exercising.learnig.methoding;


import exercising.learnig.arraysCreating.Paair;

import java.util.*;
import java.util.function.Predicate;

public class Methods {

    public static boolean CheckedLists(int fieldNumber, List<Integer> listNumbers){
        Predicate<Integer> haspaair = namepaair -> namepaair.equals(fieldNumber);
        return listNumbers.stream().anyMatch(haspaair);
    }
    public static boolean EndGame1(List<Paair> paairState) {
        return EndOfGameConditionsX.condition1(paairState) || EndOfGameConditionsX.condition2(paairState) ||
                EndOfGameConditionsX.condition3(paairState) || EndOfGameConditionsX.condition4(paairState) ||
                EndOfGameConditionsX.condition5(paairState) || EndOfGameConditionsX.condition6(paairState) ||
                EndOfGameConditionsX.condition7(paairState) || EndOfGameConditionsX.condition8(paairState) ||
                EndOfGameConditionsO.condition1(paairState) || EndOfGameConditionsO.condition2(paairState) ||
                EndOfGameConditionsO.condition3(paairState) || EndOfGameConditionsO.condition4(paairState) ||
                EndOfGameConditionsO.condition5(paairState) || EndOfGameConditionsO.condition6(paairState) ||
                EndOfGameConditionsO.condition7(paairState) || EndOfGameConditionsO.condition8(paairState) ||
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
