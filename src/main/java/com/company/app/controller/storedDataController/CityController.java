package com.company.app.controller.storedDataController;

import com.company.app.model.storedDataModel.City;
import com.company.app.service.storedDataService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("/{stateId}")
    public City create(@PathVariable Long stateId, @RequestBody City city) {
        return cityService.createCity(stateId, city);
    }

    @GetMapping("/{id}")
    public City find(@PathVariable Long id) {
        return cityService.findCity(id);
    }

    @GetMapping
    public List<City> findAll() {
        return cityService.findAllCities();
    }

    @PutMapping
    public City update(@RequestBody City city) {
        return cityService.updateCity(city);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}

