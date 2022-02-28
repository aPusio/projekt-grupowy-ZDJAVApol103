package org.example.game2048.user;

import org.example.game2048.board.BoardGenerator;
import org.example.game2048.board.BoardProcessor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.NoResultException;

public class UserProcessor {
    private final BoardProcessor boardProcessor = new BoardProcessor();

    private User addNewUser(String nickname, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            User user = new User();
            user.setNickname(nickname);
            session.save(user);
            boardProcessor.addNewBoard(user, BoardGenerator.generateNewBoard(), sessionFactory);
            return user;
        }
    }

    public User getUser(String nickname, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            try {
                return session.createQuery("SELECT u FROM User u WHERE u.nickname = :nickname", User.class)
                        .setParameter("nickname", nickname)
                        .getSingleResult();
            } catch (NoResultException e) {
                return addNewUser(nickname, sessionFactory);
            }
        }

    }
}