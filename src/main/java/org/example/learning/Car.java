package org.example.learning;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Car {
    @Id
    private Long id;
    private String name;
    private Integer productionYear;

    @OneToOne
    private Owner owner;
}
