package org.example.Game2048;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
}
