package exercising.learnig.methoding;

import exercising.learnig.arraysCreating.Paair;

import java.util.ArrayList;
import java.util.List;


public class DeclaringVariables {
    List<Paair> listPaair = new ArrayList<>();
    List<Integer> listNumbers = new ArrayList<>();
    String pl, pl1, pl2, turn, option, save, select;
    int fieldNumber, state;

    public List<Paair> getListPaair() { return listPaair; }

    public List<Integer> getListNumbers() { return listNumbers; }

    public String getPl() { return pl; }

    public void setPl(String pl) { this.pl = pl; }

    public String getPl1() { return pl1; }

    public void setPl1(String pl1) { this.pl1 = pl1; }

    public String getPl2() { return pl2; }

    public void setPl2(String pl2) { this.pl2 = pl2; }

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
