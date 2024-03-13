package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Manga;
import com.example.demo.model.dto.MangaUpdateDTO;
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
        Page<MangaSummary> manga = mangaRepository.findByNome(pageable, name);
        if (manga.isEmpty()) {
            throw new NoSuchElementException();
        }
        return manga;
    }

    @Override
    public Manga update(MangaUpdateDTO alterManga){
        Optional<Manga> manga = mangaRepository.findById(alterManga.id());
        
        if(manga.isEmpty()){
            throw new NoSuchElementException();
        }
        manga.get().setNome(alterManga.nome());
        manga.get().setSinopse(alterManga.sinopse());
        manga.get().setValue(alterManga.value());

        return mangaRepository.save(manga.get());
    }

    @Override
    public void deleteById(Long id){
        mangaRepository.deleteById(id);
    }
}
