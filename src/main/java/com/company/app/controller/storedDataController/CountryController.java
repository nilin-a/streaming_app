package com.company.app.controller.storedDataController;

import com.company.app.dto.storedDataDTO.CountryDTO;
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
    public CountryDTO create(@RequestBody CountryDTO country) {
        return countryService.createCountry(country);
    }

    @GetMapping("/{id}")
    public CountryDTO find(@PathVariable Long id) {
        return countryService.findCountry(id);
    }

    @GetMapping()
    public List<CountryDTO> findAll() {
        return countryService.findAllCountries();
    }

    @PutMapping
    public CountryDTO update(@RequestBody CountryDTO country) {
        return countryService.updateCountry(country);
    }

    @DeleteMapping("/{id}")
    public CountryDTO deleteById(@PathVariable Long id) {
        return countryService.deleteCountry(id);
    }
}
