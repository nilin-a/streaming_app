package com.company.app.controller.storedDataController;

import com.company.app.dto.storedDataDTO.CityDTO;
import com.company.app.service.storedDataService.CityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cities")
@Tag(name = "City Service", description = "Service for managing cities")
public class CityController {
    private final CityService cityService;

    @Operation(summary = "Create city")
    @PostMapping()
    public CityDTO create(@RequestBody CityDTO city) {
        return cityService.createCity(city);
    }

    @Operation(summary = "Get city")
    @GetMapping("/{id}")
    public CityDTO find(@PathVariable Long id) {
        return cityService.findCity(id);
    }

    @Operation(summary = "Get all cities")
    @GetMapping
    public List<CityDTO> findAll() {
        return cityService.findAllCities();
    }

    @Operation(summary = "Update city")
    @PutMapping
    public CityDTO update(@RequestBody CityDTO city) {
        return cityService.updateCity(city);
    }

    @Operation(summary = "Delete city")
    @DeleteMapping("/{id}")
    public CityDTO delete(@PathVariable Long id) {
        return cityService.deleteCity(id);
    }
}

