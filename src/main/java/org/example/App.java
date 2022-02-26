package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("WYBIERZ OPCJE Z MENU:");
        int userOption = scanner.nextInt();
        System.out.println("USER WPISAL " + userOption);

        switch (userOption){
            case 1:
                System.out.println("GAME 1");
                break;
            case 2:
                System.out.println("GAME 2");
                break;
        }
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Car car = new Car();
        car.setName("FIAT");
        car.setProductionYear(1992);

        Wheel michelin = new Wheel();
        michelin.setSize(17);
        michelin.setModel("SnowDragon");

        car.setWheelList(List.of(michelin));
        michelin.setCar(car);

        session.save(car);
        session.save(michelin);

        session.close();
        sessionFactory.close();
    }
}
