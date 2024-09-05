package lab1SpringJPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Conference extends Event{

    @OneToMany
    private List<Speaker> speakers;
}
