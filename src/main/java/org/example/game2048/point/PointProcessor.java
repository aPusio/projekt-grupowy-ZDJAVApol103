package org.example.game2048.point;

import org.example.game2048.Factory;
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
}
