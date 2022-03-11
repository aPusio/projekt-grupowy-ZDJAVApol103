package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.Car;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Wheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer size;

    @ManyToOne
    private Car car;
}