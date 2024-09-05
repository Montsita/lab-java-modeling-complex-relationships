package lab1SpringJPA.service;

import lab1SpringJPA.model.Event;
import lab1SpringJPA.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() { return eventRepository.findAll(); }

    public Optional<Event> getEventById(Long id){ return eventRepository.findById(id); }

    public Optional<Event> updateEvent(Long id, Event event){
        if(eventRepository.existsById(id)){
            event.setId(id);
            return Optional.of(eventRepository.save(event));
        }
        return Optional.empty();
    }
}
