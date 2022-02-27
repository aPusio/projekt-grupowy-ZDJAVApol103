package org.example.game2048.board;

import org.example.game2048.Factory;
import org.example.game2048.point.PointProcessor;
import org.example.game2048.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BoardProcessor {
    private static final PointProcessor POINT_PROCESSOR = new PointProcessor();
    //        Prywatna DB:
    private static final SessionFactory SESSION_FACTORY = new Factory().getSessionFactory();

    //        DB projektu wspólnego:
//    private static final SessionFactory SESSION_FACTORY = new HibernateFactory().getSessionFactory();
    public void addNewBoard(User user, Board board) {
        try (Session session = SESSION_FACTORY.openSession()) {
            board.setUser(user);
            List<Board> boardList = user.getBoardList();
            boardList.add(board);
            user.setBoardList(boardList);
            session.save(board);
            POINT_PROCESSOR.addPoints(board);
        }

    }
}
