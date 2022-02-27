package org.example.game2048;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.NoResultException;
import java.util.List;

public class UserProcessor {
    private static final SessionFactory SESSION_FACTORY = new Factory().getSessionFactory();

    private User addNewUser(String nickname) {
        try (Session session = SESSION_FACTORY.openSession()){
            User user = new User();
            user.setNickname(nickname);
            session.save(user);
            addNewBoard(user, BoardGenerator.generateNewBoard());
            return user;
        }
    }

    public void addNewBoard(User user, Board board) {
        try (Session session = SESSION_FACTORY.openSession()) {
            board.setUser(user);
            List<Board> boardList = user.getBoardList();
            boardList.add(board);
            user.setBoardList(boardList);

            session.save(board);

            List<Point> points = board.getPointList();
            for (Point point : points) {
                point.setBoard(board);
                session.save(point);
            }
        }

    }


    public User getUser(String nickname, Session session) {
        try {
            return session.createQuery("SELECT u FROM User u WHERE u.nickname = :nickname", User.class)
                    .setParameter("nickname", nickname)
                    .getSingleResult();
        } catch (NoResultException e) {
            return addNewUser(nickname);
        }
    }
}