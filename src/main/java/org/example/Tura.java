package org.example.learnig;


import lombok.extern.slf4j.Slf4j;
import org.example.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Slf4j
public class Tura {

    private static final HibernateFactory SESION_FACTORY = new HibernateFactory();

    public void wypiszTure(Long id){
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        try (SessionFactory sessionFactory1 = SESION_FACTORY.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            Gracz gracz = session.load(Gracz.class, id);
            log.info(gracz.toString());
        }
    }
}
