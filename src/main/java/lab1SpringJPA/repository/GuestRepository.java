package lab1SpringJPA.repository;

import lab1SpringJPA.enums.GuestStatus;
import lab1SpringJPA.enums.MemberStatus;
import lab1SpringJPA.model.Guest;
import lab1SpringJPA.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByStatus(GuestStatus statusGuest);
}
