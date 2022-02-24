package org.example.Game2048;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "board")
    private List<Point> pointList;
    @ManyToOne
    private User user;
}
