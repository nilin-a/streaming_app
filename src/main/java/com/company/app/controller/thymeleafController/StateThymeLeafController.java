package com.company.app.controller.thymeleafController;

import com.company.app.dto.storedDataDTO.CountryDTO;
import com.company.app.dto.storedDataDTO.StateDTO;
import com.company.app.service.storedDataService.CountryService;
import com.company.app.service.storedDataService.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/thyme/states")
public class StateThymeLeafController {
    private final StateService stateService;
    private final CountryService countryService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("states", stateService.findAllStates());
        model.addAttribute("newState", new StateDTO());
        model.addAttribute("availableCountries", countryService.findAllCountries());
        return "state";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("state") StateDTO stateDTO, @RequestParam("selectedCountry") Long selectedCountryId) {
        stateDTO.setCountry(countryService.findCountry(selectedCountryId));
        stateService.createState(stateDTO);
        return "redirect:/thyme/states";
    }
}
