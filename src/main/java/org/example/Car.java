package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer productionYear;
    @OneToMany(mappedBy = "car")
    private List<Wheel> wheelList;

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public List<Wheel> getWheelList() {
        return wheelList;
    }

    public void setWheelList(List<Wheel> wheelList) {
        this.wheelList = wheelList;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productionYear=" + productionYear +
                '}';
    }
}
