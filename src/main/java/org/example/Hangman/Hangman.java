package org.example.Hangman;

import lombok.Data;
import org.hibernate.mapping.List;

import javax.persistence.*;

@Entity
@Data
public class Hangman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String usedLetters;
    @ManyToOne
    private Player player1;
    @ManyToOne
    private Player player2;


}
