package com.simbirsoft.performer.controller;

import com.simbirsoft.performer.dto.AlbumDTO;
import com.simbirsoft.performer.service.AlbumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/album")
@Tag(name = "Album Service", description = "Service for managing albums")
public class AlbumController {
    private final AlbumService albumService;

    @Operation(summary = "Create album")
    @PostMapping
    public AlbumDTO create(@RequestBody AlbumDTO albumDTO) {
        return albumService.createAlbum(albumDTO);
    }

    @Operation(summary = "Get album")
    @GetMapping("/{id}")
    public AlbumDTO find(@PathVariable Long id) {
        return albumService.findAlbum(id);
    }

    @Operation(summary = "Get albums")
    @GetMapping
    public List<AlbumDTO> findAll() {
        return albumService.findAllAlbums();
    }

    @Operation(summary = "Update album")
    @PutMapping
    public AlbumDTO update(@RequestBody AlbumDTO albumDTO) {
        return albumService.updateAlbum(albumDTO);
    }

    @Operation(summary = "Delete album")
    @DeleteMapping("/{id}")
    public AlbumDTO delete(@PathVariable Long id) {
        return albumService.deleteAlbum(id);
    }
}
