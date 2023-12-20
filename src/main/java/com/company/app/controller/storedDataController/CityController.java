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

    @GetMapping
    public List<City> findAll() {
        return cityService.findAllCities();
    }

    @GetMapping("/{id}")
    public City find(@PathVariable Long id) {
        return cityService.findCity(id);
    }

    @PostMapping
    public City create(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @PutMapping
    public City update(@RequestBody City city) {
        return cityService.updateCity(city);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}

