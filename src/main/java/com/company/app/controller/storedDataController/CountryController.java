package com.company.app.controller.storedDataController;

import com.company.app.model.storedDataModel.Country;
import com.company.app.service.storedDataService.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping()
    public List<Country> findAll() {
        return countryService.findAllCountries();
    }

    @GetMapping("/{id}")
    public Country findById(@PathVariable Long id) {
        return countryService.findCountry(id);
    }

    @PostMapping
    public Country create(@RequestBody Country country) {
        return countryService.createCountry(country);
    }

    @PutMapping
    public Country update(@RequestBody Country country) {
        return  countryService.updateCountry(country);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}
