package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer productionYear;

    @OneToOne(mappedBy = "car")
    private Owner owner;

    @OneToMany(mappedBy = "car")
    private List<Wheel> wheels;
}
