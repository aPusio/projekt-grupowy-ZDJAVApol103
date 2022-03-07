//package org.example.Service;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.example.Service.Paair;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//public class SaveTheGame {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long Id;
//    private LocalDateTime localDateTime;
//    @OneToMany(mappedBy = "saveTheGame")
//    @Column(name = "saveTheGame_id")
//    private List<Paair> listPaair;
//
//}
