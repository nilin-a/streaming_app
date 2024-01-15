package com.company.app.controller.storedDataController;

import com.company.app.dto.storedDataDTO.GenreDTO;
import com.company.app.model.storedDataModel.Genre;
import com.company.app.service.storedDataService.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/genres")
@Tag(name = "Genre Service", description = "Service for managing genres")
public class GenreController {
    private final GenreService genreService;

    @Operation(summary = "Create genre")
    @PostMapping
    public GenreDTO create(@RequestBody GenreDTO genre) {
        return genreService.createGenre(genre);
    }

    @Operation(summary = "Get genre")
    @GetMapping("/{id}")
    public GenreDTO find(@PathVariable Long id) {
        return genreService.findGenre(id);
    }

    @Operation(summary = "Get all genres")
    @GetMapping
    public List<GenreDTO> findAll() {
        return genreService.findAllGenre();
    }

    @Operation(summary = "Update genre")
    @PutMapping
    public GenreDTO update(@RequestBody GenreDTO genre) {
        return  genreService.updateGenre(genre);
    }

    @Operation(summary = "Delete genre")
    @DeleteMapping("/{id}")
    public GenreDTO delete(@PathVariable Long id) {
        return genreService.deleteGenre(id);
    }
}
