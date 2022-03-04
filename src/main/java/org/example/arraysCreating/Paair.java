package org.example.arraysCreating;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Paair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private char player;
    private int fieldNumber;
    @ManyToOne
    private SaveTheGame saveTheGame;

    public Paair(char player, int fieldNumber) {
        this.player =player;
        this.fieldNumber = fieldNumber;
    }
    @Override
    public String toString() {return  " " + player + " " + fieldNumber ;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paair paair = (Paair) o;
        return fieldNumber == paair.fieldNumber && Objects.equals(id, paair.id) && Objects.equals(player, paair.player)
                && Objects.equals(saveTheGame, paair.saveTheGame);
    }
    @Override
    public int hashCode() {
        return Objects.hash(player, fieldNumber);
    }
}
