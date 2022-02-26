package org.example.Ships;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Shots {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_shot;
    private int xCoordinate;
    private int yCoordinate;
    private boolean isHit;

    @OneToOne
    private ShipsPlayers player;
}
