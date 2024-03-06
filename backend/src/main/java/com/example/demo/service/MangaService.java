package com.example.demo.service;

import com.example.demo.model.Manga;
import com.example.demo.model.dto.MangaUpdateDTO;
import com.example.demo.repository.projection.MangaSummary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;


public interface MangaService {

    Manga save(Manga manga);

    List<Manga> findAll();

    Page<MangaSummary> findByName(String name, int page, int size);

    Optional<Manga> findById(Long id);

    Manga update(MangaUpdateDTO manga);

    void deleteById(Long id);
}