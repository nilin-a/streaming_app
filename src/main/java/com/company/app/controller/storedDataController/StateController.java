package com.company.app.controller.storedDataController;

import com.company.app.dto.storedDataDTO.StateDTO;
import com.company.app.model.storedDataModel.State;
import com.company.app.service.storedDataService.StateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/states")
public class StateController {
    private final StateService stateService;

    @PostMapping()
    public StateDTO create(@RequestBody StateDTO state) {
        return stateService.createState(state);
    }

    @GetMapping("/{id}")
    public StateDTO find(@PathVariable Long id) {
        return stateService.findState(id);
    }

    @GetMapping
    public List<StateDTO> findAll() {
        return stateService.findAllStates();
    }

    @PutMapping
    public StateDTO update(@RequestBody StateDTO state) {
        return stateService.updateState(state);
    }

    @DeleteMapping("/{id}")
    public StateDTO delete(@PathVariable Long id) {
        return stateService.deleteState(id);
    }
}
