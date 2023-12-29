package com.company.app.controller.thymeleafController;

import com.company.app.dto.storedDataDTO.CountryDTO;
import com.company.app.dto.storedDataDTO.GenreDTO;
import com.company.app.service.storedDataService.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
