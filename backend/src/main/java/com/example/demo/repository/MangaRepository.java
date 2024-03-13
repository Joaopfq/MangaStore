package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Manga;
import com.example.demo.repository.projection.MangaSummary;

import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends CrudRepository<Manga, Long> {
    public Page<MangaSummary> findByNome(Pageable pageable, String nome);
}
