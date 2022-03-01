package org.example.game2048.board;

import org.example.game2048.point.PointProcessor;
import org.example.game2048.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BoardProcessor {
    private final PointProcessor pointProcessor = new PointProcessor();

    public void addNewBoard(User user, Board board, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            board.setUser(user);
            List<Board> boardList = getUserBoardList(user.getId(),sessionFactory);
            boardList.add(board);
            session.save(board);
            pointProcessor.addPoints(board, sessionFactory);
        }

    }

    public List<Board> getUserBoardList(Long id, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT b FROM Board b left join b.user u WHERE u.id = :id", Board.class)
                    .setParameter("id", id)
                    .getResultList();
        }
    }
}
