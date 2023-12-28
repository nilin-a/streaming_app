package com.company.app.thymeleafController;

import com.company.app.service.storedDataService.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/thyme/cities")
public class CityThymeLeafController {
    private final CityService cityService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("cities", cityService.findAllCities());
        return "city";
    }
}
