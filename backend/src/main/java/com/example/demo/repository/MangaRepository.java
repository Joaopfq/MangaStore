package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Manga;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends CrudRepository<Manga, Long> {
    
}
