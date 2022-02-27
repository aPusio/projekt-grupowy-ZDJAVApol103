package org.example.RockPaperScissors;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "gracze")
@Getter
@Setter

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gracz")
    private Long id;
    private String nazwa;


}