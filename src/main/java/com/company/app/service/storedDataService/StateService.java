package com.company.app.service.storedDataService;

import com.company.app.model.storedDataModel.State;
import com.company.app.repository.storedDataRepositroy.CountryRepository;
import com.company.app.repository.storedDataRepositroy.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CountryService countryService;

    public State createState(State state) {
        State newState = stateRepository.save(state);
        newState.setCountry(countryService.findCountry(state.getCountry().getId()));
        return newState;
    }

    public State findState(Long id) {
        return stateRepository.findById(id).orElseThrow();
    }

    public List<State> findAllStates() {
        return stateRepository.findAll();
    }

    public State updateState(State state) {
        State updatedState = stateRepository.findById(state.getId()).orElseThrow();
        updatedState.setName(state.getName());
        updatedState.setCountry(state.getCountry());
        return updatedState;
    }

    public void deleteState(Long id) {
        stateRepository.deleteById(id);
    }
}
