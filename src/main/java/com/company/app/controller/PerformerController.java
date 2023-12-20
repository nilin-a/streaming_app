package com.company.app.controller;

import com.company.app.model.Performer;
import com.company.app.service.PerformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/performers")
public class PerformerController {
    @Autowired
    private PerformerService performerService;

    @PostMapping
    public Performer create(@RequestBody Performer performer) {
        return performerService.createPerformer(performer);
    }
    @GetMapping("/{id}")
    public Performer find(@PathVariable Long id) {
        return performerService.findPerformer(id);
    }

    @GetMapping
    public List<Performer> findAll() {
        return performerService.findAllPerformers();
    }

    @PutMapping
    public Performer update(@RequestBody Performer performer) {
        return performerService.updatePerformer(performer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        performerService.deletePerformer(id);
    }
}
