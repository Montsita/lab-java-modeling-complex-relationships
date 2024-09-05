package lab1SpringJPA.controller;

import lab1SpringJPA.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lab1SpringJPA.service.SpeakerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/speaker")
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;

    @GetMapping
    public List<Speaker> getAllSpeakers(){ return speakerService.getAllSpeakers();}

    @GetMapping("/{id}")
    public ResponseEntity<Speaker> getSpeakerById(@PathVariable Long id){
        Optional<Speaker> speaker = speakerService.getSpeakerById(id);
        return speaker.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Speaker> updateSpeaker(@PathVariable Long id, @RequestBody Speaker speaker){
        Optional<Speaker> updatedSpeaker = speakerService.updateSpeaker(id, speaker);
        return updatedSpeaker.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

}
