package org.example.learnig;

import org.example.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToManyExample {
    public static void main(String[] args) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();

        Car car = new Car();
        car.setName("Fiat");
        car.setProductionYear(1992);

        Wheel leftWheel = new Wheel();
        leftWheel.setSize(17);
        leftWheel.setName("kolo lewe");

        Wheel rightWheel = new Wheel();
        rightWheel.setSize(17);
        rightWheel.setName("kolo prawe");

//        car.setWheels(List.of(leftWheel, rightWheel));
        leftWheel.setCar(car);
        rightWheel.setCar(car);

        session.save(car);
        session.save(leftWheel);
        session.save(rightWheel);

        session.close();
        sessionFactory.close();
    }
}
