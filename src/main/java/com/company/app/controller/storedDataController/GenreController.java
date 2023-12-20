package com.company.app.controller.storedDataController;

import com.company.app.model.storedDataModel.Genre;
import com.company.app.service.storedDataService.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping
    public Genre create(@RequestBody Genre genre) {
        return genreService.createGenre(genre);
    }
    @GetMapping("/{id}")
    public Genre find(@PathVariable Long id) {
        return genreService.findGenre(id);
    }

    @GetMapping
    public List<Genre> findAll() {
        return genreService.findAllGenre();
    }

    @PutMapping
    public Genre update(@RequestBody Genre genre) {
        return  genreService.updateGenre(genre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        genreService.deleteGenre(id);
    }
}
