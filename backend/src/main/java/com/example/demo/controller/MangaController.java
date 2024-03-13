package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Manga;
import com.example.demo.model.dto.MangaUpdateDTO;
import com.example.demo.repository.projection.MangaSummary;
import com.example.demo.service.MangaService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/mangas")
public class MangaController {
    
    @Autowired
    private MangaService mangaService;

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Manga>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mangaService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Page<MangaSummary>> findByName(
        @PathVariable String name,
        @RequestParam("page") int page,
        @RequestParam("size") int size
    ) {
        try {
            Page<MangaSummary> manga = mangaService.findByName(name, page, size);
            return ResponseEntity.status(HttpStatus.OK).body(manga);
            
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Manga>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(mangaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Manga> create(@RequestBody Manga manga) {
        System.out.println(manga.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(mangaService.save(manga));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody MangaUpdateDTO manga) {
        try {
            mangaService.update(manga);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        mangaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
