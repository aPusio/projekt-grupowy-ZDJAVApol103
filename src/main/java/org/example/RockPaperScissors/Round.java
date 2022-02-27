package org.example.RockPaperScissors;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "rounds")
@Getter
@Setter

public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_round")
    private Long id;
    private int numberOfRounds;
    private int result;
}

