package lab1SpringJPA.service;

import lab1SpringJPA.model.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lab1SpringJPA.repository.ChapterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    public List<Chapter> getAllChapters() { return chapterRepository.findAll(); }

    public Optional<Chapter> getChapterById(Long id){ return chapterRepository.findById(id); }

    public Optional<Chapter> updateChapter(Long id, Chapter chapter){
        if(chapterRepository.existsById(id)){
            chapter.setId(id);
            return Optional.of(chapterRepository.save(chapter));
        }
        return Optional.empty();
    }
}
