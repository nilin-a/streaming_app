package com.company.app.controller.storedDataController;

import com.company.app.model.storedDataModel.State;
import com.company.app.service.storedDataService.StateService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {
    @Autowired
    private StateService stateService;

    @PostMapping("/{countryId}")
    public State create(@PathVariable Long countryId, @RequestBody State state) {
        return stateService.createState(countryId, state);
    }

    @GetMapping("/{id}")
    public State find(@PathVariable Long id) {
        return stateService.findState(id);
    }

    @GetMapping
    public List<State> findAll() {
        return stateService.findAllStates();
    }

    @PutMapping
    public State update(@RequestBody State state) {
        return stateService.updateState(state);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        stateService.deleteState(id);
    }
}
