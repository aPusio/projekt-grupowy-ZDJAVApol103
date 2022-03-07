package exercising.learnig.factoring;

import exercising.learnig.arraysCreating.Paair;
import org.example.Car;
import org.example.Owner;
import org.example.Wheel;
import exercising.learnig.arraysCreating.SaveTheGame;
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
        configuration.addAnnotatedClass(SaveTheGame.class);
        configuration.addAnnotatedClass(Paair.class);
        return configuration;
    }

    public SessionFactory getSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(getHibernateConfig().getProperties()).build();
        return getHibernateConfig().buildSessionFactory(registry);
    }
}
