package com.company.app.service;

import com.company.app.dto.PerformerDTO;
import com.company.app.mapper.PerformerListMapper;
import com.company.app.mapper.PerformerMapper;
import com.company.app.mapper.storedDataMapper.CityMapper;
import com.company.app.mapper.storedDataMapper.GenreMapper;
import com.company.app.mapper.storedDataMapper.list.GenreListMapper;
import com.company.app.model.Performer;
import com.company.app.repository.PerformerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PerformerService {
    private final PerformerRepository performerRepository;
    private final PerformerMapper performerMapper;
    private final PerformerListMapper performerListMapper;
    private final CityMapper cityMapper;
    private final GenreListMapper genreListMapper;

    public PerformerDTO createPerformer(PerformerDTO performerDTO) {
        Performer performer = performerRepository.save(performerMapper.toEntity(performerDTO));
        return performerMapper.toDTO(performerRepository.findById(performer.getId()).orElseThrow());
    }

    public PerformerDTO findPerformer(Long id) {
        return performerMapper.toDTO(performerRepository.findById(id).orElseThrow());
    }

    public List<PerformerDTO> findAllPerformers() {
        return performerListMapper.toDTOList(performerRepository.findAll());
    }

    public PerformerDTO updatePerformer(PerformerDTO performer) {
        Performer updatedPerformer = performerRepository.findById(performer.getId()).orElseThrow();
        updatedPerformer.setName(performer.getName());
        updatedPerformer.setInformation(performer.getInformation());
        updatedPerformer.setCity(cityMapper.toEntity(performer.getCity()));
        updatedPerformer.setGenre(genreListMapper.toEntiryList(performer.getGenre()));
        performerRepository.save(updatedPerformer);
        return performerMapper.toDTO(updatedPerformer);
    }

    public PerformerDTO deletePerformer(Long id) {
        Performer performer = performerRepository.findById(id).orElseThrow();
        performerRepository.deleteById(id);
        return performerMapper.toDTO(performer);
    }
}
