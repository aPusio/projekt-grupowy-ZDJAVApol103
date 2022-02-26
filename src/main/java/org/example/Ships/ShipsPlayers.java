package org.example.Ships;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class ShipsPlayers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_player;
    private String login;
    private String status;

    @OneToMany(mappedBy = "player")
    private List<Shots> shots;
}
