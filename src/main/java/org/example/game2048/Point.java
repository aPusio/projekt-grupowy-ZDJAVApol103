package org.example.game2048;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer x;
    private Integer y;
    private Integer value;
    @ManyToOne
    private Board board;

    public Point(Integer x, Integer y, Integer value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x.equals(point.x) && y.equals(point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}