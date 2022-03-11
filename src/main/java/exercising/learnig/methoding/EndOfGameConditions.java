package exercising.learnig.methoding;

import exercising.learnig.arraysCreating.Paair;

import java.util.List;

public class EndOfGameConditions {

  private final char e;

    public EndOfGameConditions(char e) {
        this.e = e;
    }

    public boolean condition1(List<Paair> paairState){
        return paairState.contains(new Paair(e, 1)) &&
                paairState.contains(new Paair(e, 2)) &&
                paairState.contains(new Paair(e, 3));
    }
    public boolean condition2(List<Paair> paairState){
        return paairState.contains(new Paair(e, 4)) &&
                paairState.contains(new Paair(e, 5)) &&
                paairState.contains(new Paair(e, 6));
    }
    public boolean condition3(List<Paair> paairState){
        return paairState.contains(new Paair(e, 7)) &&
                paairState.contains(new Paair(e, 8)) &&
                paairState.contains(new Paair(e, 9));
    }
    public boolean condition4(List<Paair> paairState){
        return paairState.contains(new Paair(e, 1)) &&
                paairState.contains(new Paair(e, 4)) &&
                paairState.contains(new Paair(e, 7));
    }
    public boolean condition5(List<Paair> paairState){
        return paairState.contains(new Paair(e, 2)) &&
                paairState.contains(new Paair(e, 5)) &&
                paairState.contains(new Paair(e, 8));
    }
    public boolean condition6(List<Paair> paairState){
        return paairState.contains(new Paair(e, 3)) &&
                paairState.contains(new Paair(e, 6)) &&
                paairState.contains(new Paair(e, 9));
    }
    public boolean condition7(List<Paair> paairState){
        return paairState.contains(new Paair(e, 1)) &&
                paairState.contains(new Paair(e, 5)) &&
                paairState.contains(new Paair(e, 9));
    }
    public boolean condition8(List<Paair> paairState){
        return paairState.contains(new Paair(e, 3)) &&
                paairState.contains(new Paair(e, 5)) &&
                paairState.contains(new Paair(e, 7));
    }
}
