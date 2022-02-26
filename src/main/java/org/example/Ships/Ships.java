package org.example.Ships;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Ships {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int shipLength;
    private int xStartPoint;
    private int yStartPoint;
    private int xEndPoint;
    private int yEndPoint;
    private int hits;

}
