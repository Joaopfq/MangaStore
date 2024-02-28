package com.example.demo.service;

import com.example.demo.model.Manga;

import java.util.List;
import java.util.Optional;


public interface MangaService {

    Manga save(Manga manga);

    List<Manga> findAll();

    Optional<Manga> findById(Long id);

    Manga update(Manga manga);

    void deleteById(Long id);
}