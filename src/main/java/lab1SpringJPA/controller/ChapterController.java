package lab1SpringJPA.controller;

import lab1SpringJPA.model.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lab1SpringJPA.service.ChapterService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @GetMapping
    public List<Chapter> getAllChapters(){ return chapterService.getAllChapters();}

    @GetMapping("/{id}")
    public ResponseEntity<Chapter> getChapterById(@PathVariable Long id){
        Optional<Chapter> chapter = chapterService.getChapterById(id);
        return chapter.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chapter> updateChapter(@PathVariable Long id, @RequestBody Chapter chapter){
        Optional<Chapter> updatedChapter = chapterService.updateChapter(id, chapter);
        return updatedChapter.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

}
