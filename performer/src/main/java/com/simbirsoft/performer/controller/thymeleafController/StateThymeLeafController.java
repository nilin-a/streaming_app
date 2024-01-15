package com.simbirsoft.performer.controller.thymeleafController;

import com.simbirsoft.performer.dto.storedDataDTO.StateDTO;
import com.simbirsoft.performer.service.storedDataService.CountryService;
import com.simbirsoft.performer.service.storedDataService.StateService;
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

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long stateId, Model model) {
        model.addAttribute("state", stateService.findState(stateId));
        model.addAttribute("availableCountries", countryService.findAllCountries());
        return "update-state";
    }

    @PutMapping("/update")
    public String update(@ModelAttribute("state") StateDTO stateDTO,
                         @RequestParam("selectedCountry") Long selectedCountry) {
        stateDTO.setCountry(countryService.findCountry(selectedCountry));
        stateService.updateState(stateDTO);
        return "redirect:/thyme/states";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long stateId) {
        stateService.deleteState(stateId);
        return "redirect:/thyme/states";
    }
}
