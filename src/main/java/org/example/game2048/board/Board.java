package org.example.game2048.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.game2048.point.Point;
import org.example.game2048.user.User;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"user", "pointList"})
public class Board implements Comparable<Board> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "board")
    private List<Point> pointList;
    @ManyToOne
    private User user;

    @Override
    public int compareTo(Board o) {
        return (int) (this.getId() - o.getId());
    }
}