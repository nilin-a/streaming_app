package com.simbirsoft.performer.controller;

import com.simbirsoft.performer.dto.PerformerDTO;
import com.simbirsoft.performer.service.PerformerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/performer")
@Tag(name = "Performer Service", description = "Service for managing performers")
public class PerformerController {
    private final PerformerService performerService;

    @Operation(summary = "Create performer")
    @PostMapping
    public PerformerDTO create(@RequestBody PerformerDTO performer) {
        return performerService.createPerformer(performer);
    }

    @Operation(summary = "Get performer")
    @GetMapping("/{id}")
    public PerformerDTO find(@PathVariable Long id) {
        return performerService.findPerformer(id);
    }

    @Operation(summary = "Get all performers")
    @GetMapping
    public List<PerformerDTO> findAll() {
        return performerService.findAllPerformers();
    }

    @Operation(summary = "Update performer")
    @PutMapping
    public PerformerDTO update(@RequestBody PerformerDTO performer) {
        return performerService.updatePerformer(performer);
    }

    @Operation(summary = "Delete performer")
    @DeleteMapping("/{id}")
    public PerformerDTO delete(@PathVariable Long id) {
        return performerService.deletePerformer(id);
    }
}
