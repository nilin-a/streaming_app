package com.company.app.controller.storedDataController;

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
    public State create(@RequestBody State state) {
        return stateService.createState(state);
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
