package org.example.Game2048.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Game2048.Board.Board;

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
    @OneToMany(mappedBy = "user")
    private List<Board> boardList = new ArrayList<>();

    public void addNewBoard(Board board){
        boardList.add(board);
    }
}
