package repository;

import enums.Status;
import model.Chapter;
import model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByStatus(Status statusMiembro);
}
