package lab1SpringJPA.model;

import jakarta.persistence.*;
import lab1SpringJPA.enums.GuestStatus;
import lab1SpringJPA.enums.MemberStatus;
import lombok.Data;

@Data
@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private GuestStatus status;

    @ManyToOne
    private Event event;
}
