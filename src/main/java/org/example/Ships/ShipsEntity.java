package org.example.Ships;


import lombok.Getter;
import lombok.Setter;
import org.example.learnig.Wheel;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class ShipsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int shipLength;
    private int xStartPoint;
    private int yStartPoint;
    private int xEndPoint;
    private int yEndPoint;
    private int hits;

//    @OneToMany(mappedBy = "ship")
//    private List<Shots> shots;
//
//    @ManyToOne
//    private ShipsPlayers shipsPlayers;

//    public static Ships toShips(ShipsEntity shipsEntity){
//      return
//    }
}
