package lab1SpringJPA.service;

import lab1SpringJPA.enums.GuestStatus;
import lab1SpringJPA.enums.MemberStatus;
import lab1SpringJPA.model.Guest;
import lab1SpringJPA.model.Member;
import lab1SpringJPA.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Optional<Guest> getGuestById(Long id) {
        return guestRepository.findById(id);
    }

    public Optional<Guest> updateGuest(Long id, Guest guest) {
        if (guestRepository.existsById(id)) {
            guest.setId(id);
            return Optional.of(guestRepository.save(guest));
        }
        return Optional.empty();
    }

    public List<Guest> buscarPorStatusGuest(GuestStatus statusGuest) {
        return guestRepository.findByStatus(statusGuest);
    }
}