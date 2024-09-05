package lab1SpringJPA.controller;

import lab1SpringJPA.model.Exposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lab1SpringJPA.service.ExpositionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exposition")
public class ExpositionController {
    @Autowired
    private ExpositionService expositionService;

    @GetMapping
    public List<Exposition> getAllExpositions(){ return expositionService.getAllExpositions();}

    @GetMapping("/{id}")
    public ResponseEntity<Exposition> getExpositionById(@PathVariable Long id){
        Optional<Exposition> exposition = expositionService.getExpositionById(id);
        return exposition.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exposition> updateExposition(@PathVariable Long id, @RequestBody Exposition exposition){
        Optional<Exposition> updatedExposition = expositionService.updateExposition(id, exposition);
        return updatedExposition.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

}