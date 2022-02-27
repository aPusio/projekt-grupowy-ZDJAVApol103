package org.example.Service;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity


public class Paair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String str;
    private int number;
    @ManyToOne
    private SaveTheGame saveTheGame;

    public Paair() {

    }

    public Paair(String str, int number) {
        this.str = str;
        this.number = number;
    }
}
