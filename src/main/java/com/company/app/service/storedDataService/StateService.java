package com.company.app.service.storedDataService;

import com.company.app.dto.storedDataDTO.StateDTO;
import com.company.app.mapper.storedDataMapper.CountryMapper;
import com.company.app.mapper.storedDataMapper.StateMapper;
import com.company.app.mapper.storedDataMapper.list.StateListMapper;
import com.company.app.model.storedDataModel.State;
import com.company.app.repository.storedDataRepositroy.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StateService {
    private final StateRepository stateRepository;
    //private final CountryService countryService;
    private final StateMapper stateMapper;
    private final StateListMapper stateListMapper;
    private final CountryMapper countryMapper;

    public StateDTO createState(StateDTO stateDTO) {
        State state = stateRepository.save(stateMapper.toEntity(stateDTO));
        return stateMapper.toDTO(stateRepository.findById(state.getId()).orElseThrow());
    }

    public StateDTO findState(Long id) {
        State state = stateRepository.findById(id).orElseThrow();
        //state.setCountry(countryService.findCountry(state.getCountry().getId()));
        return stateMapper.toDTO(state);
    }

    public List<StateDTO> findAllStates() {
        return stateListMapper.toDTOList(stateRepository.findAll());
    }

    public StateDTO updateState(StateDTO stateDTO) {
        State updatedState = stateRepository.findById(stateDTO.getId()).orElseThrow();
        updatedState.setName(stateDTO.getName());
        updatedState.setCountry(countryMapper.toEntity(stateDTO.getCountry()));
        stateRepository.save(updatedState);
        return stateMapper.toDTO(updatedState);
    }

    public StateDTO deleteState(Long id) {
        State state = stateRepository.findById(id).orElseThrow();
        stateRepository.deleteById(id);
        return stateMapper.toDTO(state);
    }
}
