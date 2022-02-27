package org.example.Game2048.User;

import org.example.Game2048.Board.Board;
import org.example.Game2048.Board.BoardGenerator;
import org.example.Game2048.Point.Point;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Scanner;

public class UserProcessor {

    private User addNewUser(String nickname, Session session, Board board) {
        User user = new User();
        user.setNickname(nickname);

        addNewBoard(user,session, board);
        return user;
    }
    public void addNewBoard(User user, Session session, Board board){
        board.setUser(user);
        List<Board> boardList = user.getBoardList();
        boardList.add(board);
        user.setBoardList(boardList);

        session.save(user);
        session.save(board);

        List<Point> points = board.getPointList();
        for (Point point : points) {
            point.setBoard(board);
            session.save(point);
        }
    }


    public User getUser(String nickname, Session session) {
        try {
            return session.createQuery("SELECT u FROM User u WHERE u.nickname = :nickname", User.class)
                    .setParameter("nickname", nickname)
                    .getSingleResult();
        } catch (NoResultException e) {
            return addNewUser(nickname, session, BoardGenerator.generateNewBoard());
        }
    }
}