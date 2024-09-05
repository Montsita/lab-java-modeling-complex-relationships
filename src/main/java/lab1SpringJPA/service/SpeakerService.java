package lab1SpringJPA.service;

import lab1SpringJPA.model.Speaker;
import lab1SpringJPA.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeakerService {
    @Autowired
    private SpeakerRepository speakerRepository;

    public List<Speaker> getAllSpeakers() { return speakerRepository.findAll(); }

    public Optional<Speaker> getSpeakerById(Long id){ return speakerRepository.findById(id); }

    public Optional<Speaker> updateSpeaker(Long id, Speaker speaker){
        if(speakerRepository.existsById(id)){
            speaker.setId(id);
            return Optional.of(speakerRepository.save(speaker));
        }
        return Optional.empty();
    }
}