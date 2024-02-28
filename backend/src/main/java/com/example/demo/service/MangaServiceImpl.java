package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Manga;
import com.example.demo.repository.MangaRepository;

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
        return mangaRepository.findAll();
    }

    @Override
    public Optional<Manga> findById(Long id) {
        return mangaRepository.findById(id);
    }

    @Override
    public Manga update(Manga manga){
        return mangaRepository.save(manga);

    }

    @Override
    public void deleteById(Long id){
        mangaRepository.deleteById(id);
    }
}
