package org.example.Game2048;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer x;
    private Integer y;
    private Integer value;
    @ManyToOne
    private Board board;
}
