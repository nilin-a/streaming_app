package com.company.app.controller.storedDataController;

import com.company.app.dto.storedDataDTO.CityDTO;
import com.company.app.model.storedDataModel.City;
import com.company.app.service.storedDataService.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    @PostMapping()
    public CityDTO create(@RequestBody CityDTO city) {
        return cityService.createCity(city);
    }

    @GetMapping("/{id}")
    public CityDTO find(@PathVariable Long id) {
        return cityService.findCity(id);
    }

    @GetMapping
    public List<CityDTO> findAll() {
        return cityService.findAllCities();
    }

    @PutMapping
    public CityDTO update(@RequestBody CityDTO city) {
        return cityService.updateCity(city);
    }

    @DeleteMapping("/{id}")
    public CityDTO delete(@PathVariable Long id) {
        return cityService.deleteCity(id);
    }
}

