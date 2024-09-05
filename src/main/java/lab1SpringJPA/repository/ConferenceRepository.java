package lab1SpringJPA.repository;

import lab1SpringJPA.model.Chapter;
import lab1SpringJPA.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
