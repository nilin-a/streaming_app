package com.company.app.controller.thymeleafController;

import com.company.app.dto.storedDataDTO.CityDTO;
import com.company.app.dto.storedDataDTO.StateDTO;
import com.company.app.service.storedDataService.CityService;
import com.company.app.service.storedDataService.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/thyme/cities")
public class CityThymeLeafController {
    private final CityService cityService;
    private final StateService stateService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("cities", cityService.findAllCities());
        model.addAttribute("newCity", new CityDTO());
        model.addAttribute("availableStates", stateService.findAllStates());
        return "city";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("city") CityDTO cityDTO, @RequestParam("selectedState") Long selectedStateId) {
        cityDTO.setState(stateService.findState(selectedStateId));
        cityService.createCity(cityDTO);
        return "redirect:/thyme/cities";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long cityId, Model model) {
        model.addAttribute("city", cityService.findCity(cityId));
        model.addAttribute("availableSates", stateService.findAllStates());
        return "update-city";
    }

    @PutMapping("/update")
    public String update(@ModelAttribute("city") CityDTO cityDTO,
                         @RequestParam("selectedState") Long stateId) {
        cityDTO.setState(stateService.findState(stateId));
        cityService.updateCity(cityDTO);
        return "redirect:/thyme/cities";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long cityId) {
        cityService.deleteCity(cityId);
        return "redirect:/thyme/cities";
    }
}
