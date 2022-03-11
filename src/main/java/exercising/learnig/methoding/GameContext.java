package exercising.learnig.methoding;

import exercising.learnig.arraysCreating.Paair;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GameContext {
   private List<Paair> playerMoveList = new ArrayList<>();
   private List<Integer> listOfBusyFields = new ArrayList<>();
   private String startingPlayer, firstPlayer, secondPlayer, turn, option, save, select;
   private int fieldNumber, state;

}
