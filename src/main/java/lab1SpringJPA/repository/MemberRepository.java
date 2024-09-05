package lab1SpringJPA.repository;

import lab1SpringJPA.enums.MemberStatus;
import lab1SpringJPA.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByStatus(MemberStatus statusMiembro);
}
