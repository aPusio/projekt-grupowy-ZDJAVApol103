package org.example.game2048.point;

import org.example.game2048.board.Board;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PointProcessor {
    public void addPoints(Board board, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            List<Point> points = board.getPointList();
            for (Point point : points) {
                point.setBoard(board);
                session.save(point);
            }
        }
    }
    public List<Point> getBoardPointList(Long id, SessionFactory sessionFactory){
        try (Session session = sessionFactory.openSession()){
            return session.createQuery("SELECT p FROM Point p left join p.board b WHERE b.id = :id", Point.class)
                    .setParameter("id", id)
                    .getResultList();

        }
    }
}
