package org.example.RockPaperScissors;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;




@Slf4j
public class Processor  {

    private static final HibernateFacRPS SDA_SESSION_FACTORY
            = new HibernateFacRPS();

    public  void save() {
        SessionFactory sessionFactory = SDA_SESSION_FACTORY.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            Player gracz = new Player();
            gracz.setNazwa("Piotr");

            Serializable save = session.save(gracz);
            session.close();
        }
    }
            public void save1(int wynik) {
                SessionFactory sessionFactory = SDA_SESSION_FACTORY.getSessionFactory();
                try (Session session = sessionFactory.openSession()) {

            Round round = new Round();
            round.setResult(wynik);

            Serializable save1 = session.save(round);
            session.close();
        }
    }
        public void wypiszTure(Long id){
            HibernateFacRPS hibernateFactory = new HibernateFacRPS();
            SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
            try (SessionFactory sessionFactory1 = SDA_SESSION_FACTORY.getSessionFactory();
                 Session session = sessionFactory.openSession()) {
                Player gracz = session.load(Player.class, id);
                log.info(gracz.toString());
            }
        }
    public static void main(String[] args) {

        Processor przetwarzacz = new Processor();
            przetwarzacz.save();
    }

}


