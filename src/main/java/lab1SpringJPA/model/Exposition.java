package lab1SpringJPA.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Exposition extends Event{
    private String test;
}
