package com.simbirsoft.performer.controller;

import com.simbirsoft.performer.dto.PerformerDTO;
import com.simbirsoft.performer.dto.SongDTO;
import com.simbirsoft.performer.service.SongService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/song")
@Tag(name = "Song Service", description = "Service for managing songs")
public class SongController {
    private final SongService songService;

    @Operation(summary = "Create song")
    @PostMapping
    public SongDTO create(@RequestBody SongDTO song) {
            return songService.createSong(song);
    }

    @Operation(summary = "Get song")
    @GetMapping("/{id}")
    public SongDTO find(@PathVariable Long id) {
        return songService.findSong(id);
    }

    @Operation(summary = "Get all songs")
    @GetMapping
    public List<SongDTO> findAll() {
        return songService.findAllSongs();
    }

    @Operation(summary = "Update song")
    @PutMapping
    public SongDTO update(@RequestBody SongDTO song) {
        return songService.updateSong(song);
    }

    @Operation(summary = "Delete song")
    @DeleteMapping("/{id}")
    public SongDTO delete(@PathVariable Long id) {
        return songService.deleteSong(id);
    }
}
