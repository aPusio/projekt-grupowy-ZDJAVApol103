package org.example.game2048.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.game2048.board.Board;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Board> boardList = new ArrayList<>();

    public void addNewBoard(Board board){
        boardList.add(board);
    }
}