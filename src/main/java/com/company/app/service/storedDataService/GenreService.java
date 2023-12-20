package com.company.app.service.storedDataService;

import com.company.app.model.storedDataModel.Genre;
import com.company.app.repository.storedDataRepositroy.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre findGenre(Long id) {
        return genreRepository.findById(id).orElseThrow();
    }
    public List<Genre> findAllGenre() {
        return genreRepository.findAll();
    }

    public Genre updateGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}
