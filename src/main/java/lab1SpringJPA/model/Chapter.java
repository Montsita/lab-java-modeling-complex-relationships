package lab1SpringJPA.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Chapter implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String district;
    @OneToOne
    private Member president;

    //mapped es el nombre que le doy para que busque la lista de miembros
    @OneToMany(mappedBy = "chapter")
    private List<Member> members;
}
