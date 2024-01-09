package com.company.app.controller;

import com.company.app.dto.PerformerDTO;
import com.company.app.model.Performer;
import com.company.app.service.PerformerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/performers")
public class PerformerController {
    private final PerformerService performerService;

    @PostMapping
    public PerformerDTO create(@RequestBody PerformerDTO performer) {
        return performerService.createPerformer(performer);
    }
    @GetMapping("/{id}")
    public PerformerDTO find(@PathVariable Long id) {
        return performerService.findPerformer(id);
    }

    @GetMapping
    public List<PerformerDTO> findAll() {
        return performerService.findAllPerformers();
    }

    @PutMapping
    public PerformerDTO update(@RequestBody PerformerDTO performer) {
        return performerService.updatePerformer(performer);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return performerService.deletePerformer(id);
    }
}
