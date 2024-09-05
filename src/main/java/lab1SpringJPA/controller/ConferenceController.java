package lab1SpringJPA.controller;

import lab1SpringJPA.model.Conference;
import lab1SpringJPA.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conference")
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;

    @GetMapping
    public List<Conference> getAllConferences(){ return conferenceService.getAllConferences();}

    @GetMapping("/{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable Long id){
        Optional<Conference> conference = conferenceService.getConferenceById(id);
        return conference.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conference> updateConference(@PathVariable Long id, @RequestBody Conference conference){
        Optional<Conference> updatedConference = conferenceService.updateConference(id, conference);
        return updatedConference.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

}
