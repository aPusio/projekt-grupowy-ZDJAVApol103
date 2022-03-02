package org.example;

//import org.example.Service.Paair;
//import org.example.Service.SaveTheGame;
import org.example.Tictactoe.Entity.RoundEntity;
import org.example.learnig.Car;
import org.example.learnig.Owner;
import org.example.learnig.Wheel;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
    private Configuration getHibernateConfig() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://remotemysql.com:3306/0AAETZhCTg");
        configuration.setProperty("hibernate.connection.username", "0AAETZhCTg");
        configuration.setProperty("hibernate.connection.password", "RipnIQyjoR");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");

        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(Owner.class);
        configuration.addAnnotatedClass(Wheel.class);
        configuration.addAnnotatedClass(RoundEntity.class);
//        configuration.addAnnotatedClass(SaveTheGame.class);
//        configuration.addAnnotatedClass(Paair.class);
        return configuration;
    }

    public SessionFactory getSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(getHibernateConfig().getProperties()).build();
        return getHibernateConfig().buildSessionFactory(registry);
    }
}
