package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Manga;
import com.example.demo.repository.MangaRepository;
import com.example.demo.repository.projection.MangaSummary;

@Service
public class MangaServiceImpl implements MangaService {
    
    @Autowired
    private MangaRepository mangaRepository;

    @Override
    public Manga save (Manga manga){
        return mangaRepository.save(manga);
    }

    @Override
    public List<Manga> findAll() {
        return Streamable.of(mangaRepository.findAll()).toList();
    }

    @Override
    public Optional<Manga> findById(Long id) {
        return mangaRepository.findById(id);
    }

    @Override
    public Page<MangaSummary> findByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return mangaRepository.findByNome(pageable, name);
    }

    @Override
    public Manga update(Manga alterManga){
        return mangaRepository.save(alterManga);
    }

    @Override
    public void deleteById(Long id){
        mangaRepository.deleteById(id);
    }
}
