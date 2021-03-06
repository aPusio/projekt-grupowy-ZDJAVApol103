package org.example.Hangman;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private Configuration getHibernateConfig() {
        Configuration configuration = new Configuration();
//        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://db4free.net:3306/projektgrupowy");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://db4free.net:3306/projektgrupowy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false");
        configuration.setProperty("hibernate.connection.username", "javagdapol");
        configuration.setProperty("hibernate.connection.password", "admin12345");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");

        configuration.addAnnotatedClass(WordsProcessor.class);
        configuration.addAnnotatedClass(Words.class);
//        configuration.addAnnotatedClass(Category.class);
        return configuration;
    }

    public SessionFactory getSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(getHibernateConfig().getProperties()).build();
        return getHibernateConfig().buildSessionFactory(registry);
    }
}