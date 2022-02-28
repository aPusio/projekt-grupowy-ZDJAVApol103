package org.example;


import org.example.game2048.board.Board;
import org.example.game2048.point.Point;
import org.example.game2048.user.User;
import org.example.learnig.hibernate.Car;
import org.example.learnig.hibernate.Owner;
import org.example.learnig.hibernate.Wheel;
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

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Board.class);
        configuration.addAnnotatedClass(Point.class);

        return configuration;
    }

    public SessionFactory getSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(getHibernateConfig().getProperties()).build();
        return getHibernateConfig().buildSessionFactory(registry);
    }
}
