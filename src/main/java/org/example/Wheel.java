package org.example;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class Wheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer size;
    private String model;

    @ManyToOne
    private Car car;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "id=" + id +
                ", size=" + size +
                ", model='" + model + '\'' +
                '}';
    }
}
