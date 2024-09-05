package lab1SpringJPA.repository;

import lab1SpringJPA.model.Chapter;
import lab1SpringJPA.model.Exposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpositionRepository extends JpaRepository<Exposition, Long> {
}
