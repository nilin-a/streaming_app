package com.company.app.controller.storedDataController;

import com.company.app.model.storedDataModel.State;
import com.company.app.service.storedDataService.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {
    @Autowired
    private StateService stateService;

    @GetMapping
    public List<State> findAll() {
        return stateService.findAllStates();
    }

    @GetMapping("/{id}")
    public State find(@PathVariable Long id) {
        return stateService.findState(id);
    }

    @PostMapping
    public State create(@RequestBody State state) {
        return stateService.createState(state);
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
