package exercising.learnig.methoding;

import exercising.learnig.arraysCreating.Paair;

import java.util.ArrayList;
import java.util.List;


public class DeclaringVariables {
    List<Paair> playerMoveList = new ArrayList<>();
    List<Integer> listOfBusyFields = new ArrayList<>();
    String startingPlayer, firstPlayer, secondPlayer, turn, option, save, select;
    int fieldNumber, state;

    public List<Paair> getPlayerMoveList() { return playerMoveList; }

    public List<Integer> getListOfBusyFields() { return listOfBusyFields; }

    public String getStartingPlayer() { return startingPlayer; }

    public void setStartingPlayer(String startingPlayer) { this.startingPlayer = startingPlayer; }

    public String getFirstPlayer() { return firstPlayer; }

    public void setFirstPlayer(String firstPlayer) { this.firstPlayer = firstPlayer; }

    public String getSecondPlayer() { return secondPlayer; }

    public void setSecondPlayer(String secondPlayer) { this.secondPlayer = secondPlayer; }

    public String getTurn() { return turn; }

    public void setTurn(String turn) { this.turn = turn; }

    public String getOption() { return option; }

    public void setOption(String option) { this.option = option; }

    public String getSave() { return save; }

    public void setSave(String save) { this.save = save; }

    public String getSelect() { return select; }

    public void setSelect(String select) { this.select = select; }

    public int getFieldNumber() { return fieldNumber; }

    public void setFieldNumber(int fieldNumber) { this.fieldNumber = fieldNumber; }

    public int getState() { return state; }

    public void setState(int state) { this.state = state; }
}
