package com.company.app.controller.storedDataController;

import com.company.app.model.storedDataModel.Country;
import com.company.app.service.storedDataService.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    @PostMapping
    public Country create(@RequestBody Country country) {
        return countryService.createCountry(country);
    }

    @GetMapping("/{id}")
    public Country find(@PathVariable Long id) {
        return countryService.findCountry(id);
    }

    @GetMapping()
    public List<Country> findAll() {
        return countryService.findAllCountries();
    }

    @PutMapping
    public Country update(@RequestBody Country country) {
        return countryService.updateCountry(country);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}
