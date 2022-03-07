package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.Car;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @OneToOne
    private Car car;
}
