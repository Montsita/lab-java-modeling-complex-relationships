package lab1SpringJPA.controller;

import lab1SpringJPA.enums.GuestStatus;
import lab1SpringJPA.enums.MemberStatus;
import lab1SpringJPA.model.Guest;
import lab1SpringJPA.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lab1SpringJPA.service.GuestService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @GetMapping
    public List<Guest> getAllGuests(){ return guestService.getAllGuests();}

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id){
        Optional<Guest> guest = guestService.getGuestById(id);
        return guest.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest guest){
        Optional<Guest> updatedGuest = guestService.updateGuest(id, guest);
        return updatedGuest.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/status-guest")
    public ResponseEntity<List<Guest>> buscarPorStatusGuest(@RequestParam GuestStatus statusGuest){
        List<Guest> guests = guestService.buscarPorStatusGuest(statusGuest);
        return ResponseEntity.ok(guests);
    }
}