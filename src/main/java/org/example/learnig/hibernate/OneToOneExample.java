package org.example.learnig.hibernate;

import org.example.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneExample {
    public static void main(String[] args) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
//
//        Car car = new Car();
//        car.setName("Fiat");
//        car.setProductionYear(1992);
//
//        Owner owner = new Owner();
//        owner.setName("Adam");
//        owner.setSurname("Adamski");
//
//        car.setOwner(owner);
//        owner.setCar(car);
//
//        session.save(car);
//        session.save(owner);
//
//        session.close();
//        sessionFactory.close();
    }
}
