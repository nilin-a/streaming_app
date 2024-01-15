package com.simbirsoft.performer.service.storedDataService;

import com.simbirsoft.performer.dto.storedDataDTO.StateDTO;
import com.simbirsoft.performer.mapper.storedDataMapper.CountryMapper;
import com.simbirsoft.performer.mapper.storedDataMapper.StateMapper;
import com.simbirsoft.performer.mapper.storedDataMapper.list.StateListMapper;
import com.simbirsoft.performer.model.storedDataModel.State;
import com.simbirsoft.performer.repository.storedDataRepositroy.StateRepository;
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
