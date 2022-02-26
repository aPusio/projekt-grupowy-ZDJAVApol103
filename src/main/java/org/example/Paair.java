package org.example;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Paair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String str;
    private int number;
    @ManyToOne
    private SaveTheGame saveTheGame;

    public Paair(String str, int number) {
        this.str = str;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paair paair = (Paair) o;
        return number == paair.number && Objects.equals(id, paair.id) && Objects.equals(str, paair.str)
                && Objects.equals(saveTheGame, paair.saveTheGame);
    }


    @Override
    public int hashCode() {
        return Objects.hash(str, number);
    }
}
