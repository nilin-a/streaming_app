package com.company.app.service;

import com.company.app.model.Performer;
import com.company.app.model.storedDataModel.Genre;
import com.company.app.repository.PerformerRepository;
import com.company.app.service.storedDataService.CityService;
import com.company.app.service.storedDataService.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformerService {
    @Autowired
    private PerformerRepository performerRepository;

    public Performer createPerformer(Performer performer) {
        return performerRepository.save(performer);
    }

    public Performer findPerformer(Long id) {
        return performerRepository.findById(id).orElseThrow();
    }

    public List<Performer> findAllPerformers() {
        return performerRepository.findAll();
    }

    public Performer updatePerformer(Performer performer) {
        Performer updatedPerformer = performerRepository.findById(performer.getId()).orElseThrow();
        updatedPerformer.setName(performer.getName());
        updatedPerformer.setInformation(performer.getInformation());
        updatedPerformer.setCity(performer.getCity());
        updatedPerformer.setGenre(performer.getGenre());
        return performerRepository.save(updatedPerformer);
    }

    public void deletePerformer(Long id) {
        performerRepository.deleteById(id);
    }
}
