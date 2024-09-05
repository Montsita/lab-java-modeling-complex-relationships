package lab1SpringJPA.service;

import lab1SpringJPA.model.Conference;
import lab1SpringJPA.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConferenceService {
    @Autowired
    private ConferenceRepository conferenceRepository;

    public List<Conference> getAllConferences() { return conferenceRepository.findAll(); }

    public Optional<Conference> getConferenceById(Long id){ return conferenceRepository.findById(id); }

    public Optional<Conference> updateConference(Long id, Conference conference){
        if(conferenceRepository.existsById(id)){
            conference.setId(id);
            return Optional.of(conferenceRepository.save(conference));
        }
        return Optional.empty();
    }
}
