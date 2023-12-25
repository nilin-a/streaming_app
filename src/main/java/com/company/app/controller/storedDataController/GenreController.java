package com.company.app.controller.storedDataController;

import com.company.app.dto.storedDataDTO.GenreDTO;
import com.company.app.model.storedDataModel.Genre;
import com.company.app.service.storedDataService.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/genres")
public class GenreController {
    private final GenreService genreService;

    @PostMapping
    public GenreDTO create(@RequestBody GenreDTO genre) {
        return genreService.createGenre(genre);
    }
    @GetMapping("/{id}")
    public GenreDTO find(@PathVariable Long id) {
        return genreService.findGenre(id);
    }

    @GetMapping
    public List<GenreDTO> findAll() {
        return genreService.findAllGenre();
    }

    @PutMapping
    public GenreDTO update(@RequestBody GenreDTO genre) {
        return  genreService.updateGenre(genre);
    }

    @DeleteMapping("/{id}")
    public GenreDTO delete(@PathVariable Long id) {
        return genreService.deleteGenre(id);
    }
}
