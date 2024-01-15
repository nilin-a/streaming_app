package com.simbirsoft.performer.controller.thymeleafController;

import com.simbirsoft.performer.dto.storedDataDTO.CountryDTO;
import com.simbirsoft.performer.service.storedDataService.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/thyme/countries")
public class CountryThymeLeafController {
    private final CountryService countryService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("countries", countryService.findAllCountries());
        model.addAttribute("newCountry", new CountryDTO());
        return "country";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("country") CountryDTO countryDTO) {
        countryService.createCountry(countryDTO);
        return "redirect:/thyme/countries";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long countryId, Model model) {
        model.addAttribute("country", countryService.findCountry(countryId));
        return "update-country";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("country") CountryDTO countryDTO) {
        countryService.updateCountry(countryDTO);
        return "redirect:/thyme/countries";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long countryId) {
        countryService.deleteCountry(countryId);
        return "redirect:/thyme/countries";
    }
}
