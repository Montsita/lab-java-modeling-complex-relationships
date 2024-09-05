package lab1SpringJPA.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int presentationDuration;

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference;
}
