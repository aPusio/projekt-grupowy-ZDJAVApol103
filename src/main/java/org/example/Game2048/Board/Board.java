package org.example.Game2048.Board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.Game2048.Point.Point;
import org.example.Game2048.User.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "board")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "user")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "board")
    private List<Point> pointList;
    @ManyToOne
    private User user;

}
