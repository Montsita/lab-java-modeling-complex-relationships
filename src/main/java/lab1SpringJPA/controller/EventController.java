package lab1SpringJPA.controller;

import lab1SpringJPA.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lab1SpringJPA.service.EventService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents(){ return eventService.getAllEvents();}

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id){
        Optional<Event> event = eventService.getEventById(id);
        return event.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event){
        Optional<Event> updatedEvent = eventService.updateEvent(id, event);
        return updatedEvent.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

}
