package org.example.Game2048;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    @OneToMany(mappedBy = "user")
    private List<Board> boardList;
}
