package com.company.app.controller.storedDataController;

import com.company.app.dto.storedDataDTO.CountryDTO;
import com.company.app.model.storedDataModel.Country;
import com.company.app.service.storedDataService.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/countries")
@Tag(name = "Country Service", description = "Service for managing countries")
public class CountryController {
    private final CountryService countryService;

    @Operation(summary = "Create country")
    @PostMapping
    public CountryDTO create(@RequestBody CountryDTO country) {
        return countryService.createCountry(country);
    }

    @Operation(summary = "Get country")
    @GetMapping("/{id}")
    public CountryDTO find(@PathVariable Long id) {
        return countryService.findCountry(id);
    }

    @Operation(summary = "Get all countries")
    @GetMapping()
    public List<CountryDTO> findAll() {
        return countryService.findAllCountries();
    }

    @Operation(summary = "Update country")
    @PutMapping
    public CountryDTO update(@RequestBody CountryDTO country) {
        return countryService.updateCountry(country);
    }

    @Operation(summary = "Delete country")
    @DeleteMapping("/{id}")
    public CountryDTO deleteById(@PathVariable Long id) {
        return countryService.deleteCountry(id);
    }
}
