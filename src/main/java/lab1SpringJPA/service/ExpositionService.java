package lab1SpringJPA.service;

import lab1SpringJPA.model.Exposition;
import lab1SpringJPA.repository.ExpositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpositionService {
    @Autowired
    private ExpositionRepository expositionRepository;

    public List<Exposition> getAllExpositions() { return expositionRepository.findAll(); }

    public Optional<Exposition> getExpositionById(Long id){ return expositionRepository.findById(id); }

    public Optional<Exposition> updateExposition(Long id, Exposition exposition){
        if(expositionRepository.existsById(id)){
            exposition.setId(id);
            return Optional.of(expositionRepository.save(exposition));
        }
        return Optional.empty();
    }
}
