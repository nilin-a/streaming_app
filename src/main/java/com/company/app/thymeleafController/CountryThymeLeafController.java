package com.company.app.thymeleafController;

import com.company.app.service.storedDataService.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/thyme/countries")
public class CountryThymeLeafController {
    private final CountryService countryService;

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("countries", countryService.findAllCountries());
        return "country";
    }
}
