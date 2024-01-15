package com.company.app.controller.storedDataController;

import com.company.app.dto.storedDataDTO.StateDTO;
import com.company.app.model.storedDataModel.State;
import com.company.app.service.storedDataService.StateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/states")
@Tag(name = "State Service", description = "Service for managing states")
public class StateController {
    private final StateService stateService;

    @Operation(summary = "Create state")
    @PostMapping()
    public StateDTO create(@RequestBody StateDTO state) {
        return stateService.createState(state);
    }

    @Operation(summary = "Get state")
    @GetMapping("/{id}")
    public StateDTO find(@PathVariable Long id) {
        return stateService.findState(id);
    }

    @Operation(summary = "Get all states")
    @GetMapping
    public List<StateDTO> findAll() {
        return stateService.findAllStates();
    }

    @Operation(summary = "Update state")
    @PutMapping
    public StateDTO update(@RequestBody StateDTO state) {
        return stateService.updateState(state);
    }

    @Operation(summary = "Delete state")
    @DeleteMapping("/{id}")
    public StateDTO delete(@PathVariable Long id) {
        return stateService.deleteState(id);
    }
}
