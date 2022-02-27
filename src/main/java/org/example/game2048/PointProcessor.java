package org.example.game2048;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PointProcessor {
    //        Prywatna DB:
    private static final SessionFactory SESSION_FACTORY = new Factory().getSessionFactory();

    //        DB projektu wspólnego:
//    private static final SessionFactory SESSION_FACTORY = new HibernateFactory().getSessionFactory();
    public void addPoints(Board board) {
        try (Session session = SESSION_FACTORY.openSession()) {
            List<Point> points = board.getPointList();
            for (Point point : points) {
                point.setBoard(board);
                session.save(point);
            }
        }
    }
}
