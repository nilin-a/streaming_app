package com.simbirsoft.performer.service;

import com.simbirsoft.performer.dto.PerformerDTO;
import com.simbirsoft.performer.mapper.PerformerListMapper;
import com.simbirsoft.performer.mapper.PerformerMapper;
import com.simbirsoft.performer.mapper.storedDataMapper.CityMapper;
import com.simbirsoft.performer.mapper.storedDataMapper.list.GenreListMapper;
import com.simbirsoft.performer.model.Performer;
import com.simbirsoft.performer.repository.PerformerRepository;
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
        PerformerDTO performerDTO = performerMapper.toDTO(performerRepository.findById(id).orElseThrow());
        performerRepository.deleteById(id);
        return performerDTO;
    }
}
